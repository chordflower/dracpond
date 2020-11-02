package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Optional;


/**
 * Definitions related to the arango database
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "host",
  "port",
  "secure",
  "username",
  "password"
} )
public class BaseDatabase implements Serializable {

  private final static long serialVersionUID = -6805001319856652238L;
  /**
   * The arangodb host
   */
  @JsonProperty( "host" )
  @JsonPropertyDescription( "The arangodb host" )
  private String host = "127.0.0.1";
  /**
   * The arangodb server port
   */
  @JsonProperty( "port" )
  @JsonPropertyDescription( "The arangodb server port" )
  @DecimalMin( "1" )
  @DecimalMax( "65535" )
  private BigInteger port = new BigInteger( "8529" );
  /**
   * Enable tls connection
   */
  @JsonProperty( "secure" )
  @JsonPropertyDescription( "Enable tls connection" )
  private Boolean secure = false;
  /**
   * The username to login to the arangodb server
   */
  @JsonProperty( "username" )
  @JsonPropertyDescription( "The username to login to the arangodb server" )
  private String username;
  /**
   * The password of the given username
   */
  @JsonProperty( "password" )
  @JsonPropertyDescription( "The password of the given username" )
  private String password;

  /**
   * The arangodb host
   */
  @JsonProperty( "host" )
  public Optional< String > getHost( ) {
    return Optional.ofNullable( host );
  }

  /**
   * The arangodb host
   */
  @JsonProperty( "host" )
  public void setHost( String host ) {
    this.host = host;
  }

  /**
   * The arangodb server port
   */
  @JsonProperty( "port" )
  public Optional< BigInteger > getPort( ) {
    return Optional.ofNullable( port );
  }

  /**
   * The arangodb server port
   */
  @JsonProperty( "port" )
  public void setPort( BigInteger port ) {
    this.port = port;
  }

  /**
   * Enable tls connection
   */
  @JsonProperty( "secure" )
  public Optional< Boolean > getSecure( ) {
    return Optional.ofNullable( secure );
  }

  /**
   * Enable tls connection
   */
  @JsonProperty( "secure" )
  public void setSecure( Boolean secure ) {
    this.secure = secure;
  }

  /**
   * The username to login to the arangodb server
   */
  @JsonProperty( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( username );
  }

  /**
   * The username to login to the arangodb server
   */
  @JsonProperty( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  /**
   * The password of the given username
   */
  @JsonProperty( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( password );
  }

  /**
   * The password of the given username
   */
  @JsonProperty( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

}
