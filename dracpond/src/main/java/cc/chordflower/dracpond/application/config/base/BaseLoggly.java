
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
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Definitions related to the loggly log server
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "enabled", "subdomain", "token", "username", "password" } )
public class BaseLoggly implements Serializable {

  public static class BaseLogglyBuilder< T extends BaseLoggly > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseLogglyBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseLoggly.BaseLogglyBuilder.class ) ) {
        this.instance = ( ( T )new BaseLoggly( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseLoggly.BaseLogglyBuilder withEnabled( Boolean enabled ) {
      ( ( BaseLoggly )this.instance ).enabled = enabled;
      return this;
    }

    public BaseLoggly.BaseLogglyBuilder withPassword( String password ) {
      ( ( BaseLoggly )this.instance ).password = password;
      return this;
    }

    public BaseLoggly.BaseLogglyBuilder withSubdomain( String subdomain ) {
      ( ( BaseLoggly )this.instance ).subdomain = subdomain;
      return this;
    }

    public BaseLoggly.BaseLogglyBuilder withToken( String token ) {
      ( ( BaseLoggly )this.instance ).token = token;
      return this;
    }

    public BaseLoggly.BaseLogglyBuilder withUsername( String username ) {
      ( ( BaseLoggly )this.instance ).username = username;
      return this;
    }

  }

  private final static long serialVersionUID = 6525740350377242347L;
  /**
   * If the loggly logger is enabled
   */
  @JsonProperty ( "enabled" )
  @JsonPropertyDescription ( "If the loggly logger is enabled" )
  private Boolean enabled = false;
  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty ( "subdomain" )
  @JsonPropertyDescription ( "The subdomain of your Loggly account" )
  private String subdomain;
  /**
   * The access token
   */
  @JsonProperty ( "token" )
  @JsonPropertyDescription ( "The access token" )
  private String token;
  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty ( "username" )
  @JsonPropertyDescription ( "The authentication information for your Loggly account (username)" )
  private String username;

  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty ( "password" )
  @JsonPropertyDescription ( "The authentication information for your Loggly account (password)" )
  private String password;

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseLoggly ) == false ) {
      return false;
    }
    var rhs = ( ( BaseLoggly )other );
    return ( ( ( ( ( ( this.subdomain == rhs.subdomain ) || ( ( this.subdomain != null ) && this.subdomain.equals( rhs.subdomain ) ) ) && ( ( this.password == rhs.password ) || ( ( this.password != null ) && this.password.equals( rhs.password ) ) ) ) && ( ( this.enabled == rhs.enabled ) || ( ( this.enabled != null ) && this.enabled.equals( rhs.enabled ) ) ) ) && ( ( this.token == rhs.token ) || ( ( this.token != null ) && this.token.equals( rhs.token ) ) ) ) && ( ( this.username == rhs.username ) || ( ( this.username != null ) && this.username.equals( rhs.username ) ) ) );
  }

  /**
   * If the loggly logger is enabled
   */
  @JsonProperty ( "enabled" )
  public Optional< Boolean > getEnabled( ) {
    return Optional.ofNullable( this.enabled );
  }

  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty ( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( this.password );
  }

  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty ( "subdomain" )
  public Optional< String > getSubdomain( ) {
    return Optional.ofNullable( this.subdomain );
  }

  /**
   * The access token
   */
  @JsonProperty ( "token" )
  public Optional< String > getToken( ) {
    return Optional.ofNullable( this.token );
  }

  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty ( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( this.username );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.subdomain == null ) ? 0 : this.subdomain.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.password == null ) ? 0 : this.password.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.enabled == null ) ? 0 : this.enabled.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.token == null ) ? 0 : this.token.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.username == null ) ? 0 : this.username.hashCode( ) ) );
    return result;
  }

  /**
   * If the loggly logger is enabled
   */
  @JsonProperty ( "enabled" )
  public void setEnabled( Boolean enabled ) {
    this.enabled = enabled;
  }

  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty ( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty ( "subdomain" )
  public void setSubdomain( String subdomain ) {
    this.subdomain = subdomain;
  }

  /**
   * The access token
   */
  @JsonProperty ( "token" )
  public void setToken( String token ) {
    this.token = token;
  }

  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty ( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseLoggly.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "enabled" );
    sb.append( '=' );
    sb.append( ( ( this.enabled == null ) ? "<null>" : this.enabled ) );
    sb.append( ',' );
    sb.append( "subdomain" );
    sb.append( '=' );
    sb.append( ( ( this.subdomain == null ) ? "<null>" : this.subdomain ) );
    sb.append( ',' );
    sb.append( "token" );
    sb.append( '=' );
    sb.append( ( ( this.token == null ) ? "<null>" : this.token ) );
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
