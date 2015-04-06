package com.esther.presentation.backend

import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import com.esther.common.{ Simple }
import akka.actor.Props

object BackEndApp2 extends App {

  val config = ConfigFactory.load("backend2.conf")
  val backend = ActorSystem("backend2", config)
  backend.actorOf(Props[Simple], "simple2")

}