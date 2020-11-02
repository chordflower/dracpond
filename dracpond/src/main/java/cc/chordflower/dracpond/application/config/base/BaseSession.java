package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Optional;


/**
 * Configuration related to the session
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "key",
  "maxAge"
} )
public class BaseSession implements Serializable {

  private final static long serialVersionUID = 3057487360968381059L;
  /**
   * The name of the session id in storage
   */
  @JsonProperty( "key" )
  @JsonPropertyDescription( "The name of the session id in storage" )
  private String key = "KSESSION";
  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty( "maxAge" )
  @JsonPropertyDescription( "The number of seconds that the session is active." )
  private BigInteger maxAge = new BigInteger( "1800" );

  /**
   * The name of the session id in storage
   */
  @JsonProperty( "key" )
  public Optional< String > getKey( ) {
    return Optional.ofNullable( key );
  }

  /**
   * The name of the session id in storage
   */
  @JsonProperty( "key" )
  public void setKey( String key ) {
    this.key = key;
  }

  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty( "maxAge" )
  public Optional< BigInteger > getMaxAge( ) {
    return Optional.ofNullable( maxAge );
  }

  /**
   * The number of seconds that the session is active.
   */
  @JsonProperty( "maxAge" )
  public void setMaxAge( BigInteger maxAge ) {
    this.maxAge = maxAge;
  }

}
