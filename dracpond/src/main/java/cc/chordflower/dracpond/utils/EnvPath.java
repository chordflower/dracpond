package cc.chordflower.dracpond.utils;

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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public interface EnvPath {

  enum EnvPaths implements EnvPath {
    WINDOWS( Paths.get( Optional.ofNullable( System.getenv( "LOCALAPPDATA" ) ).orElse( Paths.get( System.getenv( "USERPROFILE" ), "AppData", "Local" ).toAbsolutePath( ).normalize( ).toString( ) ), "Dracpond", "Data" ), Paths.get( Optional.ofNullable( System.getenv( "APPDATA" ) ).orElse( Paths.get( System.getenv( "USERPROFILE" ), "AppData", "Roaming" ).toAbsolutePath( ).normalize( ).toString( ) ), "Dracpond", "Config" ), Paths.get( Optional.ofNullable( System.getenv( "LOCALAPPDATA" ) ).orElse( Paths.get( System.getenv( "USERPROFILE" ), "AppData", "Local" ).toAbsolutePath( ).normalize( ).toString( ) ), "Dracpond", "Cache" ), Paths.get( Optional.ofNullable( System.getenv( "LOCALAPPDATA" ) ).orElse( Paths.get( System.getenv( "USERPROFILE" ), "AppData", "Local" ).toAbsolutePath( ).normalize( ).toString( ) ), "Dracpond", "Log" ), Paths.get( System.getenv( "ProgramData" ), "Dracpond", "Data" ), Paths.get( System.getenv( "ProgramData" ), "Dracpond", "Config" ), Paths.get( System.getenv( "ProgramData" ), "Dracpond", "Cache" ), Paths.get( System.getenv( "ProgramData" ), "Dracpond", "Log" ) ), LINUX( Paths.get( Optional.ofNullable( System.getenv( "XDG_DATA_HOME" ) ).orElse( Paths.get( System.getProperty( "user.home" ), ".local", "share" ).toAbsolutePath( ).normalize( ).toString( ) ), "Dracpond" ), Paths.get( Optional.ofNullable( System.getenv( "XDG_CONFIG_HOME" ) ).orElse( Paths.get( System.getProperty( "user.home" ), ".config" ).toAbsolutePath( ).normalize( ).toString( ) ), "Dracpond" ), Paths.get( Optional.ofNullable( System.getenv( "XDG_CACHE_HOME" ) ).orElse( Paths.get( System.getProperty( "user.home" ), ".cache" ).toAbsolutePath( ).normalize( ).toString( ) ), "Dracpond" ), Paths.get( Optional.ofNullable( System.getenv( "XDG_STATE_HOME" ) ).orElse( Paths.get( System.getProperty( "user.home" ), ".local", "state" ).toAbsolutePath( ).normalize( ).toString( ) ), "Dracpond" ), Paths.get( "/", "usr", "share", "Dracpond" ), Paths.get( "/", "etc", "Dracond" ), Paths.get( "/", "var", "cache", "Dracpond" ), Paths.get( "/", "var", "log", "Dracpond" ) ), MACOS( Paths.get( Paths.get( System.getProperty( "user.home" ), "Library" ).toAbsolutePath( ).normalize( ).toString( ), "Application Support", "Dracpond" ), Paths.get( Paths.get( System.getProperty( "user.home" ), "Library" ).toAbsolutePath( ).normalize( ).toString( ), "Preferences", "Dracpond" ), Paths.get( Paths.get( System.getProperty( "user.home" ), "Library" ).toAbsolutePath( ).normalize( ).toString( ), "Caches", "Dracpond" ), Paths.get( Paths.get( System.getProperty( "user.home" ), "Library" ).toAbsolutePath( ).normalize( ).toString( ), "Logs", "Dracpond" ), Paths.get( "/", "Library", "Application Support", "Dracpond" ), Paths.get( "/", "Library", "Preferences", "Dracond" ), Paths.get( "/", "Library", "Caches", "Dracpond" ), Paths.get( "/", "Library", "Logs", "Dracpond" ) );

    private final Path userDataPath;

    private final Path userConfigPath;

    private final Path userCachePath;

    private final Path userLogPath;

    private final Path systemDataPath;

    private final Path systemConfigPath;

    private final Path systemCachePath;

    private final Path systemLogPath;

    EnvPaths( Path userDataPath, Path userConfigPath, Path userCachePath, Path userLogPath, Path systemDataPath, Path systemConfigPath, Path systemCachePath, Path systemLogPath ) {
      this.userCachePath = userCachePath;
      this.userConfigPath = userConfigPath;
      this.userDataPath = userDataPath;
      this.userLogPath = userLogPath;
      this.systemDataPath = systemDataPath;
      this.systemConfigPath = systemConfigPath;
      this.systemCachePath = systemCachePath;
      this.systemLogPath = systemLogPath;
    }

    @Override
    public final Path getSystemCachePath( ) {
      return this.systemCachePath;
    }

    @Override
    public final Path getSystemConfigPath( ) {
      return this.systemConfigPath;
    }

    @Override
    public final Path getSystemDataPath( ) {
      return this.systemDataPath;
    }

    @Override
    public final Path getSystemLogPath( ) {
      return this.systemLogPath;
    }

    @Override
    public final Path getUserCachePath( ) {
      return this.userCachePath;
    }

    @Override
    public final Path getUserConfigPath( ) {
      return this.userConfigPath;
    }

    @Override
    public final Path getUserDataPath( ) {
      return this.userDataPath;
    }

    @Override
    public final Path getUserLogPath( ) {
      return this.userLogPath;
    }

  }

  String OsName = System.getProperty( "os.name" );

  /**
   * This method returns an env path according to the current operating system.
   *
   * This means that for Linux:
   *
   * * User Data => It is given by ${env.XDG_DATA_HOME}/Dracpond or ${user.home}/.local/share/Dracpond;
   * * User Config => It is given by ${env.XDG_CONFIG_HOME}/Dracpond or ${user.home}/.config/Dracpond;
   * * User Cache => It is given by ${env.XDG_CACHE_HOME}/Dracpond or ${user.home}/.cache/Dracpond;
   * * User Log => It is given by ${env.XDG_STATE_HOME}/Dracpond or ${user.home}/.local/state/Dracpond;
   * * System Data => It is /usr/share/Dracpond;
   * * System Config => It is /etc/Dracpond;
   * * System Cache => It is /var/cache/Dracpond;
   * * System Log => It is /var/log/Dracpond;
   *
   * For macOS:
   *
   * * library = It is given by ${user.home}/Library;
   * * User Data => It is given by ${user.home}/Library/Application Support/Dracpond;
   * * User Config => It is given by ${user.home}/Library/Preferences/Dracpond;
   * * User Cache => It is given by ${user.home}/Library/Caches/Dracpond;
   * * User Log => It is given by ${user.home}/Library/Logs/Dracpond;
   * * System Data => It is given by /Library/Application Support/Dracpond;
   * * System Config => It is given by /Library/Preferences/Dracpond;
   * * System Cache => It is given by /Library/Caches/Dracpond;
   * * System Log => It is given by /Library/Logs/Dracpond;
   *
   * For Windows:
   *
   * * localAppData = It is given by the environment variable LOCALAPPDATA or ${user.home}/AppData/Roaming;
   * * appData = It is given by the environment variable APPDATA or ${user.home}/AppData/Local;
   * * User Data => It is given by ${localAppData}/Dracpond/Data;
   * * User Config => It is given by ${appData}/Dracpond/Config;
   * * User Cache => It is given by ${localAppData}/Dracpond/Cache;
   * * User Log => It is given by ${localAppData}/Dracpond/Log;
   * * System Data => It is given by ${env.ProgramData}/Dracpond/Data;
   * * System Config => It is given by ${env.ProgramData}/Dracpond/Config;
   * * System Cache => It is given by ${env.ProgramData}/Dracpond/Cache;
   * * System Log => It is given by ${env.ProgramData}/Dracpond/Log;
   *
   * @return An env path corresponding to the current operating system.
   */
  static EnvPath getCurrentEnvPath( ) {
    if( EnvPath.OsName.startsWith( "Mac OS X" ) ) {
      return EnvPaths.MACOS;
    } else if( EnvPath.OsName.startsWith( "Windows" ) ) {
      return EnvPaths.WINDOWS;
    } else {
      return EnvPaths.LINUX;
    }
  }

  /**
   * Returns a path used for placing general application cache data.
   *
   * @return A path used for placing general application cache data.
   */
  Path getSystemCachePath( );

  /**
   * Returns a path used for placing general application configuration data.
   *
   * @return A path used for placing general application configuration data.
   */
  Path getSystemConfigPath( );

  /**
   * Returns a path used for placing general application data.
   *
   * @return A path used for placing general application data
   */
  Path getSystemDataPath( );

  /**
   * Returns a path used for placing general application logs.
   *
   * @return A path used for placing general application logs.
   */
  Path getSystemLogPath( );

  /**
   * Returns a path used for placing user specific application cache data.
   *
   * @return A path used for placing user specific application cache data.
   */
  Path getUserCachePath( );

  /**
   * Returns a path used for placing user specific application configuration data.
   *
   * @return A path used for placing user specific application configuration data.
   */
  Path getUserConfigPath( );

  /**
   * Returns a path used for placing user specific application data.
   *
   * @return A path used for placing user specific application data
   */
  Path getUserDataPath( );

  /**
   * Returns a path used for placing user specific application logs.
   *
   * @return A path used for placing user specific application logs.
   */
  Path getUserLogPath( );

}
