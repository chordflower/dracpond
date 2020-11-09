@file:Suppress("UNCHECKED_CAST")

package cc.chordflower.dracpond

import cc.chordflower.dracpond.application.arguments.Arguments
import cc.chordflower.dracpond.application.config.Configuration
import cc.chordflower.dracpond.application.config.fromNode
import cc.chordflower.dracpond.application.events.Event.AfterParseArgumentsEvent
import cc.chordflower.dracpond.application.events.Event.AfterParseConfigurationEvent
import cc.chordflower.dracpond.application.events.Event.BeforeParseArgumentsEvent
import cc.chordflower.dracpond.application.events.Event.BeforeStartEvent
import cc.chordflower.dracpond.utils.currentEnvPath
import com.beust.jcommander.JCommander
import com.google.common.base.Strings
import com.google.common.eventbus.EventBus
import io.vertx.config.ConfigRetriever
import io.vertx.config.ConfigRetrieverOptions
import io.vertx.config.ConfigStoreOptions
import io.vertx.core.AsyncResult
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import org.apache.deltaspike.cdise.api.CdiContainerLoader
import org.apache.deltaspike.core.api.provider.BeanProvider
import org.slf4j.bridge.SLF4JBridgeHandler
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import javax.enterprise.context.ApplicationScoped

class DracpondApp(vararg args: String) : Runnable {
  private val args: Array<String> = args as Array<String>

  enum class ConfigurationFileFormats(val format: String) {
    YAML("yaml"),
    JSON("json"),
    UNKNOWN("unknown")
  }

  private fun getFormatForFile(fileName: Path): String {
    return ConfigurationFileFormats.valueOf(
      fileName.fileName?.toString()?.split(".")?.get(1)?.toUpperCase() ?: "UNKNOWN").format
  }

  override fun run() {
    SLF4JBridgeHandler.removeHandlersForRootLogger()
    SLF4JBridgeHandler.install()
    val cdiContainer = CdiContainerLoader.getCdiContainer()
    cdiContainer.boot()
    val contextControl = cdiContainer.contextControl
    contextControl.startContext(ApplicationScoped::class.java)

    // Emit before start event
    val eventBus = BeanProvider.getContextualReference(EventBus::class.java)
    eventBus.post(BeforeStartEvent())

    // Emit before parse arguments event (together with the arguments)
    eventBus.post(BeforeParseArgumentsEvent(io.vavr.collection.Array.of(*args)))

    // Parse arguments
    val arguments = Arguments()
    //@formatter:off
        JCommander.newBuilder()
        .addObject(arguments)
        .acceptUnknownOptions(false)
        .allowAbbreviatedOptions(true)
        .programName("Dracpond")
        .build()
        .parse(*args)
            //@formatter:on

    // Emit parse arguments event (together with the parsed arguments)
    eventBus.post(AfterParseArgumentsEvent(arguments))

    // Parse configuration
    val vertx = Vertx.vertx()
    val options = ConfigRetrieverOptions().setIncludeDefaultStores(false)
    if(!Strings.isNullOrEmpty(arguments.config) && Files.exists(Paths.get(arguments.config))) {
      options.addStore(
        ConfigStoreOptions()
          .setType("file")
          .setFormat(getFormatForFile(Paths.get(arguments.config).fileName))
          .setOptional(false)
          .setConfig(JsonObject().put("path", arguments.config)))
    } else {
      options.addStore(jsonFileConfigStore.setConfig(JsonObject().put("path", "./config.json")))
        .addStore(yamlFileConfigStore.setConfig(JsonObject().put("path", "./config.yaml")))
        .addStore(jsonFileConfigStore.setConfig(JsonObject().put("path",
          Paths.get(currentEnvPath.systemConfigPath.toString(), "config.json"))))
        .addStore(jsonFileConfigStore.setConfig(JsonObject().put("path",
          Paths.get(currentEnvPath.systemConfigPath.toString(), "config.yaml"))))
        .addStore(jsonFileConfigStore.setConfig(JsonObject().put("path",
          Paths.get(currentEnvPath.userConfigPath.toString(), "config.json"))))
        .addStore(jsonFileConfigStore.setConfig(JsonObject().put("path",
          Paths.get(currentEnvPath.userConfigPath.toString(), "config.yaml"))))
    }
    options.addStore(environmentConfigStore)
    options.scanPeriod = Long.MAX_VALUE

    Runtime.getRuntime().addShutdownHook(Thread {
      // Emit the before stop vertexs event

      // Stop the vertxes

      // Emit the shutdown event
      cdiContainer.shutdown()
    })

    val retriever = ConfigRetriever.create(vertx, options)
    retriever.getConfig { json: AsyncResult<JsonObject> ->
      println(json.result().toString())
      val config: Configuration = fromNode(json.result())

      // Emit the after parse configuration event (together with the parsed configuration)
      eventBus.post(AfterParseConfigurationEvent(config))

      // Initialize logging

      // Emit the after logging configuration event

      // Get the vertxes to run

      // Emit the before start vertxes event (with the vertx list)

      // Start the vertxes

      // Emit the after start vertxes event
    }
  }

  companion object {
    val environmentConfigStore: ConfigStoreOptions
      get() = ConfigStoreOptions().setType("env").setConfig(JsonObject().put("raw-data", true))
    val jsonFileConfigStore: ConfigStoreOptions
      get() = ConfigStoreOptions().setType("file").setFormat("json")
    val yamlFileConfigStore: ConfigStoreOptions
      get() = ConfigStoreOptions().setType("file").setFormat("yaml")

    @JvmStatic fun main(args: Array<String>) {
      val app = DracpondApp(*args)
      app.run()
    }
  }

}
