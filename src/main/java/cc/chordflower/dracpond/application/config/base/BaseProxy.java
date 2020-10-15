
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

/**
 * The definition of a single proxy
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "enabled", "type", "host", "port", "username", "password", "except" } )
public class BaseProxy implements Serializable {

  public static class BaseProxyBuilder< T extends BaseProxy > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseProxyBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseProxy.BaseProxyBuilder.class ) ) {
        this.instance = ( ( T )new BaseProxy( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseProxy.BaseProxyBuilder withEnabled( Boolean enabled ) {
      ( ( BaseProxy )this.instance ).enabled = enabled;
      return this;
    }

    public BaseProxy.BaseProxyBuilder withExcept( List< String > except ) {
      ( ( BaseProxy )this.instance ).except = except;
      return this;
    }

    public BaseProxy.BaseProxyBuilder withHost( String host ) {
      ( ( BaseProxy )this.instance ).host = host;
      return this;
    }

    public BaseProxy.BaseProxyBuilder withPassword( String password ) {
      ( ( BaseProxy )this.instance ).password = password;
      return this;
    }

    public BaseProxy.BaseProxyBuilder withPort( BigInteger port ) {
      ( ( BaseProxy )this.instance ).port = port;
      return this;
    }

    public BaseProxy.BaseProxyBuilder withType( BaseProxy.Type type ) {
      ( ( BaseProxy )this.instance ).type = type;
      return this;
    }

    public BaseProxy.BaseProxyBuilder withUsername( String username ) {
      ( ( BaseProxy )this.instance ).username = username;
      return this;
    }

  }

  /**
   * The protocol to use this proxy for
   */
  public enum Type {

    HTTP( "http" ), HTTPS( "https" ), FTP( "ftp" ), FTPS( "ftps" );

    private final static Map< String, BaseProxy.Type > CONSTANTS = new HashMap<>( );
    static {
      for( BaseProxy.Type c : Type.values( ) ) {
        Type.CONSTANTS.put( c.value, c );
      }
    }

    @JsonCreator
    public static BaseProxy.Type fromValue( String value ) {
      var constant = Type.CONSTANTS.get( value );
      if( constant == null ) {
        throw new IllegalArgumentException( value );
      }
      return constant;
    }

    private final String value;

    private Type( String value ) {
      this.value = value;
    }

    @Override
    public String toString( ) {
      return this.value;
    }

    @JsonValue
    public String value( ) {
      return this.value;
    }

  }

  private final static long serialVersionUID = 890784606874988346L;
  /**
   * If the proxy is enabled
   */
  @JsonProperty ( "enabled" )
  @JsonPropertyDescription ( "If the proxy is enabled" )
  private Boolean enabled = true;
  /**
   * The protocol to use this proxy for
   */
  @JsonProperty ( "type" )
  @JsonPropertyDescription ( "The protocol to use this proxy for" )
  private BaseProxy.Type type;
  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty ( "host" )
  @JsonPropertyDescription ( "The host of this proxy (Include schema)" )
  private String host;
  /**
   * The proxy port
   */
  @JsonProperty ( "port" )
  @JsonPropertyDescription ( "The proxy port" )
  @DecimalMin ( "1" )
  @DecimalMax ( "65535" )
  private BigInteger port = new BigInteger( "8500" );
  /**
   * The username to connect to this proxy
   */
  @JsonProperty ( "username" )
  @JsonPropertyDescription ( "The username to connect to this proxy" )
  private String username;

  /**
   * The password of the user
   */
  @JsonProperty ( "password" )
  @JsonPropertyDescription ( "The password of the user" )
  private String password;

  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty ( "except" )
  @JsonPropertyDescription ( "List of domain exceptions that do not pass into this proxy" )
  @Valid
  private List< String > except = new ArrayList<>( );

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseProxy ) == false ) {
      return false;
    }
    var rhs = ( ( BaseProxy )other );
    return ( ( ( ( ( ( ( ( this.password == rhs.password ) || ( ( this.password != null ) && this.password.equals( rhs.password ) ) ) && ( ( this.port == rhs.port ) || ( ( this.port != null ) && this.port.equals( rhs.port ) ) ) ) && ( ( this.host == rhs.host ) || ( ( this.host != null ) && this.host.equals( rhs.host ) ) ) ) && ( ( this.except == rhs.except ) || ( ( this.except != null ) && this.except.equals( rhs.except ) ) ) ) && ( ( this.type == rhs.type ) || ( ( this.type != null ) && this.type.equals( rhs.type ) ) ) ) && ( ( this.enabled == rhs.enabled ) || ( ( this.enabled != null ) && this.enabled.equals( rhs.enabled ) ) ) ) && ( ( this.username == rhs.username ) || ( ( this.username != null ) && this.username.equals( rhs.username ) ) ) );
  }

  /**
   * If the proxy is enabled
   */
  @JsonProperty ( "enabled" )
  public Optional< Boolean > getEnabled( ) {
    return Optional.ofNullable( this.enabled );
  }

  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty ( "except" )
  public Optional< List< String > > getExcept( ) {
    return Optional.ofNullable( this.except );
  }

  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty ( "host" )
  public Optional< String > getHost( ) {
    return Optional.ofNullable( this.host );
  }

  /**
   * The password of the user
   */
  @JsonProperty ( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( this.password );
  }

  /**
   * The proxy port
   */
  @JsonProperty ( "port" )
  public Optional< BigInteger > getPort( ) {
    return Optional.ofNullable( this.port );
  }

  /**
   * The protocol to use this proxy for
   */
  @JsonProperty ( "type" )
  public Optional< BaseProxy.Type > getType( ) {
    return Optional.ofNullable( this.type );
  }

  /**
   * The username to connect to this proxy
   */
  @JsonProperty ( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( this.username );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.password == null ) ? 0 : this.password.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.port == null ) ? 0 : this.port.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.host == null ) ? 0 : this.host.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.except == null ) ? 0 : this.except.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.type == null ) ? 0 : this.type.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.enabled == null ) ? 0 : this.enabled.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.username == null ) ? 0 : this.username.hashCode( ) ) );
    return result;
  }

  /**
   * If the proxy is enabled
   */
  @JsonProperty ( "enabled" )
  public void setEnabled( Boolean enabled ) {
    this.enabled = enabled;
  }

  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty ( "except" )
  public void setExcept( List< String > except ) {
    this.except = except;
  }

  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty ( "host" )
  public void setHost( String host ) {
    this.host = host;
  }

  /**
   * The password of the user
   */
  @JsonProperty ( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * The proxy port
   */
  @JsonProperty ( "port" )
  public void setPort( BigInteger port ) {
    this.port = port;
  }

  /**
   * The protocol to use this proxy for
   */
  @JsonProperty ( "type" )
  public void setType( BaseProxy.Type type ) {
    this.type = type;
  }

  /**
   * The username to connect to this proxy
   */
  @JsonProperty ( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseProxy.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "enabled" );
    sb.append( '=' );
    sb.append( ( ( this.enabled == null ) ? "<null>" : this.enabled ) );
    sb.append( ',' );
    sb.append( "type" );
    sb.append( '=' );
    sb.append( ( ( this.type == null ) ? "<null>" : this.type ) );
    sb.append( ',' );
    sb.append( "host" );
    sb.append( '=' );
    sb.append( ( ( this.host == null ) ? "<null>" : this.host ) );
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
    sb.append( "except" );
    sb.append( '=' );
    sb.append( ( ( this.except == null ) ? "<null>" : this.except ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
