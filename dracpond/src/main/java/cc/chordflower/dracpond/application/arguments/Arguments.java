package cc.chordflower.dracpond.application.arguments;

import com.beust.jcommander.Parameter;
import org.jetbrains.annotations.Contract;

import java.util.Objects;

@SuppressWarnings( "unused" )
public class Arguments {

  @Parameter ( names = { "-v", "--verbose" }, description = "Enables verbose output" )
  private boolean verbose = false;

  @Parameter ( names = { "-c", "--config" }, description = "The location of the configuration file" )
  private String config = "";

  @Contract( pure = true ) public Arguments( ) {
    super( );
  }

  @Contract( pure = true ) public Arguments( boolean verbose, String config ) {
    super( );
    this.verbose = verbose;
    this.config = config;
  }

  @Contract( value = "null -> false", pure = true ) @Override
  public boolean equals( Object obj ) {
    if( this == obj ) {
      return true;
    }
    if( !( obj instanceof Arguments ) ) {
      return false;
    }
    Arguments other = ( Arguments ) obj;
    return Objects.equals( this.config, other.config ) && ( this.verbose == other.verbose );
  }

  @Contract( pure = true ) public final String getConfig( ) {
    return this.config;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash( this.config, this.verbose );
  }

  @Contract( pure = true )
  public final boolean isVerbose( ) {
    return this.verbose;
  }

  @Override
  public String toString( ) {
    return String.format( "{ \"verbose\"=%s, \"config\"=\"%s\"}", this.verbose, this.config );
  }

}
