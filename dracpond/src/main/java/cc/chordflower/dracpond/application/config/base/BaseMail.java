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
 * Information about the smtp server to use
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "address",
  "port",
  "username",
  "password",
  "secure",
  "from"
} )
public class BaseMail implements Serializable {

  private final static long serialVersionUID = -1812476193304986912L;
  /**
   * The smtp server address
   */
  @JsonProperty( "address" )
  @JsonPropertyDescription( "The smtp server address" )
  private String address = "127.0.0.1";
  /**
   * The port the smtp server
   */
  @JsonProperty( "port" )
  @JsonPropertyDescription( "The port the smtp server" )
  @DecimalMin( "1" )
  @DecimalMax( "65535" )
  private BigDecimal port = new BigDecimal( "654" );
  /**
   * The smtp server username
   */
  @JsonProperty( "username" )
  @JsonPropertyDescription( "The smtp server username" )
  private String username;
  /**
   * The smtp server username password
   */
  @JsonProperty( "password" )
  @JsonPropertyDescription( "The smtp server username password" )
  private String password;
  /**
   * If a secure connection should be made
   */
  @JsonProperty( "secure" )
  @JsonPropertyDescription( "If a secure connection should be made" )
  private Boolean secure = false;
  /**
   * The email address that we should sent emails from
   */
  @JsonProperty( "from" )
  @JsonPropertyDescription( "The email address that we should sent emails from" )
  private String from = "admin@example.com";

  /**
   * The smtp server address
   */
  @JsonProperty( "address" )
  public Optional< String > getAddress( ) {
    return Optional.ofNullable( address );
  }

  /**
   * The smtp server address
   */
  @JsonProperty( "address" )
  public void setAddress( String address ) {
    this.address = address;
  }

  /**
   * The port the smtp server
   */
  @JsonProperty( "port" )
  public Optional< BigDecimal > getPort( ) {
    return Optional.ofNullable( port );
  }

  /**
   * The port the smtp server
   */
  @JsonProperty( "port" )
  public void setPort( BigDecimal port ) {
    this.port = port;
  }

  /**
   * The smtp server username
   */
  @JsonProperty( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( username );
  }

  /**
   * The smtp server username
   */
  @JsonProperty( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  /**
   * The smtp server username password
   */
  @JsonProperty( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( password );
  }

  /**
   * The smtp server username password
   */
  @JsonProperty( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * If a secure connection should be made
   */
  @JsonProperty( "secure" )
  public Optional< Boolean > getSecure( ) {
    return Optional.ofNullable( secure );
  }

  /**
   * If a secure connection should be made
   */
  @JsonProperty( "secure" )
  public void setSecure( Boolean secure ) {
    this.secure = secure;
  }

  /**
   * The email address that we should sent emails from
   */
  @JsonProperty( "from" )
  public Optional< String > getFrom( ) {
    return Optional.ofNullable( from );
  }

  /**
   * The email address that we should sent emails from
   */
  @JsonProperty( "from" )
  public void setFrom( String from ) {
    this.from = from;
  }

}
