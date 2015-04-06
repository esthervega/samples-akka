package com.esther.presentation.backend

import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import com.esther.common.{ Simple }
import akka.actor.Props

object BackEndApp1 extends App {

  val config = ConfigFactory.load("backend1.conf")
  val backend = ActorSystem("backend1", config)
  backend.actorOf(Props[Simple], "simple1")

}