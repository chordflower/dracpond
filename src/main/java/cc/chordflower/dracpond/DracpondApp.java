package cc.chordflower.dracpond;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

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

import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.slf4j.bridge.SLF4JBridgeHandler;

import com.beust.jcommander.JCommander;
import com.google.common.base.Strings;
import com.google.common.eventbus.EventBus;

import cc.chordflower.dracpond.application.arguments.Arguments;
import cc.chordflower.dracpond.application.config.Configuration;
import cc.chordflower.dracpond.application.events.Event;
import cc.chordflower.dracpond.utils.EnvPath;
import io.vavr.collection.Array;
import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class DracpondApp implements Runnable {

  public static ConfigStoreOptions getEnvironmentConfigStore( ) {
    return new ConfigStoreOptions( ).setType( "env" ).setConfig( new JsonObject( ).put( "raw-data", true ) );
  }

  @Produces
  @ApplicationScoped
  public static EventBus getEventBus( ) {
    return new EventBus( );
  }

  public static ConfigStoreOptions getJsonFileConfigStore( ) {
    return new ConfigStoreOptions( ).setType( "file" ).setFormat( "json" );
  }

  public static ConfigStoreOptions getPropertiesFileConfigStore( ) {
    return new ConfigStoreOptions( ).setType( "file" ).setFormat( "properties" );
  }

  public static ConfigStoreOptions getYamlFileConfigStore( ) {
    return new ConfigStoreOptions( ).setType( "file" ).setFormat( "yaml" );
  }

  public static void main( String... args ) {
    var app = new DracpondApp( args );
    app.run( );
  }

  private final String[ ] args;

  public DracpondApp( String... args ) {
    this.args = args;
  }

  private String getFormatForFile( Path fileName ) {
    return null;
  }

  @Override
  public void run( ) {
    SLF4JBridgeHandler.removeHandlersForRootLogger( );
    SLF4JBridgeHandler.install( );
    var cdiContainer = CdiContainerLoader.getCdiContainer( );
    cdiContainer.boot( );
    var contextControl = cdiContainer.getContextControl( );
    contextControl.startContext( ApplicationScoped.class );

    // Write the process pid to a file
    var currPid = ProcessHandle.current( ).pid( );
    try {
      Files.writeString( Path.of( "./process.pid" ), Long.toString( currPid ), StandardCharsets.UTF_8 );
    } catch( IOException e ) {
      // Temporary
    }

    // Emit before start event
    var eventBus = BeanProvider.getContextualReference( EventBus.class );
    eventBus.post( new Event.BeforeStartEvent( ) );

    // Emit before parse arguments event (together with the arguments)
    eventBus.post( new Event.BeforeParseArgumentsEvent( Array.of( this.args ) ) );

    // Parse arguments
    var arguments = new Arguments( );
    //@formatter:off
    JCommander.newBuilder( )
      .addObject( arguments )
      .acceptUnknownOptions( false )
      .allowAbbreviatedOptions( true )
      .programName( "Dracpond" )
      .build( )
      .parse( this.args );
    //@formatter:on

    // Emit parse arguments event (together with the parsed arguments)
    eventBus.post( new Event.AfterParseArgumentsEvent( arguments ) );

    // Parse configuration
    var vertx = Vertx.vertx( );

    var options = new ConfigRetrieverOptions( ).setIncludeDefaultStores( false );

    if( !Strings.isNullOrEmpty( arguments.getConfig( ) ) && Files.exists( Paths.get( arguments.getConfig( ) ) ) ) {
      options.addStore( new ConfigStoreOptions( ).setType( "file" ).setFormat( this.getFormatForFile( Paths.get( arguments.getConfig( ) ).getFileName( ) ) ).setOptional( false ).setConfig( new JsonObject( ).put( "path", arguments.getConfig( ) ) ) );
    } else {
      options.addStore( DracpondApp.getJsonFileConfigStore( ).setConfig( new JsonObject( ).put( "path", "./config.json" ) ) ).addStore( DracpondApp.getYamlFileConfigStore( ).setConfig( new JsonObject( ).put( "path", "./config.yaml" ) ) ).addStore( DracpondApp.getJsonFileConfigStore( ).setConfig( new JsonObject( ).put( "path", Paths.get( EnvPath.getCurrentEnvPath( ).getSystemConfigPath( ).toString( ), "config.json" ) ) ) ).addStore( DracpondApp.getJsonFileConfigStore( ).setConfig( new JsonObject( ).put( "path", Paths.get( EnvPath.getCurrentEnvPath( ).getSystemConfigPath( ).toString( ), "config.yaml" ) ) ) ).addStore( DracpondApp.getJsonFileConfigStore( ).setConfig( new JsonObject( ).put( "path", Paths.get( EnvPath.getCurrentEnvPath( ).getUserConfigPath( ).toString( ), "config.json" ) ) ) ).addStore( DracpondApp.getJsonFileConfigStore( ).setConfig( new JsonObject( ).put( "path", Paths.get( EnvPath.getCurrentEnvPath( ).getUserConfigPath( ).toString( ), "config.yaml" ) ) ) );
    }

    options.addStore( DracpondApp.getEnvironmentConfigStore( ) );
    options.setScanPeriod( Long.MAX_VALUE );

    var retriever = ConfigRetriever.create( vertx, options );
    retriever.getConfig( json -> {
      System.out.println( json.result( ).toString( ) );

      var config = Configuration.fromNode( json.result( ) );

      // Emit the after parse configuration event (together with the parsed configuration)
      eventBus.post( new Event.AfterParseConfigurationEvent( config ) );

      // Initialize logging

      // Emit the after logging configuration event

      // Get the vertxes to run

      // Emit the before start vertxes event (with the vertx list)

      // Start the vertxes

      // Emit the after start vertxes event

      // After receiving the term signal

      // Emit the before stop vertexs event

      // Stop the vertxes

      // Emit the shutdown event

      cdiContainer.shutdown( );
    } );
  }
}
