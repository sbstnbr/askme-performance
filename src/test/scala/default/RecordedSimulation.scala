package default

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://nodeapp.54.77.223.221.xip.io")
		.inferHtmlResources()
		.acceptHeader("application/json, text/javascript, */*; q=0.01")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en;q=0.5")
		.connection("keep-alive")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0")

	val headers_0 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

	val headers_3 = Map("Accept" -> "application/font-woff;q=0.9,*/*;q=0.8")

	val headers_4 = Map("Accept" -> "*/*")

	val headers_5 = Map("X-Requested-With" -> "XMLHttpRequest")

	val headers_8 = Map("Accept" -> "image/png,image/*;q=0.8,*/*;q=0.5")

	val headers_9 = Map(
		"Accept" -> "application/font-woff;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "identity")

    val uri1 = "http://nodeapp.54.77.223.221.xip.io"
    val uri2 = "self-repair.mozilla.org"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("http://" + uri2 + "/en-GB/repair")
			.headers(headers_0),
            http("request_2")
			.get(uri1 + "/favicon.ico?_=1")
			.headers(headers_0),
            http("request_3")
			.get(uri1 + "/fonts/RotisSansSerifExtraBold75.ttf")
			.headers(headers_3),
            http("request_4")
			.get(uri1 + "/scripts/main.js")
			.headers(headers_4)))
		.pause(4)
		.exec(http("request_5")
			.get("/api/ratings")
			.headers(headers_5)
			.resources(http("request_6")
			.get(uri1 + "/api/questions")
			.headers(headers_5),
            http("request_7")
			.get(uri1 + "/api/questions")
			.headers(headers_5),
            http("request_8")
			.get(uri1 + "/img/stars.png")
			.headers(headers_8),
            http("request_9")
			.get(uri1 + "/fonts/fontawesome-webfont.woff?v=4.3.0")
			.headers(headers_9)))

	setUp(scn.inject(atOnceUsers(200))).protocols(httpProtocol)
}