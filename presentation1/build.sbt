lazy val presentation = project in file(".")

name := "presentation"

Common.settings

libraryDependencies ++= Dependencies.presentation

initialCommands := """|import com.neska.common._
                      |import com.neska.presentation._
                      |import com.neska.presentation.backend_
                      |import akka.actor._
                      |import akka.actor.ActorDSL._
                      |import akka.pattern._
                      |import akka.routing._
                      |import akka.util._
                      |import com.typesafe.config._
                      |import scala.concurrent._
                      |import scala.concurrent.duration._""".stripMargin
