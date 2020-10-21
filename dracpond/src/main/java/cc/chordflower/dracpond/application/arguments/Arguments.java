package cc.chordflower.dracpond.application.arguments;

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

import com.beust.jcommander.Parameter;

public class Arguments {

  @Parameter ( names = { "-v", "--verbose" }, description = "Enables verbose output" )
  private boolean verbose = false;

  @Parameter ( names = { "-c", "--config" }, description = "The location of the configuration file" )
  private String config = "";

  public Arguments( ) {
    super( );
  }

  public Arguments( boolean verbose, String config ) {
    super( );
    this.verbose = verbose;
    this.config = config;
  }

  @Override
  public boolean equals( Object obj ) {
    if( this == obj ) {
      return true;
    }
    if( !( obj instanceof Arguments ) ) {
      return false;
    }
    var other = ( Arguments )obj;
    return Objects.equals( this.config, other.config ) && ( this.verbose == other.verbose );
  }

  public final String getConfig( ) {
    return this.config;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash( this.config, this.verbose );
  }

  public final boolean isVerbose( ) {
    return this.verbose;
  }

  @Override
  public String toString( ) {
    return String.format( "{ \"verbose\"=%s, \"config\"=\"%s\"}", this.verbose, this.config );
  }

}
