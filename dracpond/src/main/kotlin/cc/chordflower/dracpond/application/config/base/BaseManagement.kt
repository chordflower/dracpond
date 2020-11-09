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
 * Describes the management configuration used to control the server
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("address", "port", "username", "password")
class BaseManagement(
  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty("address")
  @JsonPropertyDescription("The address the management server should listen to it must be an ip address")
  private var address: String,
  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty("port")
  @JsonPropertyDescription("The port the management server should listen to (default is a random available port)")
  private var port: @DecimalMin(value = "0") @DecimalMax(value = "65535") BigInteger,
  /**
   * The management server username
   */
  @JsonProperty("username")
  @JsonPropertyDescription("The management server username")
  private var username: String,
  /**
   * The management server username password
   */
  @JsonProperty("password")
  @JsonPropertyDescription("The management server username password")
  private var password: String
) : Serializable {

  constructor(): this("127.0.0.1", BigInteger.ZERO, "admin", "admin123")

  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty("address")
  fun getAddress(): Option<String> {
    return Option.of(address)
  }

  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty("address")
  fun setAddress(address: String) {
    this.address = address
  }

  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty("port")
  fun getPort(): Option<BigInteger> {
    return Option.of(port)
  }

  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty("port")
  fun setPort(port: BigInteger) {
    this.port = port
  }

  /**
   * The management server username
   */
  @JsonProperty("username")
  fun getUsername(): Option<String> {
    return Option.of(username)
  }

  /**
   * The management server username
   */
  @JsonProperty("username")
  fun setUsername(username: String) {
    this.username = username
  }

  /**
   * The management server username password
   */
  @JsonProperty("password")
  fun getPassword(): Option<String> {
    return Option.of(password)
  }

  /**
   * The management server username password
   */
  @JsonProperty("password")
  fun setPassword(password: String) {
    this.password = password
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseManagement

    if(address != other.address) return false
    if(port != other.port) return false
    if(username != other.username) return false
    if(password != other.password) return false

    return true
  }

  override fun hashCode(): Int {
    var result = address.hashCode()
    result = 31 * result + port.hashCode()
    result = 31 * result + username.hashCode()
    result = 31 * result + password.hashCode()
    return result
  }

  override fun toString(): String {
    return """{"address"="$address", "port"=$port, "username"="$username", "password"="$password")"""
  }

  companion object {
    private const val serialVersionUID = -5085971958169986509L
  }
}
