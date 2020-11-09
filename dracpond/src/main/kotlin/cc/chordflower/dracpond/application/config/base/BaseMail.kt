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
 * Information about the smtp server to use
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("address", "port", "username", "password", "secure", "from")
class BaseMail(
  /**
   * The smtp server address
   */
  @JsonProperty("address")
  @JsonPropertyDescription("The smtp server address")
  private var address: String,
  /**
   * The port the smtp server
   */
  @JsonProperty("port")
  @JsonPropertyDescription("The port the smtp server")
  private var port: @DecimalMin(value = "1") @DecimalMax(value = "65535") BigInteger,
  /**
   * The smtp server username
   */
  @JsonProperty("username")
  @JsonPropertyDescription("The smtp server username")
  private var username: String?,
  /**
   * The smtp server username password
   */
  @JsonProperty("password")
  @JsonPropertyDescription("The smtp server username password")
  private var password: String?,
  /**
   * If a secure connection should be made
   */
  @JsonProperty("secure")
  @JsonPropertyDescription("If a secure connection should be made")
  private var secure: Boolean,
  /**
   * The email address that we should sent emails from
   */
  @JsonProperty("from")
  @JsonPropertyDescription("The email address that we should sent emails from")
  private var from: String
) : Serializable {

  constructor(): this("127.0.0.1", BigInteger.valueOf(654), null, null, false, "admin@example.com")

  /**
   * The smtp server address
   */
  @JsonProperty("address")
  fun getAddress(): Option<String> {
    return Option.of(address)
  }

  /**
   * The smtp server address
   */
  @JsonProperty("address") fun setAddress(address: String) {
    this.address = address
  }

  /**
   * The port the smtp server
   */
  @JsonProperty("port") fun getPort(): Option<BigInteger> {
    return Option.of(port)
  }

  /**
   * The port the smtp server
   */
  @JsonProperty("port") fun setPort(port: BigInteger) {
    this.port = port
  }

  /**
   * The smtp server username
   */
  @JsonProperty("username") fun getUsername(): Option<String> {
    return Option.of(username)
  }

  /**
   * The smtp server username
   */
  @JsonProperty("username") fun setUsername(username: String) {
    this.username = username
  }

  /**
   * The smtp server username password
   */
  @JsonProperty("password") fun getPassword(): Option<String> {
    return Option.of(password)
  }

  /**
   * The smtp server username password
   */
  @JsonProperty("password") fun setPassword(password: String) {
    this.password = password
  }

  /**
   * If a secure connection should be made
   */
  @JsonProperty("secure") fun getSecure(): Option<Boolean> {
    return Option.of(secure)
  }

  /**
   * If a secure connection should be made
   */
  @JsonProperty("secure") fun setSecure(secure: Boolean) {
    this.secure = secure
  }

  /**
   * The email address that we should sent emails from
   */
  @JsonProperty("from") fun getFrom(): Option<String> {
    return Option.of(from)
  }

  /**
   * The email address that we should sent emails from
   */
  @JsonProperty("from") fun setFrom(from: String) {
    this.from = from
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false
    other as BaseMail
    if(address != other.address) return false
    if(port != other.port) return false
    if(username != other.username) return false
    if(password != other.password) return false
    if(secure != other.secure) return false
    if(from != other.from) return false

    return true
  }

  override fun hashCode(): Int {
    var result = address.hashCode()
    result = 31 * result + port.hashCode()
    result = 31 * result + (username?.hashCode() ?: 0)
    result = 31 * result + (password?.hashCode() ?: 0)
    result = 31 * result + secure.hashCode()
    result = 31 * result + from.hashCode()
    return result
  }

  override fun toString(): String {
    return """{"address"="$address", "port"=$port, "username"="$username", "password"="$password", "secure"=$secure, "from"="$from")"""
  }


}
