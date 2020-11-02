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
 * Describes the management configuration used to control the server
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "address",
  "port",
  "username",
  "password"
} )
public class BaseManagement implements Serializable {

  private final static long serialVersionUID = -5085971958169986509L;
  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty( "address" )
  @JsonPropertyDescription( "The address the management server should listen to it must be an ip address" )
  private String address = "127.0.0.1";
  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty( "port" )
  @JsonPropertyDescription( "The port the management server should listen to (default is a random available port)" )
  @DecimalMin( "0" )
  @DecimalMax( "65535" )
  private BigDecimal port;
  /**
   * The management server username
   */
  @JsonProperty( "username" )
  @JsonPropertyDescription( "The management server username" )
  private String username = "admin";
  /**
   * The management server username password
   */
  @JsonProperty( "password" )
  @JsonPropertyDescription( "The management server username password" )
  private String password = "admin123";

  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty( "address" )
  public Optional< String > getAddress( ) {
    return Optional.ofNullable( address );
  }

  /**
   * The address the management server should listen to it must be an ip address
   */
  @JsonProperty( "address" )
  public void setAddress( String address ) {
    this.address = address;
  }

  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty( "port" )
  public Optional< BigDecimal > getPort( ) {
    return Optional.ofNullable( port );
  }

  /**
   * The port the management server should listen to (default is a random available port)
   */
  @JsonProperty( "port" )
  public void setPort( BigDecimal port ) {
    this.port = port;
  }

  /**
   * The management server username
   */
  @JsonProperty( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( username );
  }

  /**
   * The management server username
   */
  @JsonProperty( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  /**
   * The management server username password
   */
  @JsonProperty( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( password );
  }

  /**
   * The management server username password
   */
  @JsonProperty( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

}
