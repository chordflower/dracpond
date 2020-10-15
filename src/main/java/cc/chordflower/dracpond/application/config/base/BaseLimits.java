
package cc.chordflower.dracpond.application.config.base;

/*-
 * #%L
 * dracpond
 * %%
 * Copyright (C) 2020 carddamom
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Several server limit configurations
 */
@JsonInclude ( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder ( { "timeBetweenRequests", "maximumRequestSize", "fieldNameSize", "fieldSize", "fileSize" } )
public class BaseLimits implements Serializable {

  public static class BaseLimitsBuilder< T extends BaseLimits > {

    protected T instance;

    @SuppressWarnings ( "unchecked" )
    public BaseLimitsBuilder( ) {
      // Skip initialization when called from subclass
      if( this.getClass( ).equals( BaseLimits.BaseLimitsBuilder.class ) ) {
        this.instance = ( ( T )new BaseLimits( ) );
      }
    }

    public T build( ) {
      T result;
      result = this.instance;
      this.instance = null;
      return result;
    }

    public BaseLimits.BaseLimitsBuilder withFieldNameSize( BigInteger fieldNameSize ) {
      ( ( BaseLimits )this.instance ).fieldNameSize = fieldNameSize;
      return this;
    }

    public BaseLimits.BaseLimitsBuilder withFieldSize( BigInteger fieldSize ) {
      ( ( BaseLimits )this.instance ).fieldSize = fieldSize;
      return this;
    }

    public BaseLimits.BaseLimitsBuilder withFileSize( BigInteger fileSize ) {
      ( ( BaseLimits )this.instance ).fileSize = fileSize;
      return this;
    }

    public BaseLimits.BaseLimitsBuilder withMaximumRequestSize( BigInteger maximumRequestSize ) {
      ( ( BaseLimits )this.instance ).maximumRequestSize = maximumRequestSize;
      return this;
    }

    public BaseLimits.BaseLimitsBuilder withTimeBetweenRequests( BigInteger timeBetweenRequests ) {
      ( ( BaseLimits )this.instance ).timeBetweenRequests = timeBetweenRequests;
      return this;
    }

  }

  private final static long serialVersionUID = -8598784702205130653L;
  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty ( "timeBetweenRequests" )
  @JsonPropertyDescription ( "Minimum time between consecutive requests by the same browser (in miliseconds)" )
  private BigInteger timeBetweenRequests = new BigInteger( "10000" );
  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty ( "maximumRequestSize" )
  @JsonPropertyDescription ( "Maximum size of a request body (in bytes)" )
  private BigInteger maximumRequestSize = new BigInteger( "52428800" );
  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty ( "fieldNameSize" )
  @JsonPropertyDescription ( "Max multipart field name size (in bytes)" )
  private BigInteger fieldNameSize = new BigInteger( "100" );
  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty ( "fieldSize" )
  @JsonPropertyDescription ( "Max multipart field value size (in bytes)" )
  private BigInteger fieldSize = new BigInteger( "1048576" );

  /**
   * The max file size (in bytes)
   */
  @JsonProperty ( "fileSize" )
  @JsonPropertyDescription ( "The max file size (in bytes)" )
  private BigInteger fileSize = new BigInteger( "20971520" );

  @Override
  public boolean equals( Object other ) {
    if( other == this ) {
      return true;
    }
    if( ( other instanceof BaseLimits ) == false ) {
      return false;
    }
    var rhs = ( ( BaseLimits )other );
    return ( ( ( ( ( ( this.timeBetweenRequests == rhs.timeBetweenRequests ) || ( ( this.timeBetweenRequests != null ) && this.timeBetweenRequests.equals( rhs.timeBetweenRequests ) ) ) && ( ( this.maximumRequestSize == rhs.maximumRequestSize ) || ( ( this.maximumRequestSize != null ) && this.maximumRequestSize.equals( rhs.maximumRequestSize ) ) ) ) && ( ( this.fieldSize == rhs.fieldSize ) || ( ( this.fieldSize != null ) && this.fieldSize.equals( rhs.fieldSize ) ) ) ) && ( ( this.fileSize == rhs.fileSize ) || ( ( this.fileSize != null ) && this.fileSize.equals( rhs.fileSize ) ) ) ) && ( ( this.fieldNameSize == rhs.fieldNameSize ) || ( ( this.fieldNameSize != null ) && this.fieldNameSize.equals( rhs.fieldNameSize ) ) ) );
  }

  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty ( "fieldNameSize" )
  public Optional< BigInteger > getFieldNameSize( ) {
    return Optional.ofNullable( this.fieldNameSize );
  }

  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty ( "fieldSize" )
  public Optional< BigInteger > getFieldSize( ) {
    return Optional.ofNullable( this.fieldSize );
  }

  /**
   * The max file size (in bytes)
   */
  @JsonProperty ( "fileSize" )
  public Optional< BigInteger > getFileSize( ) {
    return Optional.ofNullable( this.fileSize );
  }

  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty ( "maximumRequestSize" )
  public Optional< BigInteger > getMaximumRequestSize( ) {
    return Optional.ofNullable( this.maximumRequestSize );
  }

  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty ( "timeBetweenRequests" )
  public Optional< BigInteger > getTimeBetweenRequests( ) {
    return Optional.ofNullable( this.timeBetweenRequests );
  }

  @Override
  public int hashCode( ) {
    var result = 1;
    result = ( ( result * 31 ) + ( ( this.timeBetweenRequests == null ) ? 0 : this.timeBetweenRequests.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.maximumRequestSize == null ) ? 0 : this.maximumRequestSize.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.fieldSize == null ) ? 0 : this.fieldSize.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.fileSize == null ) ? 0 : this.fileSize.hashCode( ) ) );
    result = ( ( result * 31 ) + ( ( this.fieldNameSize == null ) ? 0 : this.fieldNameSize.hashCode( ) ) );
    return result;
  }

  /**
   * Max multipart field name size (in bytes)
   */
  @JsonProperty ( "fieldNameSize" )
  public void setFieldNameSize( BigInteger fieldNameSize ) {
    this.fieldNameSize = fieldNameSize;
  }

  /**
   * Max multipart field value size (in bytes)
   */
  @JsonProperty ( "fieldSize" )
  public void setFieldSize( BigInteger fieldSize ) {
    this.fieldSize = fieldSize;
  }

  /**
   * The max file size (in bytes)
   */
  @JsonProperty ( "fileSize" )
  public void setFileSize( BigInteger fileSize ) {
    this.fileSize = fileSize;
  }

  /**
   * Maximum size of a request body (in bytes)
   */
  @JsonProperty ( "maximumRequestSize" )
  public void setMaximumRequestSize( BigInteger maximumRequestSize ) {
    this.maximumRequestSize = maximumRequestSize;
  }

  /**
   * Minimum time between consecutive requests by the same browser (in miliseconds)
   */
  @JsonProperty ( "timeBetweenRequests" )
  public void setTimeBetweenRequests( BigInteger timeBetweenRequests ) {
    this.timeBetweenRequests = timeBetweenRequests;
  }

  @Override
  public String toString( ) {
    var sb = new StringBuilder( );
    sb.append( BaseLimits.class.getName( ) ).append( '@' ).append( Integer.toHexString( System.identityHashCode( this ) ) ).append( '[' );
    sb.append( "timeBetweenRequests" );
    sb.append( '=' );
    sb.append( ( ( this.timeBetweenRequests == null ) ? "<null>" : this.timeBetweenRequests ) );
    sb.append( ',' );
    sb.append( "maximumRequestSize" );
    sb.append( '=' );
    sb.append( ( ( this.maximumRequestSize == null ) ? "<null>" : this.maximumRequestSize ) );
    sb.append( ',' );
    sb.append( "fieldNameSize" );
    sb.append( '=' );
    sb.append( ( ( this.fieldNameSize == null ) ? "<null>" : this.fieldNameSize ) );
    sb.append( ',' );
    sb.append( "fieldSize" );
    sb.append( '=' );
    sb.append( ( ( this.fieldSize == null ) ? "<null>" : this.fieldSize ) );
    sb.append( ',' );
    sb.append( "fileSize" );
    sb.append( '=' );
    sb.append( ( ( this.fileSize == null ) ? "<null>" : this.fileSize ) );
    sb.append( ',' );
    if( sb.charAt( ( sb.length( ) - 1 ) ) == ',' ) {
      sb.setCharAt( ( sb.length( ) - 1 ), ']' );
    } else {
      sb.append( ']' );
    }
    return sb.toString( );
  }

}
