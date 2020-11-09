@file:Suppress("unused")

package cc.chordflower.dracpond.utils

import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

@Suppress("unused")
interface EnvPath {
  enum class EnvPaths(override val userDataPath: Path, override val userConfigPath: Path, override val userCachePath: Path, override val userLogPath: Path, override val systemDataPath: Path, override val systemConfigPath: Path, override val systemCachePath: Path, override val systemLogPath: Path) : EnvPath {
    WINDOWS(
      userDataPath = Paths.get(Optional.ofNullable<String>(System.getenv("LOCALAPPDATA")).orElse(Paths.get(System.getenv("USERPROFILE"), "AppData", "Local").toAbsolutePath().normalize().toString()), "Dracpond", "Data"),
      userConfigPath = Paths.get(Optional.ofNullable<String>(System.getenv("APPDATA")).orElse(Paths.get(System.getenv("USERPROFILE"), "AppData", "Roaming").toAbsolutePath().normalize().toString()), "Dracpond", "Config"),
      userCachePath = Paths.get(Optional.ofNullable<String>(System.getenv("LOCALAPPDATA")).orElse(Paths.get(System.getenv("USERPROFILE"), "AppData", "Local").toAbsolutePath().normalize().toString()), "Dracpond", "Cache"),
      userLogPath = Paths.get(Optional.ofNullable<String>(System.getenv("LOCALAPPDATA")).orElse(Paths.get(System.getenv("USERPROFILE"), "AppData", "Local").toAbsolutePath().normalize().toString()), "Dracpond", "Log"),
      systemDataPath = Paths.get(System.getenv("ProgramData"), "Dracpond", "Data"),
      systemConfigPath = Paths.get(System.getenv("ProgramData"), "Dracpond", "Config"),
      systemCachePath = Paths.get(System.getenv("ProgramData"), "Dracpond", "Cache"),
      systemLogPath = Paths.get(System.getenv("ProgramData"), "Dracpond", "Log")),
    LINUX(
      userDataPath = Paths.get(Optional.ofNullable<String>(System.getenv("XDG_DATA_HOME")).orElse(Paths.get(System.getProperty("user.home"), ".local", "share").toAbsolutePath().normalize().toString()), "Dracpond"),
      userConfigPath = Paths.get(Optional.ofNullable<String>(System.getenv("XDG_CONFIG_HOME")).orElse(Paths.get(System.getProperty("user.home"), ".config").toAbsolutePath().normalize().toString()), "Dracpond"),
      userCachePath = Paths.get(Optional.ofNullable<String>(System.getenv("XDG_CACHE_HOME")).orElse(Paths.get(System.getProperty("user.home"), ".cache").toAbsolutePath().normalize().toString()), "Dracpond"),
      userLogPath = Paths.get(Optional.ofNullable<String>(System.getenv("XDG_STATE_HOME")).orElse(Paths.get(System.getProperty("user.home"), ".local", "state").toAbsolutePath().normalize().toString()), "Dracpond"),
      systemDataPath = Paths.get("/", "usr", "share", "Dracpond"),
      systemConfigPath = Paths.get("/", "etc", "Dracond"),
      systemCachePath = Paths.get("/", "var", "cache", "Dracpond"),
      systemLogPath = Paths.get("/", "var", "log", "Dracpond")),
    MACOS(
      userDataPath = Paths.get(Paths.get(System.getProperty("user.home"), "Library").toAbsolutePath().normalize().toString(), "Application Support", "Dracpond"),
      userConfigPath = Paths.get(Paths.get(System.getProperty("user.home"), "Library").toAbsolutePath().normalize().toString(), "Preferences", "Dracpond"),
      userCachePath = Paths.get(Paths.get(System.getProperty("user.home"), "Library").toAbsolutePath().normalize().toString(), "Caches", "Dracpond"),
      userLogPath = Paths.get(Paths.get(System.getProperty("user.home"), "Library").toAbsolutePath().normalize().toString(), "Logs", "Dracpond"),
      systemDataPath = Paths.get("/", "Library", "Application Support", "Dracpond"),
      systemConfigPath = Paths.get("/", "Library", "Preferences", "Dracond"),
      systemCachePath = Paths.get("/", "Library", "Caches", "Dracpond"),
      systemLogPath = Paths.get("/", "Library", "Logs", "Dracpond"),
    );
  }

  /**
   * Returns a path used for placing general application cache data.
   *
   * @return A path used for placing general application cache data.
   */
  val systemCachePath: Path

  /**
   * Returns a path used for placing general application configuration data.
   *
   * @return A path used for placing general application configuration data.
   */
  val systemConfigPath: Path

  /**
   * Returns a path used for placing general application data.
   *
   * @return A path used for placing general application data
   */
  val systemDataPath: Path

  /**
   * Returns a path used for placing general application logs.
   *
   * @return A path used for placing general application logs.
   */
  val systemLogPath: Path

  /**
   * Returns a path used for placing user specific application cache data.
   *
   * @return A path used for placing user specific application cache data.
   */
  val userCachePath: Path

  /**
   * Returns a path used for placing user specific application configuration data.
   *
   * @return A path used for placing user specific application configuration data.
   */
  val userConfigPath: Path

  /**
   * Returns a path used for placing user specific application data.
   *
   * @return A path used for placing user specific application data
   */
  val userDataPath: Path

  /**
   * Returns a path used for placing user specific application logs.
   *
   * @return A path used for placing user specific application logs.
   */
  val userLogPath: Path

  companion object {
    internal val OsName = System.getProperty("os.name")
  }
}

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
val currentEnvPath: EnvPath
  get() = when {
    EnvPath.OsName.startsWith("Mac OS X") -> {
      EnvPath.EnvPaths.MACOS
    }
    EnvPath.OsName.startsWith("Windows") -> {
      EnvPath.EnvPaths.WINDOWS
    }
    else -> {
      EnvPath.EnvPaths.LINUX
    }
  }
