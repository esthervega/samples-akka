
package com.esther.presentation

import akka.actor.{ Actor, ExtendedActorSystem, Extension, ExtensionKey }
import akka.util.Timeout
import scala.concurrent.duration.{ Duration, FiniteDuration, MILLISECONDS => Millis }

object Settings extends ExtensionKey[Settings]

class Settings(system: ExtendedActorSystem) extends Extension {

  val statusTimeout: Timeout =
    Duration(system.settings.config.getDuration("presentation.status-timeout", Millis), Millis)
}

trait SettingsActor {
  this: Actor =>

  val settings: Settings =
    Settings(context.system)
}
