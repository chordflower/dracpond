package cc.chordflower.dracpond.application.config;

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

import cc.chordflower.dracpond.application.config.base.BaseConfigSchema;
import io.vertx.core.json.JsonObject;

public class Configuration extends BaseConfigSchema {

  private static final long serialVersionUID = 1L;

  public static Configuration fromNode( final JsonObject result ) {
    return null;
  }

}
