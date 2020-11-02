package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Schema for the configuration file
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "$schema",
  "server",
  "loggly",
  "database",
  "proxy",
  "discovery",
  "redis",
  "management",
  "mail"
} )
public class BaseConfigSchema implements Serializable {

  private final static long serialVersionUID = 5219335981721220472L;
  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty( "$schema" )
  @JsonPropertyDescription( "the configuration schema always a reference to this document" )
  private String $schema;
  /**
   * Server related properties
   */
  @JsonProperty( "server" )
  @JsonPropertyDescription( "Server related properties" )
  @Valid
  private BaseServer server;
  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty( "loggly" )
  @JsonPropertyDescription( "Definitions related to the loggly log server" )
  @Valid
  private BaseLoggly loggly;
  /**
   * Definitions related to the arango database
   */
  @JsonProperty( "database" )
  @JsonPropertyDescription( "Definitions related to the arango database" )
  @Valid
  private BaseDatabase database;
  /**
   * The proxy to use for remote connections
   */
  @JsonProperty( "proxy" )
  @JsonPropertyDescription( "The proxy to use for remote connections" )
  @Valid
  private List< BaseProxy > proxy = new ArrayList< BaseProxy >( );
  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty( "discovery" )
  @JsonPropertyDescription( "Definitions related to the registration in a consul server" )
  @Valid
  private BaseDiscovery discovery;
  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty( "redis" )
  @JsonPropertyDescription( "Definitions related to the redis server used for cache" )
  @Valid
  private BaseRedis redis;
  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty( "management" )
  @JsonPropertyDescription( "Describes the management configuration used to control the server" )
  @Valid
  private BaseManagement management;
  /**
   * Information about the smtp server to use
   */
  @JsonProperty( "mail" )
  @JsonPropertyDescription( "Information about the smtp server to use" )
  @Valid
  private BaseMail mail;

  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty( "$schema" )
  public Optional< String > get$schema( ) {
    return Optional.ofNullable( $schema );
  }

  /**
   * the configuration schema always a reference to this document
   */
  @JsonProperty( "$schema" )
  public void set$schema( String $schema ) {
    this.$schema = $schema;
  }

  /**
   * Server related properties
   */
  @JsonProperty( "server" )
  public Optional< BaseServer > getServer( ) {
    return Optional.ofNullable( server );
  }

  /**
   * Server related properties
   */
  @JsonProperty( "server" )
  public void setServer( BaseServer server ) {
    this.server = server;
  }

  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty( "loggly" )
  public Optional< BaseLoggly > getLoggly( ) {
    return Optional.ofNullable( loggly );
  }

  /**
   * Definitions related to the loggly log server
   */
  @JsonProperty( "loggly" )
  public void setLoggly( BaseLoggly loggly ) {
    this.loggly = loggly;
  }

  /**
   * Definitions related to the arango database
   */
  @JsonProperty( "database" )
  public Optional< BaseDatabase > getDatabase( ) {
    return Optional.ofNullable( database );
  }

  /**
   * Definitions related to the arango database
   */
  @JsonProperty( "database" )
  public void setDatabase( BaseDatabase database ) {
    this.database = database;
  }

  /**
   * The proxy to use for remote connections
   */
  @JsonProperty( "proxy" )
  public Optional< List< BaseProxy > > getProxy( ) {
    return Optional.ofNullable( proxy );
  }

  /**
   * The proxy to use for remote connections
   */
  @JsonProperty( "proxy" )
  public void setProxy( List< BaseProxy > proxy ) {
    this.proxy = proxy;
  }

  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty( "discovery" )
  public Optional< BaseDiscovery > getDiscovery( ) {
    return Optional.ofNullable( discovery );
  }

  /**
   * Definitions related to the registration in a consul server
   */
  @JsonProperty( "discovery" )
  public void setDiscovery( BaseDiscovery discovery ) {
    this.discovery = discovery;
  }

  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty( "redis" )
  public Optional< BaseRedis > getRedis( ) {
    return Optional.ofNullable( redis );
  }

  /**
   * Definitions related to the redis server used for cache
   */
  @JsonProperty( "redis" )
  public void setRedis( BaseRedis redis ) {
    this.redis = redis;
  }

  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty( "management" )
  public Optional< BaseManagement > getManagement( ) {
    return Optional.ofNullable( management );
  }

  /**
   * Describes the management configuration used to control the server
   */
  @JsonProperty( "management" )
  public void setManagement( BaseManagement management ) {
    this.management = management;
  }

  /**
   * Information about the smtp server to use
   */
  @JsonProperty( "mail" )
  public Optional< BaseMail > getMail( ) {
    return Optional.ofNullable( mail );
  }

  /**
   * Information about the smtp server to use
   */
  @JsonProperty( "mail" )
  public void setMail( BaseMail mail ) {
    this.mail = mail;
  }

}
