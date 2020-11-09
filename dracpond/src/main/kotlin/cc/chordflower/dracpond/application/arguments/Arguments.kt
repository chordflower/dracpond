package cc.chordflower.dracpond.application.arguments

import com.beust.jcommander.Parameter
import org.jetbrains.annotations.Contract
import java.util.*

class Arguments() {
  @get:Contract(pure = true)
  @Parameter(names = ["-v", "--verbose"], description = "Enables verbose output")
  var isVerbose = false

  @get:Contract(pure = true)
  @Parameter(names = ["-c", "--config"], description = "The location of the configuration file")
  var config = ""

  constructor(verbose: Boolean, config: String) : this() {
    isVerbose = verbose
    this.config = config
  }

  @Contract(value = "null -> false", pure = true)
  override fun equals(other: Any?): Boolean {
    if(this === other) {
      return true
    }
    if(other !is Arguments) {
      return false
    }
    return config == other.config && isVerbose == other.isVerbose
  }

  override fun hashCode(): Int {
    return Objects.hash(config, isVerbose)
  }

  override fun toString(): String {
    return """{ "verbose"=$isVerbose, "config"="$config"}"""
  }
}
