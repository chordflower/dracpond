package cc.chordflower.dracpond.application.config.base

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import io.vavr.control.Option
import java.io.Serializable
import java.math.BigInteger

/**
 * Configuration related to the session
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("key", "maxAge")
class BaseSession(
  /**
   * The name of the session id in storage
   */
  @JsonProperty("key")
  @JsonPropertyDescription("The name of the session id in storage")
  private var key: String?,
  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty("maxAge")
  @JsonPropertyDescription("The number of seconds that the session is active.")
  private var maxAge: BigInteger?
) : Serializable {

  constructor(): this("KSESSION", BigInteger.valueOf(1800))

  /**
   * The name of the session id in storage
   */
  @JsonProperty("key")
  fun getKey(): Option<String> {
    return Option.of(key)
  }

  /**
   * The name of the session id in storage
   */
  @JsonProperty("key")
  fun setKey(key: String) {
    this.key = key
  }

  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty("maxAge")
  fun getMaxAge(): Option<BigInteger> {
    return Option.of(maxAge)
  }

  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty("maxAge")
  fun setMaxAge(maxAge: BigInteger) {
    this.maxAge = maxAge
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseSession

    if(key != other.key) return false
    if(maxAge != other.maxAge) return false
    return true
  }

  override fun hashCode(): Int {
    var result = key?.hashCode() ?: 0
    result = 31 * result + (maxAge?.hashCode() ?: 0)
    return result
  }

  override fun toString(): String {
    return """{"key"="$key", "maxAge"=$maxAge}"""
  }

  companion object {
    private const val serialVersionUID = 3057487360968381059L
  }
}
