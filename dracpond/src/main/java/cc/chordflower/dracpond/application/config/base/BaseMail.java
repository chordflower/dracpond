
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
 * Information about the smtp server to use
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "address", "port", "username", "password", "secure", "from" } )
public class BaseMail implements Serializable {

  public static class BaseMailBuilder< T extends BaseMail > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseMailBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseMail.BaseMailBuilder.class ) ) {
        this.instance = ( ( T )new BaseMail( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseMail.BaseMailBuilder withAddress( String address ) {
      ( ( BaseMail )this.instance ).address = address;
      return this;
    }

    public BaseMail.BaseMailBuilder withFrom( String from ) {
      ( ( BaseMail )this.instance ).from = from;
      return this;
    }

    public BaseMail.BaseMailBuilder withPassword( String password ) {
      ( ( BaseMail )this.instance ).password = password;
      return this;
    }

    public BaseMail.BaseMailBuilder withPort( BigDecimal port ) {
      ( ( BaseMail )this.instance ).port = port;
      return this;
    }

    public BaseMail.BaseMailBuilder withSecure( Boolean secure ) {
      ( ( BaseMail )this.instance ).secure = secure;
      return this;
    }

    public BaseMail.BaseMailBuilder withUsername( String username ) {
      ( ( BaseMail )this.instance ).username = username;
      return this;
    }

  }

  private final static long serialVersionUID = -8161151707291630921L;
  /**
   * The smtp server address
   */
  @JsonProperty ( "address" )
  @JsonPropertyDescription ( "The smtp server address" )
  private String address = "127.0.0.1";
  /**
   * The port the smtp server
   */
  @JsonProperty ( "port" )
  @JsonPropertyDescription ( "The port the smtp server" )
  @DecimalMin ( "1" )
  @DecimalMax ( "65535" )
  private BigDecimal port = new BigDecimal( "654" );
  /**
   * The smtp server username
   */
  @JsonProperty ( "username" )
  @JsonPropertyDescription ( "The smtp server username" )
  private String username;
  /**
   * The smtp server username password
   */
  @JsonProperty ( "password" )
  @JsonPropertyDescription ( "The smtp server username password" )
  private String password;
  /**
   * If a secure connection should be made
   */
  @JsonProperty ( "secure" )
  @JsonPropertyDescription ( "If a secure connection should be made" )
  private Boolean secure = false;

  /**
   * The email address that we should sent emails from
   */
  @JsonProperty ( "from" )
  @JsonPropertyDescription ( "The email address that we should sent emails from" )
  private String from = "admin@example.com";

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseMail ) == false ) {
      return false;
    }
    var rhs = ( ( BaseMail )other );
    return ( ( ( ( ( ( ( this.password == rhs.password ) || ( ( this.password != null ) && this.password.equals( rhs.password ) ) ) && ( ( this.address == rhs.address ) || ( ( this.address != null ) && this.address.equals( rhs.address ) ) ) ) && ( ( this.port == rhs.port ) || ( ( this.port != null ) && this.port.equals( rhs.port ) ) ) ) && ( ( this.from == rhs.from ) || ( ( this.from != null ) && this.from.equals( rhs.from ) ) ) ) && ( ( this.secure == rhs.secure ) || ( ( this.secure != null ) && this.secure.equals( rhs.secure ) ) ) ) && ( ( this.username == rhs.username ) || ( ( this.username != null ) && this.username.equals( rhs.username ) ) ) );
  }

  /**
   * The smtp server address
   */
  @JsonProperty ( "address" )
  public Optional< String > getAddress( ) {
    return Optional.ofNullable( this.address );
  }

  /**
   * The email address that we should sent emails from
   */
  @JsonProperty ( "from" )
  public Optional< String > getFrom( ) {
    return Optional.ofNullable( this.from );
  }

  /**
   * The smtp server username password
   */
  @JsonProperty ( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( this.password );
  }

  /**
   * The port the smtp server
   */
  @JsonProperty ( "port" )
  public Optional< BigDecimal > getPort( ) {
    return Optional.ofNullable( this.port );
  }

  /**
   * If a secure connection should be made
   */
  @JsonProperty ( "secure" )
  public Optional< Boolean > getSecure( ) {
    return Optional.ofNullable( this.secure );
  }

  /**
   * The smtp server username
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
    result = ( ( result * 31 ) + ( ( this.from == null ) ? 0 : this.from.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.secure == null ) ? 0 : this.secure.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.username == null ) ? 0 : this.username.hashCode( ) ) );
    return result;
  }

  /**
   * The smtp server address
   */
  @JsonProperty ( "address" )
  public void setAddress( String address ) {
    this.address = address;
  }

  /**
   * The email address that we should sent emails from
   */
  @JsonProperty ( "from" )
  public void setFrom( String from ) {
    this.from = from;
  }

  /**
   * The smtp server username password
   */
  @JsonProperty ( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * The port the smtp server
   */
  @JsonProperty ( "port" )
  public void setPort( BigDecimal port ) {
    this.port = port;
  }

  /**
   * If a secure connection should be made
   */
  @JsonProperty ( "secure" )
  public void setSecure( Boolean secure ) {
    this.secure = secure;
  }

  /**
   * The smtp server username
   */
  @JsonProperty ( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseMail.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
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
    sb.append( "secure" );
    sb.append( '=' );
    sb.append( ( ( this.secure == null ) ? "<null>" : this.secure ) );
    sb.append( ',' );
    sb.append( "from" );
    sb.append( '=' );
    sb.append( ( ( this.from == null ) ? "<null>" : this.from ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
