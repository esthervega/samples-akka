package com.esther.presentation

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.event.Logging
import scala.io.StdIn
import akka.actor.ActorSystem
import akka.util.Timeout
import akka.actor.Props
import com.esther.common.{ Simple }
import com.typesafe.config.ConfigFactory

object FrontEndApp extends App {

  val system = ActorSystem("frontend")
  val frontendApp = new FrontEndApp(system)(Settings(system).statusTimeout)
  frontendApp.run()

}

class FrontEndApp(system: ActorSystem)(implicit statusTimeout: Timeout) {
  private val log = Logging(system, getClass.getName)

  val path1 = "akka.tcp://backend1@0.0.0.0:2551/user/simple1"
  val simple1 = system.actorSelection(path1)
  val path2 = "akka.tcp://backend2@0.0.0.0:2552/user/simple2"
  val simple2 = system.actorSelection(path2)

  def run(): Unit = {
    commandLoop()
    system.awaitTermination()
  }

  private def commandLoop(): Unit =
    StdIn.readLine() match {
      case "1" =>
        simple1 ! "Let's send a message to simple1"
        commandLoop()
      case "2" =>
        simple2 ! "Let's send a message to simple2"
        commandLoop()
      case _@ text =>
        {
          println("Let's broadcast!")
          simple1 ! text
          simple2 ! text
          commandLoop()
        }
    }
}