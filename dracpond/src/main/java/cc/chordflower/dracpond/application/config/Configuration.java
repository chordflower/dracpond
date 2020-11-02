package cc.chordflower.dracpond.application.config;

import cc.chordflower.dracpond.application.config.base.BaseConfigSchema;
import io.vertx.core.json.JsonObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public class Configuration extends BaseConfigSchema {

  private static final long serialVersionUID = 1L;

  @Contract( pure = true ) public static @Nullable Configuration fromNode( final JsonObject result ) {
    return null;
  }

}
