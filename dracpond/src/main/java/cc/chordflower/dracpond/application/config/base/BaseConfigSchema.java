
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.Valid;

/**
 * Schema for the configuration file
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "$schema", "server", "loggly", "database", "proxy", "discovery", "redis", "management", "mail" } )
public class BaseConfigSchema implements Serializable {

  public static class BaseConfigSchemaBuilder< T extends BaseConfigSchema > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseConfigSchemaBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseConfigSchema.BaseConfigSchemaBuilder.class ) ) {
        this.instance = ( ( T )new BaseConfigSchema( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder with$schema( String $schema ) {
      ( ( BaseConfigSchema )this.instance ).$schema = $schema;
      return this;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder withDatabase( BaseDatabase database ) {
      ( ( BaseConfigSchema )this.instance ).database = database;
      return this;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder withDiscovery( BaseDiscovery discovery ) {
      ( ( BaseConfigSchema )this.instance ).discovery = discovery;
      return this;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder withLoggly( BaseLoggly loggly ) {
      ( ( BaseConfigSchema )this.instance ).loggly = loggly;
      return this;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder withMail( BaseMail mail ) {
      ( ( BaseConfigSchema )this.instance ).mail = mail;
      return this;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder withManagement( BaseManagement management ) {
      ( ( BaseConfigSchema )this.instance ).management = management;
      return this;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder withProxy( List< BaseProxy > proxy ) {
      ( ( BaseConfigSchema )this.instance ).proxy = proxy;
      return this;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder withRedis( BaseRedis redis ) {
      ( ( BaseConfigSchema )this.instance ).redis = redis;
      return this;
    }

    public BaseConfigSchema.BaseConfigSchemaBuilder withServer( BaseServer server ) {
      ( ( BaseConfigSchema )this.instance ).server = server;
      return this;
    }

  }

  private final static long serialVersionUID = -6648386698255199100L;
  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty ( "$schema" )
  @JsonPropertyDescription ( "the configuration schema always a reference to this document" )
  private String $schema;
  /**
   * Server related properties
   */
  @JsonProperty ( "server" )
  @JsonPropertyDescription ( "Server related properties" )
  @Valid
  private BaseServer server;
  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty ( "loggly" )
  @JsonPropertyDescription ( "Definitions related to the loggly log server" )
  @Valid
  private BaseLoggly loggly;
  /**
   * Definitions related to the arango database
   */
  @JsonProperty ( "database" )
  @JsonPropertyDescription ( "Definitions related to the arango database" )
  @Valid
  private BaseDatabase database;
  /**
   * The proxy to use for remote connections
   */
  @JsonProperty ( "proxy" )
  @JsonPropertyDescription ( "The proxy to use for remote connections" )
  @Valid
  private List< BaseProxy > proxy = new ArrayList<>( );
  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty ( "discovery" )
  @JsonPropertyDescription ( "Definitions related to the registration in a consul server" )
  @Valid
  private BaseDiscovery discovery;
  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty ( "redis" )
  @JsonPropertyDescription ( "Definitions related to the redis server used for cache" )
  @Valid
  private BaseRedis redis;
  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty ( "management" )
  @JsonPropertyDescription ( "Describes the management configuration used to control the server" )
  @Valid
  private BaseManagement management;

  /**
   * Information about the smtp server to use
   */
  @JsonProperty ( "mail" )
  @JsonPropertyDescription ( "Information about the smtp server to use" )
  @Valid
  private BaseMail mail;

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseConfigSchema ) == false ) {
      return false;
    }
    var rhs = ( ( BaseConfigSchema )other );
    return ( ( ( ( ( ( ( ( ( ( this.server == rhs.server ) || ( ( this.server != null ) && this.server.equals( rhs.server ) ) ) && ( ( this.proxy == rhs.proxy ) || ( ( this.proxy != null ) && this.proxy.equals( rhs.proxy ) ) ) ) && ( ( this.database == rhs.database ) || ( ( this.database != null ) && this.database.equals( rhs.database ) ) ) ) && ( ( this.$schema == rhs.$schema ) || ( ( this.$schema != null ) && this.$schema.equals( rhs.$schema ) ) ) ) && ( ( this.mail == rhs.mail ) || ( ( this.mail != null ) && this.mail.equals( rhs.mail ) ) ) ) && ( ( this.management == rhs.management ) || ( ( this.management != null ) && this.management.equals( rhs.management ) ) ) ) && ( ( this.discovery == rhs.discovery ) || ( ( this.discovery != null ) && this.discovery.equals( rhs.discovery ) ) ) ) && ( ( this.loggly == rhs.loggly ) || ( ( this.loggly != null ) && this.loggly.equals( rhs.loggly ) ) ) ) && ( ( this.redis == rhs.redis ) || ( ( this.redis != null ) && this.redis.equals( rhs.redis ) ) ) );
  }

  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty ( "$schema" )
  public Optional< String > get$schema( ) {
    return Optional.ofNullable( this.$schema );
  }

  /**
   * Definitions related to the arango database
   */
  @JsonProperty ( "database" )
  public Optional< BaseDatabase > getDatabase( ) {
    return Optional.ofNullable( this.database );
  }

  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty ( "discovery" )
  public Optional< BaseDiscovery > getDiscovery( ) {
    return Optional.ofNullable( this.discovery );
  }

  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty ( "loggly" )
  public Optional< BaseLoggly > getLoggly( ) {
    return Optional.ofNullable( this.loggly );
  }

  /**
   * Information about the smtp server to use
   */
  @JsonProperty ( "mail" )
  public Optional< BaseMail > getMail( ) {
    return Optional.ofNullable( this.mail );
  }

  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty ( "management" )
  public Optional< BaseManagement > getManagement( ) {
    return Optional.ofNullable( this.management );
  }

  /**
   * The proxy to use for remote connections
   */
  @JsonProperty ( "proxy" )
  public Optional< List< BaseProxy > > getProxy( ) {
    return Optional.ofNullable( this.proxy );
  }

  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty ( "redis" )
  public Optional< BaseRedis > getRedis( ) {
    return Optional.ofNullable( this.redis );
  }

  /**
   * Server related properties
   */
  @JsonProperty ( "server" )
  public Optional< BaseServer > getServer( ) {
    return Optional.ofNullable( this.server );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.server == null ) ? 0 : this.server.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.proxy == null ) ? 0 : this.proxy.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.database == null ) ? 0 : this.database.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.$schema == null ) ? 0 : this.$schema.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.mail == null ) ? 0 : this.mail.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.management == null ) ? 0 : this.management.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.discovery == null ) ? 0 : this.discovery.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.loggly == null ) ? 0 : this.loggly.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.redis == null ) ? 0 : this.redis.hashCode( ) ) );
    return result;
  }

  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty ( "$schema" )
  public void set$schema( String $schema ) {
    this.$schema = $schema;
  }

  /**
   * Definitions related to the arango database
   */
  @JsonProperty ( "database" )
  public void setDatabase( BaseDatabase database ) {
    this.database = database;
  }

  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty ( "discovery" )
  public void setDiscovery( BaseDiscovery discovery ) {
    this.discovery = discovery;
  }

  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty ( "loggly" )
  public void setLoggly( BaseLoggly loggly ) {
    this.loggly = loggly;
  }

  /**
   * Information about the smtp server to use
   */
  @JsonProperty ( "mail" )
  public void setMail( BaseMail mail ) {
    this.mail = mail;
  }

  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty ( "management" )
  public void setManagement( BaseManagement management ) {
    this.management = management;
  }

  /**
   * The proxy to use for remote connections
   */
  @JsonProperty ( "proxy" )
  public void setProxy( List< BaseProxy > proxy ) {
    this.proxy = proxy;
  }

  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty ( "redis" )
  public void setRedis( BaseRedis redis ) {
    this.redis = redis;
  }

  /**
   * Server related properties
   */
  @JsonProperty ( "server" )
  public void setServer( BaseServer server ) {
    this.server = server;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseConfigSchema.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "$schema" );
    sb.append( '=' );
    sb.append( ( ( this.$schema == null ) ? "<null>" : this.$schema ) );
    sb.append( ',' );
    sb.append( "server" );
    sb.append( '=' );
    sb.append( ( ( this.server == null ) ? "<null>" : this.server ) );
    sb.append( ',' );
    sb.append( "loggly" );
    sb.append( '=' );
    sb.append( ( ( this.loggly == null ) ? "<null>" : this.loggly ) );
    sb.append( ',' );
    sb.append( "database" );
    sb.append( '=' );
    sb.append( ( ( this.database == null ) ? "<null>" : this.database ) );
    sb.append( ',' );
    sb.append( "proxy" );
    sb.append( '=' );
    sb.append( ( ( this.proxy == null ) ? "<null>" : this.proxy ) );
    sb.append( ',' );
    sb.append( "discovery" );
    sb.append( '=' );
    sb.append( ( ( this.discovery == null ) ? "<null>" : this.discovery ) );
    sb.append( ',' );
    sb.append( "redis" );
    sb.append( '=' );
    sb.append( ( ( this.redis == null ) ? "<null>" : this.redis ) );
    sb.append( ',' );
    sb.append( "management" );
    sb.append( '=' );
    sb.append( ( ( this.management == null ) ? "<null>" : this.management ) );
    sb.append( ',' );
    sb.append( "mail" );
    sb.append( '=' );
    sb.append( ( ( this.mail == null ) ? "<null>" : this.mail ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
