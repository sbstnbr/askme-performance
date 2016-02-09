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

  val headers_0 = Map("Range" -> "bytes=12000000-12299999")

  val headers_8 = Map(
    "Accept" -> "*/*",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_9 = Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/x-www-form-urlencoded;charset=UTF-8")

  val headers_12 = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "X-Page-Id" -> "http://nodeapp.52.18.147.113.xip.io/",
    "X-Requested-With" -> "XMLHttpRequest",
    "x-uniq-id" -> "1bddf7d4-f98c-49b3-a203-d5eb9280668a")

  val uri5 = "http://nodeapp.52.18.147.113.xip.io"

  val scn = scenario("RecordedSimulation")
    .exec(http("request_0")
      .get(uri5 + "/environment.json")
      .headers(headers_8)
      .basicAuth("john.smith", "Password01"))
    .exec(http("request_9")
      .get(uri5 + "/locales/en-US/translation.json?_=1454945835650")
      .headers(headers_9)
      .basicAuth("john.smith", "Password01"))
    .exec(http("request_10")
      .get(uri5 + "/locales/en/translation.json?_=1454945835655")
      .headers(headers_9)
      .basicAuth("john.smith", "Password01"))
    .exec(http("request_11")
      .get(uri5 + "/favicon.ico")
      .basicAuth("john.smith", "Password01"))
    .exec(http("request_12")
      .get(uri5 + "/jsondata/navigation-collection.json")
      .headers(headers_12)
      .basicAuth("john.smith", "Password01"))

  setUp(scn.inject(atOnceUsers(100)).protocols(httpProtocol))
}