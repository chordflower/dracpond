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
 * The definition of a single proxy
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("enabled", "type", "host", "port", "username", "password", "except")
class BaseProxy(
  /**
   * If the proxy is enabled
   */
  @JsonProperty("enabled") @JsonPropertyDescription("If the proxy is enabled")
  private var enabled: Boolean,
  /**
   * The protocol to use this proxy for
   */
  @JsonProperty("type")
  @JsonPropertyDescription("The protocol to use this proxy for")
  private var proxyType: ProxyType?,
  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty("host")
  @JsonPropertyDescription("The host of this proxy (Include schema)")
  private var host: String?,
  /**
   * The proxy port
   */
  @JsonProperty("port")
  @JsonPropertyDescription("The proxy port")
  private var port: @DecimalMin(value = "1") @DecimalMax(value = "65535") BigInteger?,
  /**
   * The username to connect to this proxy
   */
  @JsonProperty("username")
  @JsonPropertyDescription("The username to connect to this proxy")
  private var username: String?,
  /**
   * The password of the user
   */
  @JsonProperty("password")
  @JsonPropertyDescription("The password of the user")
  private var password: String?,
  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty("except")
  @JsonPropertyDescription("List of domain exceptions that do not pass into this proxy")
  private var except: @Valid Seq<String>
) : Serializable {

  constructor(): this(true, ProxyType.HTTP, null, BigInteger.valueOf(8500), null, null, Array.empty())

  /**
   * If the proxy is enabled
   */
  @JsonProperty("enabled")
  fun getEnabled(): Option<Boolean> {
    return Option.of(enabled)
  }

  /**
   * If the proxy is enabled
   */
  @JsonProperty("enabled")
  fun setEnabled(enabled: Boolean) {
    this.enabled = enabled
  }

  /**
   * The protocol to use this proxy for
   */
  @JsonProperty("type")
  fun getType(): Option<ProxyType> {
    return Option.of(proxyType)
  }

  /**
   * The protocol to use this proxy for
   */
  @JsonProperty("type")
  fun setType(proxyType: ProxyType) {
    this.proxyType = proxyType
  }

  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty("host")
  fun getHost(): Option<String> {
    return Option.of(host)
  }

  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty("host")
  fun setHost(host: String) {
    this.host = host
  }

  /**
   * The proxy port
   */
  @JsonProperty("port")
  fun getPort(): Option<BigInteger> {
    return Option.of(port)
  }

  /**
   * The proxy port
   */
  @JsonProperty("port")
  fun setPort(port: BigInteger) {
    this.port = port
  }

  /**
   * The username to connect to this proxy
   */
  @JsonProperty("username")
  fun getUsername(): Option<String> {
    return Option.of(username)
  }

  /**
   * The username to connect to this proxy
   */
  @JsonProperty("username")
  fun setUsername(username: String) {
    this.username = username
  }

  /**
   * The password of the user
   */
  @JsonProperty("password")
  fun getPassword(): Option<String> {
    return Option.of(password)
  }

  /**
   * The password of the user
   */
  @JsonProperty("password")
  fun setPassword(password: String) {
    this.password = password
  }

  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty("except")
  fun getExcept(): Option<Seq<String>> {
    return Option.of(except)
  }

  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty("except")
  fun setExcept(except: Seq<String>) {
    this.except = except
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseProxy

    if(enabled != other.enabled) return false
    if(proxyType != other.proxyType) return false
    if(host != other.host) return false
    if(port != other.port) return false
    if(username != other.username) return false
    if(password != other.password) return false
    if(except != other.except) return false

    return true
  }

  override fun hashCode(): Int {
    var result = enabled.hashCode()
    result = 31 * result + (proxyType?.hashCode() ?: 0)
    result = 31 * result + (host?.hashCode() ?: 0)
    result = 31 * result + (port?.hashCode() ?: 0)
    result = 31 * result + (username?.hashCode() ?: 0)
    result = 31 * result + (password?.hashCode() ?: 0)
    result = 31 * result + except.hashCode()
    return result
  }

  override fun toString(): String {
    return """{"enabled"=$enabled, "type"="$proxyType", "host"="$host", "port"=$port, "username"="$username", "password"="$password", "except"=$except)"""
  }

  companion object {
    private const val serialVersionUID = 7282559565066102059L
  }
}
