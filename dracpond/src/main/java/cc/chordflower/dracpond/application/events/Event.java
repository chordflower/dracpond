package cc.chordflower.dracpond.application.events;

import cc.chordflower.dracpond.application.arguments.Arguments;
import cc.chordflower.dracpond.application.config.Configuration;
import io.vavr.collection.Seq;
import org.jetbrains.annotations.Contract;

import java.util.Objects;

@SuppressWarnings( "unused" )
public abstract class Event< T > {
  public static class AfterParseArgumentsEvent extends Event< Arguments > {
    public AfterParseArgumentsEvent( Arguments arguments ) {
      super( EventType.AFTER_ARGUMENT_PARSER, arguments );
    }
  }

  public static class AfterParseConfigurationEvent extends Event< Configuration > {
    public AfterParseConfigurationEvent( Configuration data ) {
      super( EventType.AFTER_CONFIG_PARSER, data );
    }
  }

  public static class BeforeParseArgumentsEvent extends Event< Seq< String > > {
    public BeforeParseArgumentsEvent( Seq< String > args ) {
      super( EventType.BEFORE_ARGUMENT_PARSER, args );
    }
  }

  public static class BeforeStartEvent extends Event< Void > {
    public BeforeStartEvent( ) {
      super( EventType.BEFORE_START, null );
    }
  }

  protected final EventType eventType;

  protected final T data;

  @Contract( pure = true ) protected Event( EventType eventType, T data ) {
    super( );
    this.eventType = eventType;
    this.data = data;
  }

  @Contract( value = "null -> false", pure = true ) @Override
  public boolean equals( Object obj ) {
    if( this == obj ) {
      return true;
    }
    if( !( obj instanceof Event ) ) {
      return false;
    }
    Event<?> other = ( Event<?> ) obj;
    return Objects.equals( this.data, other.data ) && ( this.eventType == other.eventType );
  }

  @Contract( pure = true ) public final T getData( ) {
    return this.data;
  }

  @Contract( pure = true ) public final EventType getEventType( ) {
    return this.eventType;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash( this.data, this.eventType );
  }

  @Override
  public String toString( ) {
    return String.format( "{eventType=%s, data=%s}", this.eventType, this.data );
  }

}
