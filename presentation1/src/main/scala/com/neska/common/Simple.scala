package com.neska.common

import akka.actor.ActorLogging
import akka.actor.Actor

class Simple extends Actor with ActorLogging {
  def receive = {
    case m => println(s"received $m!")
  }
}