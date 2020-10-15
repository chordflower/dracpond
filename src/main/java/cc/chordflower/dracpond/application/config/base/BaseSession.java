
package cc.chordflower.dracpond.application.config.base;

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

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Configuration related to the session
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "key", "maxAge" } )
public class BaseSession implements Serializable {

  public static class BaseSessionBuilder< T extends BaseSession > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseSessionBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseSession.BaseSessionBuilder.class ) ) {
        this.instance = ( ( T )new BaseSession( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseSession.BaseSessionBuilder withKey( String key ) {
      ( ( BaseSession )this.instance ).key = key;
      return this;
    }

    public BaseSession.BaseSessionBuilder withMaxAge( BigInteger maxAge ) {
      ( ( BaseSession )this.instance ).maxAge = maxAge;
      return this;
    }

  }

  private final static long serialVersionUID = 9080423736428752027L;
  /**
   * The name of the session id in storage
   */
  @JsonProperty ( "key" )
  @JsonPropertyDescription ( "The name of the session id in storage" )
  private String key = "KSESSION";

  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty ( "maxAge" )
  @JsonPropertyDescription ( "The number of seconds that the session is active." )
  private BigInteger maxAge = new BigInteger( "1800" );

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseSession ) == false ) {
      return false;
    }
    var rhs = ( ( BaseSession )other );
    return ( ( ( this.maxAge == rhs.maxAge ) || ( ( this.maxAge != null ) && this.maxAge.equals( rhs.maxAge ) ) ) && ( ( this.key == rhs.key ) || ( ( this.key != null ) && this.key.equals( rhs.key ) ) ) );
  }

  /**
   * The name of the session id in storage
   */
  @JsonProperty ( "key" )
  public Optional< String > getKey( ) {
    return Optional.ofNullable( this.key );
  }

  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty ( "maxAge" )
  public Optional< BigInteger > getMaxAge( ) {
    return Optional.ofNullable( this.maxAge );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.maxAge == null ) ? 0 : this.maxAge.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.key == null ) ? 0 : this.key.hashCode( ) ) );
    return result;
  }

  /**
   * The name of the session id in storage
   */
  @JsonProperty ( "key" )
  public void setKey( String key ) {
    this.key = key;
  }

  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty ( "maxAge" )
  public void setMaxAge( BigInteger maxAge ) {
    this.maxAge = maxAge;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseSession.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "key" );
    sb.append( '=' );
    sb.append( ( ( this.key == null ) ? "<null>" : this.key ) );
    sb.append( ',' );
    sb.append( "maxAge" );
    sb.append( '=' );
    sb.append( ( ( this.maxAge == null ) ? "<null>" : this.maxAge ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
