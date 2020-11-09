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
 * Definitions related to the redis server used for cache
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("host", "port", "password", "certificate", "key")
class BaseRedis(
  /**
   * The redis server location
   */
  @JsonProperty("host")
  @JsonPropertyDescription("The redis server location")
  private var host: String,
  /**
   * The redis server port
   */
  @JsonProperty("port")
  @JsonPropertyDescription("The redis server port")
  private var port: @DecimalMin(value = "1") @DecimalMax(value = "65535") BigInteger?,
  /**
   * The redis username password
   */
  @JsonProperty("password")
  @JsonPropertyDescription("The redis username password")
  private var password: String?,
  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty("certificate")
  @JsonPropertyDescription("The certificate (public key) to use for tls connection (activates tls)")
  private var certificate: String?,
  /**
   * The private key to use by the tls connection
   */
  @JsonProperty("key")
  @JsonPropertyDescription("The private key to use by the tls connection")
  private var key: String?
) : Serializable {

  constructor(): this("127.0.0.1", BigInteger.valueOf(6379), null, null, null)

  /**
   * The redis server location
   */
  @JsonProperty("host")
  fun getHost(): Option<String> {
    return Option.of(host)
  }

  /**
   * The redis server location
   */
  @JsonProperty("host")
  fun setHost(host: String) {
    this.host = host
  }

  /**
   * The redis server port
   */
  @JsonProperty("port")
  fun getPort(): Option<BigInteger> {
    return Option.of(port)
  }

  /**
   * The redis server port
   */
  @JsonProperty("port")
  fun setPort(port: BigInteger) {
    this.port = port
  }

  /**
   * The redis username password
   */
  @JsonProperty("password")
  fun getPassword(): Option<String> {
    return Option.of(password)
  }

  /**
   * The redis username password
   */
  @JsonProperty("password")
  fun setPassword(password: String) {
    this.password = password
  }

  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty("certificate")
  fun getCertificate(): Option<String> {
    return Option.of(certificate)
  }

  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty("certificate")
  fun setCertificate(certificate: String) {
    this.certificate = certificate
  }

  /**
   * The private key to use by the tls connection
   */
  @JsonProperty("key")
  fun getKey(): Option<String> {
    return Option.of(key)
  }

  /**
   * The private key to use by the tls connection
   */
  @JsonProperty("key")
  fun setKey(key: String) {
    this.key = key
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseRedis

    if(host != other.host) return false
    if(port != other.port) return false
    if(password != other.password) return false
    if(certificate != other.certificate) return false
    if(key != other.key) return false

    return true
  }

  override fun hashCode(): Int {
    var result = host.hashCode()
    result = 31 * result + (port?.hashCode() ?: 0)
    result = 31 * result + (password?.hashCode() ?: 0)
    result = 31 * result + (certificate?.hashCode() ?: 0)
    result = 31 * result + (key?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return """{"host"="$host", "port"=$port, "password"="$password", "certificate"="$certificate", "key"="$key")"""
  }


  companion object {
    private const val serialVersionUID = -2052245701145607096L
  }
}
