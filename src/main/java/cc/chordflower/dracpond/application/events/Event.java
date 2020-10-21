package cc.chordflower.dracpond.application.events;

import java.util.Objects;

/*-
 * #%L
 * dracpond
 * %%
 * Copyright (C) 2020 carddamom
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import cc.chordflower.dracpond.application.arguments.Arguments;
import cc.chordflower.dracpond.application.config.Configuration;
import io.vavr.collection.Seq;

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

  protected Event( EventType eventType, T data ) {
    super( );
    this.eventType = eventType;
    this.data = data;
  }

  @Override
  public boolean equals( Object obj ) {
    if( this == obj ) {
      return true;
    }
    if( !( obj instanceof Event ) ) {
      return false;
    }
    var other = ( Event )obj;
    return Objects.equals( this.data, other.data ) && ( this.eventType == other.eventType );
  }

  public final T getData( ) {
    return this.data;
  }

  public final EventType getEventType( ) {
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
