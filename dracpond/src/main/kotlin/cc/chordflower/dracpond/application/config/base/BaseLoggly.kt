package cc.chordflower.dracpond.application.config.base

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import io.vavr.control.Option
import java.io.Serializable

/**
 * Definitions related to the loggly log server
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("enabled", "subdomain", "token", "username", "password")
class BaseLoggly(
  /**
   * If the loggly logger is enabled
   */
  @JsonProperty("enabled")
  @JsonPropertyDescription("If the loggly logger is enabled")
  private var enabled: Boolean,
  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty("subdomain")
  @JsonPropertyDescription("The subdomain of your Loggly account")
  private var subdomain: String?,
  /**
   * The access token
   */
  @JsonProperty("token")
  @JsonPropertyDescription("The access token")
  private var token: String?,
  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty("username")
  @JsonPropertyDescription("The authentication information for your Loggly account (username)")
  private var username: String?,
  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty("password")
  @JsonPropertyDescription("The authentication information for your Loggly account (password)")
  private var password: String?
) : Serializable {

  constructor(): this(false, null, null, null, null)

  /**
   * If the loggly logger is enabled
   */
  @JsonProperty("enabled")
  fun getEnabled(): Option<Boolean> {
    return Option.of(enabled)
  }

  /**
   * If the loggly logger is enabled
   */
  @JsonProperty("enabled")
  fun setEnabled(enabled: Boolean) {
    this.enabled = enabled
  }

  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty("subdomain")
  fun getSubdomain(): Option<String> {
    return Option.of(subdomain)
  }

  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty("subdomain")
  fun setSubdomain(subdomain: String) {
    this.subdomain = subdomain
  }

  /**
   * The access token
   */
  @JsonProperty("token")
  fun getToken(): Option<String> {
    return Option.of(token)
  }

  /**
   * The access token
   */
  @JsonProperty("token")
  fun setToken(token: String) {
    this.token = token
  }

  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty("username")
  fun getUsername(): Option<String> {
    return Option.of(username)
  }

  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty("username")
  fun setUsername(username: String) {
    this.username = username
  }

  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty("password")
  fun getPassword(): Option<String> {
    return Option.of(password)
  }

  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty("password")
  fun setPassword(password: String) {
    this.password = password
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseLoggly

    if(enabled != other.enabled) return false
    if(subdomain != other.subdomain) return false
    if(token != other.token) return false
    if(username != other.username) return false
    if(password != other.password) return false

    return true
  }

  override fun hashCode(): Int {
    var result = enabled.hashCode()
    result = 31 * result + (subdomain?.hashCode() ?: 0)
    result = 31 * result + (token?.hashCode() ?: 0)
    result = 31 * result + (username?.hashCode() ?: 0)
    result = 31 * result + (password?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return """{"enabled"=$enabled, "subdomain"="$subdomain", "token"="$token", "username"="$username", "password"="$password")"""
  }

  companion object {
    private const val serialVersionUID = 4530237339952483812L
  }
}
