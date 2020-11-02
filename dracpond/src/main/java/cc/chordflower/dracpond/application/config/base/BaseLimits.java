package cc.chordflower.dracpond.application.config.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Optional;


/**
 * Several server limit configurations
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
  "timeBetweenRequests",
  "maximumRequestSize",
  "fieldNameSize",
  "fieldSize",
  "fileSize"
} )
public class BaseLimits implements Serializable {

  private final static long serialVersionUID = -7629765136123080483L;
  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty( "timeBetweenRequests" )
  @JsonPropertyDescription( "Minimum time between consecutive requests by the same browser (in miliseconds)" )
  private BigInteger timeBetweenRequests = new BigInteger( "10000" );
  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty( "maximumRequestSize" )
  @JsonPropertyDescription( "Maximum size of a request body (in bytes)" )
  private BigInteger maximumRequestSize = new BigInteger( "52428800" );
  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty( "fieldNameSize" )
  @JsonPropertyDescription( "Max multipart field name size (in bytes)" )
  private BigInteger fieldNameSize = new BigInteger( "100" );
  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty( "fieldSize" )
  @JsonPropertyDescription( "Max multipart field value size (in bytes)" )
  private BigInteger fieldSize = new BigInteger( "1048576" );
  /**
   * The max file size (in bytes)
   */
  @JsonProperty( "fileSize" )
  @JsonPropertyDescription( "The max file size (in bytes)" )
  private BigInteger fileSize = new BigInteger( "20971520" );

  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty( "timeBetweenRequests" )
  public Optional< BigInteger > getTimeBetweenRequests( ) {
    return Optional.ofNullable( timeBetweenRequests );
  }

  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty( "timeBetweenRequests" )
  public void setTimeBetweenRequests( BigInteger timeBetweenRequests ) {
    this.timeBetweenRequests = timeBetweenRequests;
  }

  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty( "maximumRequestSize" )
  public Optional< BigInteger > getMaximumRequestSize( ) {
    return Optional.ofNullable( maximumRequestSize );
  }

  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty( "maximumRequestSize" )
  public void setMaximumRequestSize( BigInteger maximumRequestSize ) {
    this.maximumRequestSize = maximumRequestSize;
  }

  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty( "fieldNameSize" )
  public Optional< BigInteger > getFieldNameSize( ) {
    return Optional.ofNullable( fieldNameSize );
  }

  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty( "fieldNameSize" )
  public void setFieldNameSize( BigInteger fieldNameSize ) {
    this.fieldNameSize = fieldNameSize;
  }

  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty( "fieldSize" )
  public Optional< BigInteger > getFieldSize( ) {
    return Optional.ofNullable( fieldSize );
  }

  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty( "fieldSize" )
  public void setFieldSize( BigInteger fieldSize ) {
    this.fieldSize = fieldSize;
  }

  /**
   * The max file size (in bytes)
   */
  @JsonProperty( "fileSize" )
  public Optional< BigInteger > getFileSize( ) {
    return Optional.ofNullable( fileSize );
  }

  /**
   * The max file size (in bytes)
   */
  @JsonProperty( "fileSize" )
  public void setFileSize( BigInteger fileSize ) {
    this.fileSize = fileSize;
  }

}
