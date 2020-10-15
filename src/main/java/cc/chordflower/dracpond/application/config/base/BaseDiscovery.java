
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
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

/**
 * Definitions related to the registration in a consul server
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "enabled", "host", "port", "secure", "datacenter", "token", "ca" } )
public class BaseDiscovery implements Serializable {

  public static class BaseDiscoveryBuilder< T extends BaseDiscovery > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseDiscoveryBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseDiscovery.BaseDiscoveryBuilder.class ) ) {
        this.instance = ( ( T )new BaseDiscovery( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseDiscovery.BaseDiscoveryBuilder withCa( List< String > ca ) {
      ( ( BaseDiscovery )this.instance ).ca = ca;
      return this;
    }

    public BaseDiscovery.BaseDiscoveryBuilder withDatacenter( String datacenter ) {
      ( ( BaseDiscovery )this.instance ).datacenter = datacenter;
      return this;
    }

    public BaseDiscovery.BaseDiscoveryBuilder withEnabled( Boolean enabled ) {
      ( ( BaseDiscovery )this.instance ).enabled = enabled;
      return this;
    }

    public BaseDiscovery.BaseDiscoveryBuilder withHost( String host ) {
      ( ( BaseDiscovery )this.instance ).host = host;
      return this;
    }

    public BaseDiscovery.BaseDiscoveryBuilder withPort( BigInteger port ) {
      ( ( BaseDiscovery )this.instance ).port = port;
      return this;
    }

    public BaseDiscovery.BaseDiscoveryBuilder withSecure( Boolean secure ) {
      ( ( BaseDiscovery )this.instance ).secure = secure;
      return this;
    }

    public BaseDiscovery.BaseDiscoveryBuilder withToken( String token ) {
      ( ( BaseDiscovery )this.instance ).token = token;
      return this;
    }

  }

  private final static long serialVersionUID = 1219384487803540539L;
  /**
   * Enable the consul registration
   */
  @JsonProperty ( "enabled" )
  @JsonPropertyDescription ( "Enable the consul registration" )
  private Boolean enabled = false;
  /**
   * The location of the consul server
   */
  @JsonProperty ( "host" )
  @JsonPropertyDescription ( "The location of the consul server" )
  private String host = "127.0.0.1";
  /**
   * The consul server port
   */
  @JsonProperty ( "port" )
  @JsonPropertyDescription ( "The consul server port" )
  @DecimalMin ( "1" )
  @DecimalMax ( "65535" )
  private BigInteger port = new BigInteger( "8500" );
  /**
   * If a secure connection is needed
   */
  @JsonProperty ( "secure" )
  @JsonPropertyDescription ( "If a secure connection is needed" )
  private Boolean secure = false;
  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty ( "datacenter" )
  @JsonPropertyDescription ( "The datacenter to use (defaults to local for agent)" )
  private String datacenter;
  /**
   * The token to use (defaults to none)
   */
  @JsonProperty ( "token" )
  @JsonPropertyDescription ( "The token to use (defaults to none)" )
  private String token;

  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty ( "ca" )
  @JsonPropertyDescription ( "The certificates to use in pem format (defaults to none)" )
  @Valid
  private List< String > ca = new ArrayList<>( );

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseDiscovery ) == false ) {
      return false;
    }
    var rhs = ( ( BaseDiscovery )other );
    return ( ( ( ( ( ( ( ( this.port == rhs.port ) || ( ( this.port != null ) && this.port.equals( rhs.port ) ) ) && ( ( this.host == rhs.host ) || ( ( this.host != null ) && this.host.equals( rhs.host ) ) ) ) && ( ( this.datacenter == rhs.datacenter ) || ( ( this.datacenter != null ) && this.datacenter.equals( rhs.datacenter ) ) ) ) && ( ( this.secure == rhs.secure ) || ( ( this.secure != null ) && this.secure.equals( rhs.secure ) ) ) ) && ( ( this.enabled == rhs.enabled ) || ( ( this.enabled != null ) && this.enabled.equals( rhs.enabled ) ) ) ) && ( ( this.ca == rhs.ca ) || ( ( this.ca != null ) && this.ca.equals( rhs.ca ) ) ) ) && ( ( this.token == rhs.token ) || ( ( this.token != null ) && this.token.equals( rhs.token ) ) ) );
  }

  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty ( "ca" )
  public Optional< List< String > > getCa( ) {
    return Optional.ofNullable( this.ca );
  }

  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty ( "datacenter" )
  public Optional< String > getDatacenter( ) {
    return Optional.ofNullable( this.datacenter );
  }

  /**
   * Enable the consul registration
   */
  @JsonProperty ( "enabled" )
  public Optional< Boolean > getEnabled( ) {
    return Optional.ofNullable( this.enabled );
  }

  /**
   * The location of the consul server
   */
  @JsonProperty ( "host" )
  public Optional< String > getHost( ) {
    return Optional.ofNullable( this.host );
  }

  /**
   * The consul server port
   */
  @JsonProperty ( "port" )
  public Optional< BigInteger > getPort( ) {
    return Optional.ofNullable( this.port );
  }

  /**
   * If a secure connection is needed
   */
  @JsonProperty ( "secure" )
  public Optional< Boolean > getSecure( ) {
    return Optional.ofNullable( this.secure );
  }

  /**
   * The token to use (defaults to none)
   */
  @JsonProperty ( "token" )
  public Optional< String > getToken( ) {
    return Optional.ofNullable( this.token );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.port == null ) ? 0 : this.port.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.host == null ) ? 0 : this.host.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.datacenter == null ) ? 0 : this.datacenter.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.secure == null ) ? 0 : this.secure.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.enabled == null ) ? 0 : this.enabled.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.ca == null ) ? 0 : this.ca.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.token == null ) ? 0 : this.token.hashCode( ) ) );
    return result;
  }

  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty ( "ca" )
  public void setCa( List< String > ca ) {
    this.ca = ca;
  }

  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty ( "datacenter" )
  public void setDatacenter( String datacenter ) {
    this.datacenter = datacenter;
  }

  /**
   * Enable the consul registration
   */
  @JsonProperty ( "enabled" )
  public void setEnabled( Boolean enabled ) {
    this.enabled = enabled;
  }

  /**
   * The location of the consul server
   */
  @JsonProperty ( "host" )
  public void setHost( String host ) {
    this.host = host;
  }

  /**
   * The consul server port
   */
  @JsonProperty ( "port" )
  public void setPort( BigInteger port ) {
    this.port = port;
  }

  /**
   * If a secure connection is needed
   */
  @JsonProperty ( "secure" )
  public void setSecure( Boolean secure ) {
    this.secure = secure;
  }

  /**
   * The token to use (defaults to none)
   */
  @JsonProperty ( "token" )
  public void setToken( String token ) {
    this.token = token;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseDiscovery.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "enabled" );
    sb.append( '=' );
    sb.append( ( ( this.enabled == null ) ? "<null>" : this.enabled ) );
    sb.append( ',' );
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
    sb.append( "datacenter" );
    sb.append( '=' );
    sb.append( ( ( this.datacenter == null ) ? "<null>" : this.datacenter ) );
    sb.append( ',' );
    sb.append( "token" );
    sb.append( '=' );
    sb.append( ( ( this.token == null ) ? "<null>" : this.token ) );
    sb.append( ',' );
    sb.append( "ca" );
    sb.append( '=' );
    sb.append( ( ( this.ca == null ) ? "<null>" : this.ca ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
