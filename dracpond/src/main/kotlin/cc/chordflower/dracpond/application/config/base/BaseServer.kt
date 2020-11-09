package cc.chordflower.dracpond.application.config.base

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import io.vavr.control.Option
import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import java.io.Serializable
import java.math.BigInteger

/**
 * Server related properties
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("address", "port", "background", "certificate", "key", "logToFile", "session", "limits")
class BaseServer(
  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty("address")
  @JsonPropertyDescription("The address the server should listen to it must be an ip address")
  private var address: String,
  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty("port")
  @JsonPropertyDescription("The port the server should listen to (default is a random available port)")
  private var port: @DecimalMin(value = "0") @DecimalMax(value = "65535") BigInteger?,
  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty("certificate")
  @JsonPropertyDescription("The certificate (public key) to use by the server (activates tls)")
  private var certificate: String?,
  /**
   * The private key to use by the server
   */
  @JsonProperty("key")
  @JsonPropertyDescription("The private key to use by the server")
  private var key: String?,
  /**
   * Configuration related to the session
   */
  @JsonProperty("session")
  @JsonPropertyDescription("Configuration related to the session")
  private var session: @Valid BaseSession?,
  /**
   * Several server limit configurations
   */
  @JsonProperty("limits")
  @JsonPropertyDescription("Several server limit configurations")
  private var limits: @Valid BaseLimits?
) : Serializable {

  constructor(): this("127.0.0.1", BigInteger.ZERO, null, null, BaseSession(), BaseLimits())

  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty("address")
  fun getAddress(): Option<String> {
    return Option.of(address)
  }

  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty("address")
  fun setAddress(address: String) {
    this.address = address
  }

  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty("port")
  fun getPort(): Option<BigInteger> {
    return Option.of(port)
  }

  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty("port")
  fun setPort(port: BigInteger) {
    this.port = port
  }

  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty("certificate")
  fun getCertificate(): Option<String> {
    return Option.of(certificate)
  }

  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty("certificate")
  fun setCertificate(certificate: String) {
    this.certificate = certificate
  }

  /**
   * The private key to use by the server
   */
  @JsonProperty("key")
  fun getKey(): Option<String> {
    return Option.of(key)
  }

  /**
   * The private key to use by the server
   */
  @JsonProperty("key")
  fun setKey(key: String) {
    this.key = key
  }

  /**
   * Configuration related to the session
   */
  @JsonProperty("session")
  fun getSession(): Option<BaseSession> {
    return Option.of(session)
  }

  /**
   * Configuration related to the session
   */
  @JsonProperty("session")
  fun setSession(session: BaseSession) {
    this.session = session
  }

  /**
   * Several server limit configurations
   */
  @JsonProperty("limits")
  fun getLimits(): Option<BaseLimits> {
    return Option.of(limits)
  }

  /**
   * Several server limit configurations
   */
  @JsonProperty("limits")
  fun setLimits(limits: BaseLimits) {
    this.limits = limits
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseServer

    if(address != other.address) return false
    if(port != other.port) return false
    if(certificate != other.certificate) return false
    if(key != other.key) return false
    if(session != other.session) return false
    if(limits != other.limits) return false
    return true
  }

  override fun hashCode(): Int {
    var result = address.hashCode()
    result = 31 * result + (port?.hashCode() ?: 0)
    result = 31 * result + (certificate?.hashCode() ?: 0)
    result = 31 * result + (key?.hashCode() ?: 0)
    result = 31 * result + (session?.hashCode() ?: 0)
    result = 31 * result + (limits?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return """{"address"="$address", port=$port, "certificate"="$certificate", "key"="$key", "session"="$session", "limits"=$limits)"""
  }


  companion object {
    private const val serialVersionUID = 4478287594587692598L
  }
}
