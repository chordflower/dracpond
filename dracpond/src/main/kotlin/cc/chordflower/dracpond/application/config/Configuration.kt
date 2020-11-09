package cc.chordflower.dracpond.application.config

import cc.chordflower.dracpond.application.config.base.BaseConfigSchema
import io.vertx.core.json.JsonObject
import org.jetbrains.annotations.Contract

class Configuration : BaseConfigSchema() {

}

@Contract(pure = true)
fun fromNode(result: JsonObject?): Configuration {
  return Configuration()
}
