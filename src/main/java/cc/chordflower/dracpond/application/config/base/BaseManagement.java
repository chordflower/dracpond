
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
import java.math.BigDecimal;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

/**
 * Describes the management configuration used to control the server
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "address", "port", "username", "password" } )
public class BaseManagement implements Serializable {

  public static class BaseManagementBuilder< T extends BaseManagement > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseManagementBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseManagement.BaseManagementBuilder.class ) ) {
        this.instance = ( ( T )new BaseManagement( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseManagement.BaseManagementBuilder withAddress( String address ) {
      ( ( BaseManagement )this.instance ).address = address;
      return this;
    }

    public BaseManagement.BaseManagementBuilder withPassword( String password ) {
      ( ( BaseManagement )this.instance ).password = password;
      return this;
    }

    public BaseManagement.BaseManagementBuilder withPort( BigDecimal port ) {
      ( ( BaseManagement )this.instance ).port = port;
      return this;
    }

    public BaseManagement.BaseManagementBuilder withUsername( String username ) {
      ( ( BaseManagement )this.instance ).username = username;
      return this;
    }

  }

  private final static long serialVersionUID = 1174281864422459680L;
  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty ( "address" )
  @JsonPropertyDescription ( "The address the management server should listen to it must be an ip address" )
  private String address = "127.0.0.1";
  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty ( "port" )
  @JsonPropertyDescription ( "The port the management server should listen to (default is a random available port)" )
  @DecimalMin ( "0" )
  @DecimalMax ( "65535" )
  private BigDecimal port;
  /**
   * The management server username
   */
  @JsonProperty ( "username" )
  @JsonPropertyDescription ( "The management server username" )
  private String username = "admin";

  /**
   * The management server username password
   */
  @JsonProperty ( "password" )
  @JsonPropertyDescription ( "The management server username password" )
  private String password = "admin123";

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseManagement ) == false ) {
      return false;
    }
    var rhs = ( ( BaseManagement )other );
    return ( ( ( ( ( this.password == rhs.password ) || ( ( this.password != null ) && this.password.equals( rhs.password ) ) ) && ( ( this.address == rhs.address ) || ( ( this.address != null ) && this.address.equals( rhs.address ) ) ) ) && ( ( this.port == rhs.port ) || ( ( this.port != null ) && this.port.equals( rhs.port ) ) ) ) && ( ( this.username == rhs.username ) || ( ( this.username != null ) && this.username.equals( rhs.username ) ) ) );
  }

  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty ( "address" )
  public Optional< String > getAddress( ) {
    return Optional.ofNullable( this.address );
  }

  /**
   * The management server username password
   */
  @JsonProperty ( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( this.password );
  }

  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty ( "port" )
  public Optional< BigDecimal > getPort( ) {
    return Optional.ofNullable( this.port );
  }

  /**
   * The management server username
   */
  @JsonProperty ( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( this.username );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.password == null ) ? 0 : this.password.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.address == null ) ? 0 : this.address.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.port == null ) ? 0 : this.port.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.username == null ) ? 0 : this.username.hashCode( ) ) );
    return result;
  }

  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty ( "address" )
  public void setAddress( String address ) {
    this.address = address;
  }

  /**
   * The management server username password
   */
  @JsonProperty ( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty ( "port" )
  public void setPort( BigDecimal port ) {
    this.port = port;
  }

  /**
   * The management server username
   */
  @JsonProperty ( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseManagement.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "address" );
    sb.append( '=' );
    sb.append( ( ( this.address == null ) ? "<null>" : this.address ) );
    sb.append( ',' );
    sb.append( "port" );
    sb.append( '=' );
    sb.append( ( ( this.port == null ) ? "<null>" : this.port ) );
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
