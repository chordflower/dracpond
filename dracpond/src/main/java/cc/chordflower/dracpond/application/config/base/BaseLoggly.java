package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Optional;


/**
 * Definitions related to the loggly log server
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "enabled",
  "subdomain",
  "token",
  "username",
  "password"
} )
public class BaseLoggly implements Serializable {

  private final static long serialVersionUID = 4530237339952483812L;
  /**
   * If the loggly logger is enabled
   */
  @JsonProperty( "enabled" )
  @JsonPropertyDescription( "If the loggly logger is enabled" )
  private Boolean enabled = false;
  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty( "subdomain" )
  @JsonPropertyDescription( "The subdomain of your Loggly account" )
  private String subdomain;
  /**
   * The access token
   */
  @JsonProperty( "token" )
  @JsonPropertyDescription( "The access token" )
  private String token;
  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty( "username" )
  @JsonPropertyDescription( "The authentication information for your Loggly account (username)" )
  private String username;
  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty( "password" )
  @JsonPropertyDescription( "The authentication information for your Loggly account (password)" )
  private String password;

  /**
   * If the loggly logger is enabled
   */
  @JsonProperty( "enabled" )
  public Optional< Boolean > getEnabled( ) {
    return Optional.ofNullable( enabled );
  }

  /**
   * If the loggly logger is enabled
   */
  @JsonProperty( "enabled" )
  public void setEnabled( Boolean enabled ) {
    this.enabled = enabled;
  }

  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty( "subdomain" )
  public Optional< String > getSubdomain( ) {
    return Optional.ofNullable( subdomain );
  }

  /**
   * The subdomain of your Loggly account
   */
  @JsonProperty( "subdomain" )
  public void setSubdomain( String subdomain ) {
    this.subdomain = subdomain;
  }

  /**
   * The access token
   */
  @JsonProperty( "token" )
  public Optional< String > getToken( ) {
    return Optional.ofNullable( token );
  }

  /**
   * The access token
   */
  @JsonProperty( "token" )
  public void setToken( String token ) {
    this.token = token;
  }

  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( username );
  }

  /**
   * The authentication information for your Loggly account (username)
   */
  @JsonProperty( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( password );
  }

  /**
   * The authentication information for your Loggly account (password)
   */
  @JsonProperty( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

}
