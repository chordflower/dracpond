package cc.chordflower.dracpond.application.events;

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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class Event<T> {
  protected final EventType eventType;
  protected final T data;

  public static class BeforeStartEvent extends Event<Void> {
    public BeforeStartEvent() {
      super(EventType.BEFORE_START, null);
    }
  }

  public static class BeforeParseArgumentsEvent extends Event<Seq<String>> {
    public BeforeParseArgumentsEvent( Seq<String> args ) {
      super(EventType.BEFORE_ARGUMENT_PARSER, args);
    }
  }

  public static class AfterParseArgumentsEvent extends Event<Arguments> {
    public AfterParseArgumentsEvent( Arguments arguments ) {
      super(EventType.AFTER_ARGUMENT_PARSER, arguments);
    }
  }

  public static class AfterParseConfigurationEvent extends Event<Configuration> {
    public AfterParseConfigurationEvent( Configuration data ) {
      super( EventType.AFTER_CONFIG_PARSER, data );
    }
  }
}
