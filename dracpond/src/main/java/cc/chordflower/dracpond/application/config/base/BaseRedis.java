
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
 * Definitions related to the redis server used for cache
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "host", "port", "password", "certificate", "key" } )
public class BaseRedis implements Serializable {

  public static class BaseRedisBuilder< T extends BaseRedis > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseRedisBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseRedis.BaseRedisBuilder.class ) ) {
        this.instance = ( ( T )new BaseRedis( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseRedis.BaseRedisBuilder withCertificate( String certificate ) {
      ( ( BaseRedis )this.instance ).certificate = certificate;
      return this;
    }

    public BaseRedis.BaseRedisBuilder withHost( String host ) {
      ( ( BaseRedis )this.instance ).host = host;
      return this;
    }

    public BaseRedis.BaseRedisBuilder withKey( String key ) {
      ( ( BaseRedis )this.instance ).key = key;
      return this;
    }

    public BaseRedis.BaseRedisBuilder withPassword( String password ) {
      ( ( BaseRedis )this.instance ).password = password;
      return this;
    }

    public BaseRedis.BaseRedisBuilder withPort( BigDecimal port ) {
      ( ( BaseRedis )this.instance ).port = port;
      return this;
    }

  }

  private final static long serialVersionUID = 1932758831307343447L;
  /**
   * The redis server location
   */
  @JsonProperty ( "host" )
  @JsonPropertyDescription ( "The redis server location" )
  private String host = "127.0.0.1";
  /**
   * The redis server port
   */
  @JsonProperty ( "port" )
  @JsonPropertyDescription ( "The redis server port" )
  @DecimalMin ( "1" )
  @DecimalMax ( "65535" )
  private BigDecimal port = new BigDecimal( "6379" );
  /**
   * The redis username password
   */
  @JsonProperty ( "password" )
  @JsonPropertyDescription ( "The redis username password" )
  private String password;
  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty ( "certificate" )
  @JsonPropertyDescription ( "The certificate (public key) to use for tls connection (activates tls)" )
  private String certificate;

  /**
   * The private key to use by the tls connection
   */
  @JsonProperty ( "key" )
  @JsonPropertyDescription ( "The private key to use by the tls connection" )
  private String key;

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseRedis ) == false ) {
      return false;
    }
    var rhs = ( ( BaseRedis )other );
    return ( ( ( ( ( ( this.host == rhs.host ) || ( ( this.host != null ) && this.host.equals( rhs.host ) ) ) && ( ( this.certificate == rhs.certificate ) || ( ( this.certificate != null ) && this.certificate.equals( rhs.certificate ) ) ) ) && ( ( this.password == rhs.password ) || ( ( this.password != null ) && this.password.equals( rhs.password ) ) ) ) && ( ( this.port == rhs.port ) || ( ( this.port != null ) && this.port.equals( rhs.port ) ) ) ) && ( ( this.key == rhs.key ) || ( ( this.key != null ) && this.key.equals( rhs.key ) ) ) );
  }

  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty ( "certificate" )
  public Optional< String > getCertificate( ) {
    return Optional.ofNullable( this.certificate );
  }

  /**
   * The redis server location
   */
  @JsonProperty ( "host" )
  public Optional< String > getHost( ) {
    return Optional.ofNullable( this.host );
  }

  /**
   * The private key to use by the tls connection
   */
  @JsonProperty ( "key" )
  public Optional< String > getKey( ) {
    return Optional.ofNullable( this.key );
  }

  /**
   * The redis username password
   */
  @JsonProperty ( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( this.password );
  }

  /**
   * The redis server port
   */
  @JsonProperty ( "port" )
  public Optional< BigDecimal > getPort( ) {
    return Optional.ofNullable( this.port );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.host == null ) ? 0 : this.host.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.certificate == null ) ? 0 : this.certificate.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.password == null ) ? 0 : this.password.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.port == null ) ? 0 : this.port.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.key == null ) ? 0 : this.key.hashCode( ) ) );
    return result;
  }

  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty ( "certificate" )
  public void setCertificate( String certificate ) {
    this.certificate = certificate;
  }

  /**
   * The redis server location
   */
  @JsonProperty ( "host" )
  public void setHost( String host ) {
    this.host = host;
  }

  /**
   * The private key to use by the tls connection
   */
  @JsonProperty ( "key" )
  public void setKey( String key ) {
    this.key = key;
  }

  /**
   * The redis username password
   */
  @JsonProperty ( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * The redis server port
   */
  @JsonProperty ( "port" )
  public void setPort( BigDecimal port ) {
    this.port = port;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseRedis.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "host" );
    sb.append( '=' );
    sb.append( ( ( this.host == null ) ? "<null>" : this.host ) );
    sb.append( ',' );
    sb.append( "port" );
    sb.append( '=' );
    sb.append( ( ( this.port == null ) ? "<null>" : this.port ) );
    sb.append( ',' );
    sb.append( "password" );
    sb.append( '=' );
    sb.append( ( ( this.password == null ) ? "<null>" : this.password ) );
    sb.append( ',' );
    sb.append( "certificate" );
    sb.append( '=' );
    sb.append( ( ( this.certificate == null ) ? "<null>" : this.certificate ) );
    sb.append( ',' );
    sb.append( "key" );
    sb.append( '=' );
    sb.append( ( ( this.key == null ) ? "<null>" : this.key ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
