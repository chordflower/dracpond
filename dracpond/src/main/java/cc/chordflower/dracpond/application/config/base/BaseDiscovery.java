package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Definitions related to the registration in a consul server
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "enabled",
  "host",
  "port",
  "secure",
  "datacenter",
  "token",
  "ca"
} )
public class BaseDiscovery implements Serializable {

  private final static long serialVersionUID = -618616054466136310L;
  /**
   * Enable the consul registration
   */
  @JsonProperty( "enabled" )
  @JsonPropertyDescription( "Enable the consul registration" )
  private Boolean enabled = false;
  /**
   * The location of the consul server
   */
  @JsonProperty( "host" )
  @JsonPropertyDescription( "The location of the consul server" )
  private String host = "127.0.0.1";
  /**
   * The consul server port
   */
  @JsonProperty( "port" )
  @JsonPropertyDescription( "The consul server port" )
  @DecimalMin( "1" )
  @DecimalMax( "65535" )
  private BigInteger port = new BigInteger( "8500" );
  /**
   * If a secure connection is needed
   */
  @JsonProperty( "secure" )
  @JsonPropertyDescription( "If a secure connection is needed" )
  private Boolean secure = false;
  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty( "datacenter" )
  @JsonPropertyDescription( "The datacenter to use (defaults to local for agent)" )
  private String datacenter;
  /**
   * The token to use (defaults to none)
   */
  @JsonProperty( "token" )
  @JsonPropertyDescription( "The token to use (defaults to none)" )
  private String token;
  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty( "ca" )
  @JsonPropertyDescription( "The certificates to use in pem format (defaults to none)" )
  @Valid
  private List< String > ca = new ArrayList< String >( );

  /**
   * Enable the consul registration
   */
  @JsonProperty( "enabled" )
  public Optional< Boolean > getEnabled( ) {
    return Optional.ofNullable( enabled );
  }

  /**
   * Enable the consul registration
   */
  @JsonProperty( "enabled" )
  public void setEnabled( Boolean enabled ) {
    this.enabled = enabled;
  }

  /**
   * The location of the consul server
   */
  @JsonProperty( "host" )
  public Optional< String > getHost( ) {
    return Optional.ofNullable( host );
  }

  /**
   * The location of the consul server
   */
  @JsonProperty( "host" )
  public void setHost( String host ) {
    this.host = host;
  }

  /**
   * The consul server port
   */
  @JsonProperty( "port" )
  public Optional< BigInteger > getPort( ) {
    return Optional.ofNullable( port );
  }

  /**
   * The consul server port
   */
  @JsonProperty( "port" )
  public void setPort( BigInteger port ) {
    this.port = port;
  }

  /**
   * If a secure connection is needed
   */
  @JsonProperty( "secure" )
  public Optional< Boolean > getSecure( ) {
    return Optional.ofNullable( secure );
  }

  /**
   * If a secure connection is needed
   */
  @JsonProperty( "secure" )
  public void setSecure( Boolean secure ) {
    this.secure = secure;
  }

  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty( "datacenter" )
  public Optional< String > getDatacenter( ) {
    return Optional.ofNullable( datacenter );
  }

  /**
   * The datacenter to use (defaults to local for agent)
   */
  @JsonProperty( "datacenter" )
  public void setDatacenter( String datacenter ) {
    this.datacenter = datacenter;
  }

  /**
   * The token to use (defaults to none)
   */
  @JsonProperty( "token" )
  public Optional< String > getToken( ) {
    return Optional.ofNullable( token );
  }

  /**
   * The token to use (defaults to none)
   */
  @JsonProperty( "token" )
  public void setToken( String token ) {
    this.token = token;
  }

  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty( "ca" )
  public Optional< List< String > > getCa( ) {
    return Optional.ofNullable( ca );
  }

  /**
   * The certificates to use in pem format (defaults to none)
   */
  @JsonProperty( "ca" )
  public void setCa( List< String > ca ) {
    this.ca = ca;
  }

}
