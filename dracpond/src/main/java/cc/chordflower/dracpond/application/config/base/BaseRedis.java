package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;


/**
 * Definitions related to the redis server used for cache
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "host",
  "port",
  "password",
  "certificate",
  "key"
} )
public class BaseRedis implements Serializable {

  private final static long serialVersionUID = -2052245701145607096L;
  /**
   * The redis server location
   */
  @JsonProperty( "host" )
  @JsonPropertyDescription( "The redis server location" )
  private String host = "127.0.0.1";
  /**
   * The redis server port
   */
  @JsonProperty( "port" )
  @JsonPropertyDescription( "The redis server port" )
  @DecimalMin( "1" )
  @DecimalMax( "65535" )
  private BigDecimal port = new BigDecimal( "6379" );
  /**
   * The redis username password
   */
  @JsonProperty( "password" )
  @JsonPropertyDescription( "The redis username password" )
  private String password;
  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty( "certificate" )
  @JsonPropertyDescription( "The certificate (public key) to use for tls connection (activates tls)" )
  private String certificate;
  /**
   * The private key to use by the tls connection
   */
  @JsonProperty( "key" )
  @JsonPropertyDescription( "The private key to use by the tls connection" )
  private String key;

  /**
   * The redis server location
   */
  @JsonProperty( "host" )
  public Optional< String > getHost( ) {
    return Optional.ofNullable( host );
  }

  /**
   * The redis server location
   */
  @JsonProperty( "host" )
  public void setHost( String host ) {
    this.host = host;
  }

  /**
   * The redis server port
   */
  @JsonProperty( "port" )
  public Optional< BigDecimal > getPort( ) {
    return Optional.ofNullable( port );
  }

  /**
   * The redis server port
   */
  @JsonProperty( "port" )
  public void setPort( BigDecimal port ) {
    this.port = port;
  }

  /**
   * The redis username password
   */
  @JsonProperty( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( password );
  }

  /**
   * The redis username password
   */
  @JsonProperty( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty( "certificate" )
  public Optional< String > getCertificate( ) {
    return Optional.ofNullable( certificate );
  }

  /**
   * The certificate (public key) to use for tls connection (activates tls)
   */
  @JsonProperty( "certificate" )
  public void setCertificate( String certificate ) {
    this.certificate = certificate;
  }

  /**
   * The private key to use by the tls connection
   */
  @JsonProperty( "key" )
  public Optional< String > getKey( ) {
    return Optional.ofNullable( key );
  }

  /**
   * The private key to use by the tls connection
   */
  @JsonProperty( "key" )
  public void setKey( String key ) {
    this.key = key;
  }

}
