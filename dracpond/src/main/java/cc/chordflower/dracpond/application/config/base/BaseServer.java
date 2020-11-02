package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;


/**
 * Server related properties
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "address",
  "port",
  "background",
  "certificate",
  "key",
  "logToFile",
  "session",
  "limits"
} )
public class BaseServer implements Serializable {

  private final static long serialVersionUID = 4478287594587692598L;
  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty( "address" )
  @JsonPropertyDescription( "The address the server should listen to it must be an ip address" )
  private String address = "127.0.0.1";
  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty( "port" )
  @JsonPropertyDescription( "The port the server should listen to (default is a random available port)" )
  @DecimalMin( "0" )
  @DecimalMax( "65535" )
  private BigDecimal port;
  /**
   * True if the server should be a daemon
   */
  @JsonProperty( "background" )
  @JsonPropertyDescription( "True if the server should be a daemon" )
  private Boolean background = true;
  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty( "certificate" )
  @JsonPropertyDescription( "The certificate (public key) to use by the server (activates tls)" )
  private String certificate;
  /**
   * The private key to use by the server
   */
  @JsonProperty( "key" )
  @JsonPropertyDescription( "The private key to use by the server" )
  private String key;
  /**
   * Enable logging to a file
   */
  @JsonProperty( "logToFile" )
  @JsonPropertyDescription( "Enable logging to a file" )
  private Boolean logToFile = true;
  /**
   * Configuration related to the session
   */
  @JsonProperty( "session" )
  @JsonPropertyDescription( "Configuration related to the session" )
  @Valid
  private BaseSession session;
  /**
   * Several server limit configurations
   */
  @JsonProperty( "limits" )
  @JsonPropertyDescription( "Several server limit configurations" )
  @Valid
  private BaseLimits limits;

  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty( "address" )
  public Optional< String > getAddress( ) {
    return Optional.ofNullable( address );
  }

  /**
   * The address the server should listen to it must be an ip address
   */
  @JsonProperty( "address" )
  public void setAddress( String address ) {
    this.address = address;
  }

  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty( "port" )
  public Optional< BigDecimal > getPort( ) {
    return Optional.ofNullable( port );
  }

  /**
   * The port the server should listen to (default is a random available port)
   */
  @JsonProperty( "port" )
  public void setPort( BigDecimal port ) {
    this.port = port;
  }

  /**
   * True if the server should be a daemon
   */
  @JsonProperty( "background" )
  public Optional< Boolean > getBackground( ) {
    return Optional.ofNullable( background );
  }

  /**
   * True if the server should be a daemon
   */
  @JsonProperty( "background" )
  public void setBackground( Boolean background ) {
    this.background = background;
  }

  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty( "certificate" )
  public Optional< String > getCertificate( ) {
    return Optional.ofNullable( certificate );
  }

  /**
   * The certificate (public key) to use by the server (activates tls)
   */
  @JsonProperty( "certificate" )
  public void setCertificate( String certificate ) {
    this.certificate = certificate;
  }

  /**
   * The private key to use by the server
   */
  @JsonProperty( "key" )
  public Optional< String > getKey( ) {
    return Optional.ofNullable( key );
  }

  /**
   * The private key to use by the server
   */
  @JsonProperty( "key" )
  public void setKey( String key ) {
    this.key = key;
  }

  /**
   * Enable logging to a file
   */
  @JsonProperty( "logToFile" )
  public Optional< Boolean > getLogToFile( ) {
    return Optional.ofNullable( logToFile );
  }

  /**
   * Enable logging to a file
   */
  @JsonProperty( "logToFile" )
  public void setLogToFile( Boolean logToFile ) {
    this.logToFile = logToFile;
  }

  /**
   * Configuration related to the session
   */
  @JsonProperty( "session" )
  public Optional< BaseSession > getSession( ) {
    return Optional.ofNullable( session );
  }

  /**
   * Configuration related to the session
   */
  @JsonProperty( "session" )
  public void setSession( BaseSession session ) {
    this.session = session;
  }

  /**
   * Several server limit configurations
   */
  @JsonProperty( "limits" )
  public Optional< BaseLimits > getLimits( ) {
    return Optional.ofNullable( limits );
  }

  /**
   * Several server limit configurations
   */
  @JsonProperty( "limits" )
  public void setLimits( BaseLimits limits ) {
    this.limits = limits;
  }

}
