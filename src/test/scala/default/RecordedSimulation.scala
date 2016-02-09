package default


import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://nodeapp.52.18.147.113.xip.io")
    .inferHtmlResources()
    .basicAuth("john.smith", "Password01")

  val uri5 = "http://nodeapp.52.18.147.113.xip.io"

  val scn = scenario("RecordedSimulation")
    .exec(http("request_0")
      .get(uri5 + "/environment.json")
      .basicAuth("john.smith", "Password01"))
    .exec(http("request_1")
      .get(uri5 + "/locales/en-US/translation.json?_=1454945835650")
      .basicAuth("john.smith", "Password01"))
    .exec(http("request_2")
      .get(uri5 + "/locales/en/translation.json?_=1454945835655")
      .basicAuth("john.smith", "Password01"))
    .exec(http("request_3")
      .get(uri5 + "/favicon.ico")
      .basicAuth("john.smith", "Password01"))
    .exec(http("request_4")
      .get(uri5 + "/jsondata/navigation-collection.json")
      .basicAuth("john.smith", "Password01"))

  setUp(scn.inject(atOnceUsers(100)).protocols(httpProtocol))
}