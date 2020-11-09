package cc.chordflower.dracpond.application.config.base

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import io.vavr.collection.Array
import io.vavr.collection.Seq
import io.vavr.control.Option
import jakarta.validation.Valid
import java.io.Serializable

/**
 * Schema for the configuration file
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("\$schema", "server", "loggly", "database", "proxy", "discovery", "redis", "management", "mail")
open class BaseConfigSchema : Serializable {

  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty("\$schema")
  @JsonPropertyDescription("the configuration schema always a reference to this document")
  private var schema: String? = null

  /**
   * Server related properties
   */
  @JsonProperty("server")
  @JsonPropertyDescription("Server related properties")
  private var server: @Valid BaseServer? = null

  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty("loggly")
  @JsonPropertyDescription("Definitions related to the loggly log server")
  private var loggly: @Valid BaseLoggly? = null

  /**
   * Definitions related to the arango database
   */
  @JsonProperty("database")
  @JsonPropertyDescription("Definitions related to the arango database")
  private var database: @Valid BaseDatabase? = null

  /**
   * The proxy to use for remote connections
   */
  @JsonProperty("proxy")
  @JsonPropertyDescription("The proxy to use for remote connections")
  private var proxy: @Valid Seq<BaseProxy> = Array.empty()

  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty("discovery")
  @JsonPropertyDescription("Definitions related to the registration in a consul server")
  private var discovery: @Valid BaseDiscovery? = null

  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty("redis")
  @JsonPropertyDescription("Definitions related to the redis server used for cache")
  private var redis: @Valid BaseRedis? = null

  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty("management")
  @JsonPropertyDescription("Describes the management configuration used to control the server")
  private var management: @Valid BaseManagement? = null

  /**
   * Information about the smtp server to use
   */
  @JsonProperty("mail")
  @JsonPropertyDescription("Information about the smtp server to use")
  private var mail: @Valid BaseMail? = null

  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty("\$schema")
  fun getSchema(): Option<String> {
    return Option.of(schema)
  }

  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty("\$schema")
  fun setSchema(schema: String) {
    this.schema = schema
  }

  /**
   * Server related properties
   */
  @JsonProperty("server")
  fun getServer(): Option<BaseServer> {
    return Option.of(server)
  }

  /**
   * Server related properties
   */
  @JsonProperty("server")
  fun setServer(server: BaseServer) {
    this.server = server
  }

  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty("loggly")
  fun getLoggly(): Option<BaseLoggly> {
    return Option.of(loggly)
  }

  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty("loggly")
  fun setLoggly(loggly: BaseLoggly) {
    this.loggly = loggly
  }

  /**
   * Definitions related to the arango database
   */
  @JsonProperty("database")
  fun getDatabase(): Option<BaseDatabase> {
    return Option.of(database)
  }

  /**
   * Definitions related to the arango database
   */
  @JsonProperty("database")
  fun setDatabase(database: BaseDatabase) {
    this.database = database
  }

  /**
   * The proxy to use for remote connections
   */
  @JsonProperty("proxy")
  fun getProxy(): Option<Seq<BaseProxy>> {
    return Option.of(proxy)
  }

  /**
   * The proxy to use for remote connections
   */
  @JsonProperty("proxy")
  fun setProxy(proxy: Seq<BaseProxy>) {
    this.proxy = proxy
  }

  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty("discovery")
  fun getDiscovery(): Option<BaseDiscovery> {
    return Option.of(discovery)
  }

  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty("discovery")
  fun setDiscovery(discovery: BaseDiscovery) {
    this.discovery = discovery
  }

  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty("redis")
  fun getRedis(): Option<BaseRedis> {
    return Option.of(redis)
  }

  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty("redis")
  fun setRedis(redis: BaseRedis) {
    this.redis = redis
  }

  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty("management")
  fun getManagement(): Option<BaseManagement> {
    return Option.of(management)
  }

  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty("management")
  fun setManagement(management: BaseManagement) {
    this.management = management
  }

  /**
   * Information about the smtp server to use
   */
  @JsonProperty("mail")
  fun getMail(): Option<BaseMail> {
    return Option.of(mail)
  }

  /**
   * Information about the smtp server to use
   */
  @JsonProperty("mail")
  fun setMail(mail: BaseMail) {
    this.mail = mail
  }

  companion object {
    private const val serialVersionUID = 5219335981721220472L
  }
}
