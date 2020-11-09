package cc.chordflower.dracpond.application.config.base

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
 * The protocol to use this proxy for
 */
enum class ProxyType(private val value: String) {
  HTTP("http"), HTTPS("https"), FTP("ftp"), FTPS("ftps");

  companion object {
    private val CONSTANTS: MutableMap<String, ProxyType> = HashMap()

    @JsonCreator
    fun fromValue(value: String): ProxyType {
      val constant = CONSTANTS[value]
      return constant ?: throw IllegalArgumentException(value)
    }

    init {
      for(c in values()) {
        CONSTANTS[c.value] = c
      }
    }
  }

  override fun toString(): String {
    return value
  }

  @JsonValue fun value(): String {
    return value
  }
}
