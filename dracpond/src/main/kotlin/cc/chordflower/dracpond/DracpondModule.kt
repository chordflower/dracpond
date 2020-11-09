package cc.chordflower.dracpond

import com.google.common.eventbus.EventBus
import org.jetbrains.annotations.NotNull
import javax.enterprise.inject.Produces
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Named
class DracpondModule @Inject constructor() {

  @Singleton
  @Produces
  @NotNull
  fun createEventBus(): EventBus {
    return EventBus()
  }
}
