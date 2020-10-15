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

public enum EventType {
  BEFORE_START,
  BEFORE_ARGUMENT_PARSER,
  AFTER_ARGUMENT_PARSER,
  BEFORE_CONFIG_PARSER,
  AFTER_CONFIG_PARSER,
  AFTER_LOGGING,
  BEFORE_START_VERTX,
  AFTER_START_VERTX,
  BEFORE_STOP_VERTX,
  BEFORE_STOP;
}
