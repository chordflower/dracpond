package cc.chordflower.dracpond.application.config.base

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import io.vavr.collection.Array
import io.vavr.collection.Seq
import io.vavr.control.Option
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import java.io.Serializable
import java.math.BigInteger

/**
 * Definitions related to the registration in a consul server
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("enabled", "host", "port", "secure", "datacenter", "token", "ca")
class BaseDiscovery(
  /**
   * Enable the consul registration
   */
  @JsonProperty("enabled")
  @JsonPropertyDescription("Enable the consul registration")
  private var enabled: Boolean,
  /**
   * The location of the consul server
   */
  @JsonProperty("host")
  @JsonPropertyDescription("The location of the consul server")
  private var host: String,
  /**
   * The consul server port
   */
  @JsonProperty("port")
  @JsonPropertyDescription("The consul server port")
  private var port: @DecimalMin(value = "1") @DecimalMax(value = "65535") BigInteger?,
  /**
   * If a secure connection is needed
   */
  @JsonProperty("secure")
  @JsonPropertyDescription("If a secure connection is needed")
  private var secure: Boolean,
  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty("datacenter")
  @JsonPropertyDescription("The datacenter to use (defaults to local for agent)")
  private var datacenter: String?,
  /**
   * The token to use (defaults to none)
   */
  @JsonProperty("token")
  @JsonPropertyDescription("The token to use (defaults to none)")
  private var token: String?,
  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty("ca")
  @JsonPropertyDescription("The certificates to use in pem format (defaults to none)")
  private var ca: @Valid Seq<String>
) : Serializable {

  constructor() : this(false, "127.0.0.1", BigInteger.valueOf(8500), false, null, null, Array.empty())

  /**
   * Enable the consul registration
   */
  @JsonProperty("enabled")
  fun getEnabled(): Option<Boolean> {
    return Option.of(enabled)
  }

  /**
   * Enable the consul registration
   */
  @JsonProperty("enabled")
  fun setEnabled(enabled: Boolean) {
    this.enabled = enabled
  }

  /**
   * The location of the consul server
   */
  @JsonProperty("host")
  fun getHost(): Option<String> {
    return Option.of(host)
  }

  /**
   * The location of the consul server
   */
  @JsonProperty("host")
  fun setHost(host: String) {
    this.host = host
  }

  /**
   * The consul server port
   */
  @JsonProperty("port")
  fun getPort(): Option<BigInteger> {
    return Option.of(port)
  }

  /**
   * The consul server port
   */
  @JsonProperty("port")
  fun setPort(port: BigInteger) {
    this.port = port
  }

  /**
   * If a secure connection is needed
   */
  @JsonProperty("secure")
  fun getSecure(): Option<Boolean> {
    return Option.of(secure)
  }

  /**
   * If a secure connection is needed
   */
  @JsonProperty("secure")
  fun setSecure(secure: Boolean) {
    this.secure = secure
  }

  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty("datacenter")
  fun getDatacenter(): Option<String> {
    return Option.of(datacenter)
  }

  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty("datacenter")
  fun setDatacenter(datacenter: String) {
    this.datacenter = datacenter
  }

  /**
   * The token to use (defaults to none)
   */
  @JsonProperty("token")
  fun getToken(): Option<String> {
    return Option.of(token)
  }

  /**
   * The token to use (defaults to none)
   */
  @JsonProperty("token")
  fun setToken(token: String) {
    this.token = token
  }

  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty("ca")
  fun getCa(): Option<Seq<String>> {
    return Option.of(ca)
  }

  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty("ca")
  fun setCa(ca: Seq<String>) {
    this.ca = ca
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseDiscovery

    if(enabled != other.enabled) return false
    if(host != other.host) return false
    if(port != other.port) return false
    if(secure != other.secure) return false
    if(datacenter != other.datacenter) return false
    if(token != other.token) return false
    if(ca != other.ca) return false

    return true
  }

  override fun hashCode(): Int {
    var result = enabled.hashCode()
    result = 31 * result + host.hashCode()
    result = 31 * result + (port?.hashCode() ?: 0)
    result = 31 * result + secure.hashCode()
    result = 31 * result + (datacenter?.hashCode() ?: 0)
    result = 31 * result + (token?.hashCode() ?: 0)
    result = 31 * result + ca.hashCode()
    return result
  }

  override fun toString(): String {
    return """{"enabled"=$enabled, "host"="$host", "port"=$port, "secure"=$secure, "datacenter"="$datacenter", "token"="$token", "ca"=$ca}"""
  }

  companion object {
    private const val serialVersionUID = -618616054466136310L
  }
}
