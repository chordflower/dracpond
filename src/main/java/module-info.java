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

module cc.chordflower.dracpond {
  requires org.slf4j;
  requires jul.to.slf4j;
  requires transitive com.google.common;
  requires io.vavr;
  requires io.vertx.core;
  requires transitive io.vertx.config;
  requires io.vertx.config.yaml;
  requires deltaspike.cdictrl.api;
  requires deltaspike.core.api;
  requires javax.interceptor.api;
  requires javax.inject;
  requires cdi.api;
  requires jakarta.validation;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.datatype.guava;
  requires com.fasterxml.jackson.datatype.jdk8;
  requires com.fasterxml.jackson.datatype.jsr310;
  requires jcommander;

  exports cc.chordflower.dracpond;
}
