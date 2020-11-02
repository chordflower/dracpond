package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * The definition of a single proxy
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "enabled",
  "type",
  "host",
  "port",
  "username",
  "password",
  "except"
} )
public class BaseProxy implements Serializable {

  private final static long serialVersionUID = 7282559565066102059L;
  /**
   * If the proxy is enabled
   */
  @JsonProperty( "enabled" )
  @JsonPropertyDescription( "If the proxy is enabled" )
  private Boolean enabled = true;
  /**
   * The protocol to use this proxy for
   */
  @JsonProperty( "type" )
  @JsonPropertyDescription( "The protocol to use this proxy for" )
  private BaseProxy.Type type;
  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty( "host" )
  @JsonPropertyDescription( "The host of this proxy (Include schema)" )
  private String host;
  /**
   * The proxy port
   */
  @JsonProperty( "port" )
  @JsonPropertyDescription( "The proxy port" )
  @DecimalMin( "1" )
  @DecimalMax( "65535" )
  private BigInteger port = new BigInteger( "8500" );
  /**
   * The username to connect to this proxy
   */
  @JsonProperty( "username" )
  @JsonPropertyDescription( "The username to connect to this proxy" )
  private String username;
  /**
   * The password of the user
   */
  @JsonProperty( "password" )
  @JsonPropertyDescription( "The password of the user" )
  private String password;
  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty( "except" )
  @JsonPropertyDescription( "List of domain exceptions that do not pass into this proxy" )
  @Valid
  private List< String > except = new ArrayList< String >( );

  /**
   * If the proxy is enabled
   */
  @JsonProperty( "enabled" )
  public Optional< Boolean > getEnabled( ) {
    return Optional.ofNullable( enabled );
  }

  /**
   * If the proxy is enabled
   */
  @JsonProperty( "enabled" )
  public void setEnabled( Boolean enabled ) {
    this.enabled = enabled;
  }

  /**
   * The protocol to use this proxy for
   */
  @JsonProperty( "type" )
  public Optional< BaseProxy.Type > getType( ) {
    return Optional.ofNullable( type );
  }

  /**
   * The protocol to use this proxy for
   */
  @JsonProperty( "type" )
  public void setType( BaseProxy.Type type ) {
    this.type = type;
  }

  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty( "host" )
  public Optional< String > getHost( ) {
    return Optional.ofNullable( host );
  }

  /**
   * The host of this proxy (Include schema)
   */
  @JsonProperty( "host" )
  public void setHost( String host ) {
    this.host = host;
  }

  /**
   * The proxy port
   */
  @JsonProperty( "port" )
  public Optional< BigInteger > getPort( ) {
    return Optional.ofNullable( port );
  }

  /**
   * The proxy port
   */
  @JsonProperty( "port" )
  public void setPort( BigInteger port ) {
    this.port = port;
  }

  /**
   * The username to connect to this proxy
   */
  @JsonProperty( "username" )
  public Optional< String > getUsername( ) {
    return Optional.ofNullable( username );
  }

  /**
   * The username to connect to this proxy
   */
  @JsonProperty( "username" )
  public void setUsername( String username ) {
    this.username = username;
  }

  /**
   * The password of the user
   */
  @JsonProperty( "password" )
  public Optional< String > getPassword( ) {
    return Optional.ofNullable( password );
  }

  /**
   * The password of the user
   */
  @JsonProperty( "password" )
  public void setPassword( String password ) {
    this.password = password;
  }

  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty( "except" )
  public Optional< List< String > > getExcept( ) {
    return Optional.ofNullable( except );
  }

  /**
   * List of domain exceptions that do not pass into this proxy
   */
  @JsonProperty( "except" )
  public void setExcept( List< String > except ) {
    this.except = except;
  }


  /**
   * The protocol to use this proxy for
   */
  public enum Type {

    HTTP( "http" ),
    HTTPS( "https" ),
    FTP( "ftp" ),
    FTPS( "ftps" );
    private final static Map< String, BaseProxy.Type > CONSTANTS = new HashMap< String, BaseProxy.Type >( );

    static {
      for( BaseProxy.Type c : values( ) ) {
        CONSTANTS.put( c.value, c );
      }
    }

    private final String value;

    Type( String value ) {
      this.value = value;
    }

    @JsonCreator
    public static BaseProxy.Type fromValue( String value ) {
      BaseProxy.Type constant = CONSTANTS.get( value );
      if( constant == null ) {
        throw new IllegalArgumentException( value );
      } else {
        return constant;
      }
    }

    @Override
    public String toString( ) {
      return this.value;
    }

    @JsonValue
    public String value( ) {
      return this.value;
    }

  }

}
