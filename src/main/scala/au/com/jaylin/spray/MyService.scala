package au.com.jaylin.spray

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
import spray.json._
import DefaultJsonProtocol._


// from https://github.com/spray/spray-template/tree/on_jetty_1.2
// the routes below can be access via the following as an example:
// https://spraytestp1081110trial.hanatrial.ondemand.com/spray-test_2.10-1.0/json
// or http://localhost:8888/spray-test_2.10-1.0/json.
//
// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService {

    // the HttpService trait defines only one abstract member, which
    // connects the services environment to the enclosing actor or test
    def actorRefFactory = context

    // this actor only runs our route, but you could add
    // other things here, like request stream processing
    // or timeout handling
    def receive = runRoute(myRoute)
}


// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

    val myRoute =
        path("") {
            get {
                respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
                    complete {
                        <html>
                            <body>
                                <h1>Say hello to <i>spray-routing</i>!</h1>
                            </body>
                        </html>
                    }
                }
            }
        } ~
        path("test") {
            get {
                respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
                    complete {
                        <html>
                            <body>
                                <h1>This is a test</h1>
                            </body>
                        </html>
                    }
                }
            }
        } ~
        path("json") {
            respondWithMediaType(`application/json`) {
                complete {
                    val v = Map("x" -> 24, "y" -> 25, "z" -> 26)
                    v.toJson.prettyPrint
                }
            }
        }
}