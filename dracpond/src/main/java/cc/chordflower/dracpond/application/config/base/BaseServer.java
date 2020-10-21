
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

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

/**
 * Server related properties
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "address", "port", "background", "certificate", "key", "logToFile", "session", "limits" } )
public class BaseServer implements Serializable {

  public static class BaseServerBuilder< T extends BaseServer > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseServerBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseServer.BaseServerBuilder.class ) ) {
        this.instance = ( ( T )new BaseServer( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseServer.BaseServerBuilder withAddress( String address ) {
      ( ( BaseServer )this.instance ).address = address;
      return this;
    }

    public BaseServer.BaseServerBuilder withBackground( Boolean background ) {
      ( ( BaseServer )this.instance ).background = background;
      return this;
    }

    public BaseServer.BaseServerBuilder withCertificate( String certificate ) {
      ( ( BaseServer )this.instance ).certificate = certificate;
      return this;
    }

    public BaseServer.BaseServerBuilder withKey( String key ) {
      ( ( BaseServer )this.instance ).key = key;
      return this;
    }

    public BaseServer.BaseServerBuilder withLimits( BaseLimits limits ) {
      ( ( BaseServer )this.instance ).limits = limits;
      return this;
    }

    public BaseServer.BaseServerBuilder withLogToFile( Boolean logToFile ) {
      ( ( BaseServer )this.instance ).logToFile = logToFile;
      return this;
    }

    public BaseServer.BaseServerBuilder withPort( BigDecimal port ) {
      ( ( BaseServer )this.instance ).port = port;
      return this;
    }

    public BaseServer.BaseServerBuilder withSession( BaseSession session ) {
      ( ( BaseServer )this.instance ).session = session;
      return this;
    }

  }

  private final static long serialVersionUID = 4276948878987908022L;
  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty ( "address" )
  @JsonPropertyDescription ( "The address the server should listen to it must be an ip address" )
  private String address = "127.0.0.1";
  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty ( "port" )
  @JsonPropertyDescription ( "The port the server should listen to (default is a random available port)" )
  @DecimalMin ( "0" )
  @DecimalMax ( "65535" )
  private BigDecimal port;
  /**
   * True if the server should be a daemon
   */
  @JsonProperty ( "background" )
  @JsonPropertyDescription ( "True if the server should be a daemon" )
  private Boolean background = true;
  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty ( "certificate" )
  @JsonPropertyDescription ( "The certificate (public key) to use by the server (activates tls)" )
  private String certificate;
  /**
   * The private key to use by the server
   */
  @JsonProperty ( "key" )
  @JsonPropertyDescription ( "The private key to use by the server" )
  private String key;
  /**
   * Enable logging to a file
   */
  @JsonProperty ( "logToFile" )
  @JsonPropertyDescription ( "Enable logging to a file" )
  private Boolean logToFile = true;
  /**
   * Configuration related to the session
   */
  @JsonProperty ( "session" )
  @JsonPropertyDescription ( "Configuration related to the session" )
  @Valid
  private BaseSession session;

  /**
   * Several server limit configurations
   */
  @JsonProperty ( "limits" )
  @JsonPropertyDescription ( "Several server limit configurations" )
  @Valid
  private BaseLimits limits;

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseServer ) == false ) {
      return false;
    }
    var rhs = ( ( BaseServer )other );
    return ( ( ( ( ( ( ( ( ( this.address == rhs.address ) || ( ( this.address != null ) && this.address.equals( rhs.address ) ) ) && ( ( this.port == rhs.port ) || ( ( this.port != null ) && this.port.equals( rhs.port ) ) ) ) && ( ( this.background == rhs.background ) || ( ( this.background != null ) && this.background.equals( rhs.background ) ) ) ) && ( ( this.session == rhs.session ) || ( ( this.session != null ) && this.session.equals( rhs.session ) ) ) ) && ( ( this.certificate == rhs.certificate ) || ( ( this.certificate != null ) && this.certificate.equals( rhs.certificate ) ) ) ) && ( ( this.logToFile == rhs.logToFile ) || ( ( this.logToFile != null ) && this.logToFile.equals( rhs.logToFile ) ) ) ) && ( ( this.key == rhs.key ) || ( ( this.key != null ) && this.key.equals( rhs.key ) ) ) ) && ( ( this.limits == rhs.limits ) || ( ( this.limits != null ) && this.limits.equals( rhs.limits ) ) ) );
  }

  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty ( "address" )
  public Optional< String > getAddress( ) {
    return Optional.ofNullable( this.address );
  }

  /**
   * True if the server should be a daemon
   */
  @JsonProperty ( "background" )
  public Optional< Boolean > getBackground( ) {
    return Optional.ofNullable( this.background );
  }

  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty ( "certificate" )
  public Optional< String > getCertificate( ) {
    return Optional.ofNullable( this.certificate );
  }

  /**
   * The private key to use by the server
   */
  @JsonProperty ( "key" )
  public Optional< String > getKey( ) {
    return Optional.ofNullable( this.key );
  }

  /**
   * Several server limit configurations
   */
  @JsonProperty ( "limits" )
  public Optional< BaseLimits > getLimits( ) {
    return Optional.ofNullable( this.limits );
  }

  /**
   * Enable logging to a file
   */
  @JsonProperty ( "logToFile" )
  public Optional< Boolean > getLogToFile( ) {
    return Optional.ofNullable( this.logToFile );
  }

  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty ( "port" )
  public Optional< BigDecimal > getPort( ) {
    return Optional.ofNullable( this.port );
  }

  /**
   * Configuration related to the session
   */
  @JsonProperty ( "session" )
  public Optional< BaseSession > getSession( ) {
    return Optional.ofNullable( this.session );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.address == null ) ? 0 : this.address.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.port == null ) ? 0 : this.port.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.background == null ) ? 0 : this.background.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.session == null ) ? 0 : this.session.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.certificate == null ) ? 0 : this.certificate.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.logToFile == null ) ? 0 : this.logToFile.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.key == null ) ? 0 : this.key.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.limits == null ) ? 0 : this.limits.hashCode( ) ) );
    return result;
  }

  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty ( "address" )
  public void setAddress( String address ) {
    this.address = address;
  }

  /**
   * True if the server should be a daemon
   */
  @JsonProperty ( "background" )
  public void setBackground( Boolean background ) {
    this.background = background;
  }

  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty ( "certificate" )
  public void setCertificate( String certificate ) {
    this.certificate = certificate;
  }

  /**
   * The private key to use by the server
   */
  @JsonProperty ( "key" )
  public void setKey( String key ) {
    this.key = key;
  }

  /**
   * Several server limit configurations
   */
  @JsonProperty ( "limits" )
  public void setLimits( BaseLimits limits ) {
    this.limits = limits;
  }

  /**
   * Enable logging to a file
   */
  @JsonProperty ( "logToFile" )
  public void setLogToFile( Boolean logToFile ) {
    this.logToFile = logToFile;
  }

  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty ( "port" )
  public void setPort( BigDecimal port ) {
    this.port = port;
  }

  /**
   * Configuration related to the session
   */
  @JsonProperty ( "session" )
  public void setSession( BaseSession session ) {
    this.session = session;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseServer.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "address" );
    sb.append( '=' );
    sb.append( ( ( this.address == null ) ? "<null>" : this.address ) );
    sb.append( ',' );
    sb.append( "port" );
    sb.append( '=' );
    sb.append( ( ( this.port == null ) ? "<null>" : this.port ) );
    sb.append( ',' );
    sb.append( "background" );
    sb.append( '=' );
    sb.append( ( ( this.background == null ) ? "<null>" : this.background ) );
    sb.append( ',' );
    sb.append( "certificate" );
    sb.append( '=' );
    sb.append( ( ( this.certificate == null ) ? "<null>" : this.certificate ) );
    sb.append( ',' );
    sb.append( "key" );
    sb.append( '=' );
    sb.append( ( ( this.key == null ) ? "<null>" : this.key ) );
    sb.append( ',' );
    sb.append( "logToFile" );
    sb.append( '=' );
    sb.append( ( ( this.logToFile == null ) ? "<null>" : this.logToFile ) );
    sb.append( ',' );
    sb.append( "session" );
    sb.append( '=' );
    sb.append( ( ( this.session == null ) ? "<null>" : this.session ) );
    sb.append( ',' );
    sb.append( "limits" );
    sb.append( '=' );
    sb.append( ( ( this.limits == null ) ? "<null>" : this.limits ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
