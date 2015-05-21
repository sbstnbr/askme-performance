package com.aowp.nodeapptest

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://nodeapp.54.76.215.147.xip.io/")
		//.inferHtmlResources(BlackList(""".*\.css""", """.*\.ico"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en;q=0.5")
		.connection("keep-alive")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0")

	val headers_3 = Map("Accept" -> "*/*")

	val headers_4 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "http://nodeapp.54.76.215.147.xip.io/"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.resources(http("request_1")
			.get(uri1 + "/favicon.ico?_=1"),
            http("request_2")
			.get(uri1 + "/favicon.ico?_=1"),
            http("request_3")
			.get(uri1 + "/scripts/main.js")
			.headers(headers_3)))
		.pause(3)
		.exec(http("request_4")
			.get("/api/questions")
			.headers(headers_4)
			.resources(http("request_5")
			.get(uri1 + "/api/questions")
			.headers(headers_4)))

	setUp(scn.inject(atOnceUsers(200))).protocols(httpProtocol)
}