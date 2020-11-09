package cc.chordflower.dracpond.application.events

import cc.chordflower.dracpond.application.arguments.Arguments
import cc.chordflower.dracpond.application.config.Configuration
import io.vavr.collection.Seq
import org.jetbrains.annotations.Contract
import java.util.*

abstract class Event<T> @Contract(pure = true) protected constructor(@get:Contract(pure = true) val eventType: EventType, @get:Contract(pure = true) val data: T) {
  class AfterParseArgumentsEvent(arguments: Arguments) : Event<Arguments?>(EventType.AFTER_ARGUMENT_PARSER, arguments)
  class AfterParseConfigurationEvent(data: Configuration) : Event<Configuration?>(EventType.AFTER_CONFIG_PARSER, data)
  class BeforeParseArgumentsEvent(args: Seq<String>) : Event<Seq<String>?>(EventType.BEFORE_ARGUMENT_PARSER, args)
  class BeforeStartEvent : Event<Unit>(EventType.BEFORE_START, Unit)

  @Contract(value = "null -> false", pure = true)
  override fun equals(other: Any?): Boolean {
    if(this === other) {
      return true
    }
    if(other !is Event<*>) {
      return false
    }
    return data == other.data && eventType == other.eventType
  }

  override fun hashCode(): Int {
    return Objects.hash(data, eventType)
  }

  override fun toString(): String {
    return String.format("{eventType=%s, data=%s}", eventType, data)
  }

}
