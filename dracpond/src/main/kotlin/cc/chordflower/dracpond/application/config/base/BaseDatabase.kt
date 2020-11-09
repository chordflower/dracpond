package cc.chordflower.dracpond.application.config.base

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import io.vavr.control.Option
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import java.io.Serializable
import java.math.BigInteger

/**
 * Definitions related to the arango database
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("host", "port", "secure", "username", "password")
class BaseDatabase(
  /**
   * The arangodb host
   */
  @JsonProperty("host")
  @JsonPropertyDescription("The arangodb host")
  private var host: String,
  /**
   * The arangodb server port
   */
  @JsonProperty("port")
  @JsonPropertyDescription("The arangodb server port")
  private var port: @DecimalMin(value = "1") @DecimalMax(value = "65535") BigInteger,
  /**
   * Enable tls connection
   */
  @JsonProperty("secure")
  @JsonPropertyDescription("Enable tls connection")
  private var secure: Boolean,
  /**
   * The username to login to the arangodb server
   */
  @JsonProperty("username")
  @JsonPropertyDescription("The username to login to the arangodb server")
  private var username: String?,
  /**
   * The password of the given username
   */
  @JsonProperty("password")
  @JsonPropertyDescription("The password of the given username")
  private var password: String?
) : Serializable {

  constructor(): this("localhost", BigInteger("2345"), false, null, null)

  /**
   * The arangodb host
   */
  @JsonProperty("host")
  fun getHost(): Option<String> {
    return Option.of(host)
  }

  /**
   * The arangodb host
   */
  @JsonProperty("host")
  fun setHost(host: String) {
    this.host = host
  }

  /**
   * The arangodb server port
   */
  @JsonProperty("port")
  fun getPort(): Option<BigInteger> {
    return Option.of(port)
  }

  /**
   * The arangodb server port
   */
  @JsonProperty("port")
  fun setPort(port: BigInteger) {
    this.port = port
  }

  /**
   * Enable tls connection
   */
  @JsonProperty("secure")
  fun getSecure(): Option<Boolean> {
    return Option.of(secure)
  }

  /**
   * Enable tls connection
   */
  @JsonProperty("secure")
  fun setSecure(secure: Boolean) {
    this.secure = secure
  }

  /**
   * The username to login to the arangodb server
   */
  @JsonProperty("username")
  fun getUsername(): Option<String> {
    return Option.of(username)
  }

  /**
   * The username to login to the arangodb server
   */
  @JsonProperty("username")
  fun setUsername(username: String) {
    this.username = username
  }

  /**
   * The password of the given username
   */
  @JsonProperty("password")
  fun getPassword(): Option<String> {
    return Option.of(password)
  }

  /**
   * The password of the given username
   */
  @JsonProperty("password")
  fun setPassword(password: String) {
    this.password = password
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseDatabase

    if(host != other.host) return false
    if(port != other.port) return false
    if(secure != other.secure) return false
    if(username != other.username) return false
    if(password != other.password) return false

    return true
  }

  override fun hashCode(): Int {
    var result = host.hashCode()
    result = 31 * result + port.hashCode()
    result = 31 * result + secure.hashCode()
    result = 31 * result + (username?.hashCode() ?: 0)
    result = 31 * result + (password?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return """{"host"="$host", "port"=$port, "secure"=$secure, "username"="$username", "password"="$password"}"""
  }


  companion object {
    private const val serialVersionUID = -6805001319856652238L
  }
}
