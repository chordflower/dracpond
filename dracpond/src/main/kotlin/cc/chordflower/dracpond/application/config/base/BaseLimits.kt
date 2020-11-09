package cc.chordflower.dracpond.application.config.base

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import io.vavr.control.Option
import java.io.Serializable
import java.math.BigInteger

/**
 * Several server limit configurations
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("timeBetweenRequests", "maximumRequestSize", "fieldNameSize", "fieldSize", "fileSize")
class BaseLimits(
  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty("timeBetweenRequests")
  @JsonPropertyDescription("Minimum time between consecutive requests by the same browser (in miliseconds)")
  private var timeBetweenRequests: BigInteger,
  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty("maximumRequestSize")
  @JsonPropertyDescription("Maximum size of a request body (in bytes)")
  private var maximumRequestSize: BigInteger,
  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty("fieldNameSize")
  @JsonPropertyDescription("Max multipart field name size (in bytes)")
  private var fieldNameSize: BigInteger,
  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty("fieldSize")
  @JsonPropertyDescription("Max multipart field value size (in bytes)")
  private var fieldSize: BigInteger,
  /**
   * The max file size (in bytes)
   */
  @JsonProperty("fileSize")
  @JsonPropertyDescription("The max file size (in bytes)")
  private var fileSize: BigInteger
) : Serializable {

  constructor(): this(BigInteger.valueOf(10000), BigInteger.valueOf(52428800), BigInteger.valueOf(100), BigInteger.valueOf(1048576), BigInteger.valueOf(20971520))

  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty("timeBetweenRequests")
  fun getTimeBetweenRequests(): Option<BigInteger> {
    return Option.of(timeBetweenRequests)
  }

  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty("timeBetweenRequests")
  fun setTimeBetweenRequests(timeBetweenRequests: BigInteger) {
    this.timeBetweenRequests = timeBetweenRequests
  }

  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty("maximumRequestSize")
  fun getMaximumRequestSize(): Option<BigInteger> {
    return Option.of(maximumRequestSize)
  }

  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty("maximumRequestSize")
  fun setMaximumRequestSize(maximumRequestSize: BigInteger) {
    this.maximumRequestSize = maximumRequestSize
  }

  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty("fieldNameSize")
  fun getFieldNameSize(): Option<BigInteger> {
    return Option.of(fieldNameSize)
  }

  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty("fieldNameSize")
  fun setFieldNameSize(fieldNameSize: BigInteger) {
    this.fieldNameSize = fieldNameSize
  }

  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty("fieldSize")
  fun getFieldSize(): Option<BigInteger> {
    return Option.of(fieldSize)
  }

  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty("fieldSize")
  fun setFieldSize(fieldSize: BigInteger) {
    this.fieldSize = fieldSize
  }

  /**
   * The max file size (in bytes)
   */
  @JsonProperty("fileSize")
  fun getFileSize(): Option<BigInteger> {
    return Option.of(fileSize)
  }

  /**
   * The max file size (in bytes)
   */
  @JsonProperty("fileSize") fun setFileSize(fileSize: BigInteger) {
    this.fileSize = fileSize
  }

  override fun equals(other: Any?): Boolean {
    if(this === other) return true
    if(javaClass != other?.javaClass) return false

    other as BaseLimits

    if(timeBetweenRequests != other.timeBetweenRequests) return false
    if(maximumRequestSize != other.maximumRequestSize) return false
    if(fieldNameSize != other.fieldNameSize) return false
    if(fieldSize != other.fieldSize) return false
    if(fileSize != other.fileSize) return false

    return true
  }

  override fun hashCode(): Int {
    var result = timeBetweenRequests.hashCode()
    result = 31 * result + maximumRequestSize.hashCode()
    result = 31 * result + fieldNameSize.hashCode()
    result = 31 * result + fieldSize.hashCode()
    result = 31 * result + fileSize.hashCode()
    return result
  }

  override fun toString(): String {
    return """{"timeBetweenRequests"=$timeBetweenRequests, "maximumRequestSize"=$maximumRequestSize, "fieldNameSize"=$fieldNameSize, "fieldSize"=$fieldSize, "fileSize"=$fileSize}"""
  }

  companion object {
    private const val serialVersionUID = -7629765136123080483L
  }
}
