
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

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

/**
 * Definitions related to the arango database
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "host", "port", "secure", "username", "password" } )
public class BaseDatabase implements Serializable {

  public static class BaseDatabaseBuilder< T extends BaseDatabase > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseDatabaseBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseDatabase.BaseDatabaseBuilder.class ) ) {
        this.instance = ( ( T )new BaseDatabase( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseDatabase.BaseDatabaseBuilder withHost( String host ) {
      ( ( BaseDatabase )this.instance ).host = host;
      return this;
    }

    public BaseDatabase.BaseDatabaseBuilder withPassword( String password ) {
      ( ( BaseDatabase )this.instance ).password = password;
      return this;
    }

    public BaseDatabase.BaseDatabaseBuilder withPort( BigInteger port ) {
      ( ( BaseDatabase )this.instance ).port = port;
      return this;
    }

    public BaseDatabase.BaseDatabaseBuilder withSecure( Boolean secure ) {
      ( ( BaseDatabase )this.instance ).secure = secure;
      return this;
    }

    public BaseDatabase.BaseDatabaseBuilder withUsername( String username ) {
      ( ( BaseDatabase )this.instance ).username = username;
      return this;
    }

  }

  private final static long serialVersionUID = -7443797886465271616L;
  /**
   * The arangodb host
   */
  @JsonProperty ( "host" )
  @JsonPropertyDescription ( "The arangodb host" )
  private String host = "127.0.0.1";
  /**
   * The arangodb server port
   */
  @JsonProperty ( "port" )
  @JsonPropertyDescription ( "The arangodb server port" )
  @DecimalMin ( "1" )
  @DecimalMax ( "65535" )
  private BigInteger port = new BigInteger( "8529" );
  /**
   * Enable tls connection
   */
  @JsonProperty ( "secure" )
  @JsonPropertyDescription ( "Enable tls connection" )
  private Boolean secure = false;
  /**
   * The username to login to the arangodb server
   */
  @JsonProperty ( "username" )
  @JsonPropertyDescription ( "The username to login to the arangodb server" )
  private String username;

  /**
   * The password of the given username
   */
  @JsonProperty ( "password" )
  @JsonPropertyDescription ( "The password of the given username" )
  private String password;

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseDatabase ) == false ) {
      return false;
    }
    var rhs = ( ( BaseDatabase )other );
    return ( ( ( ( ( ( this.host == rhs.host ) || ( ( this.host != null ) && this.host.equals( rhs.host ) ) ) && ( ( this.password == rhs.password ) || ( ( this.password != null ) && this.password.equals( rhs.password ) ) ) ) && ( ( this.secure == rhs.secure ) || ( ( this.secure != null ) && this.secure.equals( rhs.secure ) ) ) ) && ( ( this.port == rhs.port ) || ( ( this.port != null ) && this.port.equals( rhs.port ) ) ) ) && ( ( this.username == rhs.username ) || ( ( this.username != null ) && this.username.equals( rhs.username ) ) ) );
  }

  /**
   * The arangodb host
   */
  @JsonProperty ( "host" )
  public Optional< String > getHost( ) {
    return Optional.ofNullable( this.host );
  }

  /**
   * The password of the given username
   */
  @JsonProperty ( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( this.password );
  }

  /**
   * The arangodb server port
   */
  @JsonProperty ( "port" )
  public Optional< BigInteger > getPort( ) {
    return Optional.ofNullable( this.port );
  }

  /**
   * Enable tls connection
   */
  @JsonProperty ( "secure" )
  public Optional< Boolean > getSecure( ) {
    return Optional.ofNullable( this.secure );
  }

  /**
   * The username to login to the arangodb server
   */
  @JsonProperty ( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( this.username );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.host == null ) ? 0 : this.host.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.password == null ) ? 0 : this.password.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.secure == null ) ? 0 : this.secure.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.port == null ) ? 0 : this.port.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.username == null ) ? 0 : this.username.hashCode( ) ) );
    return result;
  }

  /**
   * The arangodb host
   */
  @JsonProperty ( "host" )
  public void setHost( String host ) {
    this.host = host;
  }

  /**
   * The password of the given username
   */
  @JsonProperty ( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * The arangodb server port
   */
  @JsonProperty ( "port" )
  public void setPort( BigInteger port ) {
    this.port = port;
  }

  /**
   * Enable tls connection
   */
  @JsonProperty ( "secure" )
  public void setSecure( Boolean secure ) {
    this.secure = secure;
  }

  /**
   * The username to login to the arangodb server
   */
  @JsonProperty ( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseDatabase.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "host" );
    sb.append( '=' );
    sb.append( ( ( this.host == null ) ? "<null>" : this.host ) );
    sb.append( ',' );
    sb.append( "port" );
    sb.append( '=' );
    sb.append( ( ( this.port == null ) ? "<null>" : this.port ) );
    sb.append( ',' );
    sb.append( "secure" );
    sb.append( '=' );
    sb.append( ( ( this.secure == null ) ? "<null>" : this.secure ) );
    sb.append( ',' );
    sb.append( "username" );
    sb.append( '=' );
    sb.append( ( ( this.username == null ) ? "<null>" : this.username ) );
    sb.append( ',' );
    sb.append( "password" );
    sb.append( '=' );
    sb.append( ( ( this.password == null ) ? "<null>" : this.password ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
