package tmsendpointsapi;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class outflowreport2 extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://qa.fgntreasury.gov.ng")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Mobile Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("accept", "application/json, text/plain, */*"),
    Map.entry("accept-encoding", "gzip, deflate, br"),
    Map.entry("accept-language", "en-US,en;q=0.9"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuZmZpbml0IiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY5NTIwNzExMn0.7bGaI6P-ffQh3koSIuEHziloHM0abQc648SK6zehx4YXMl7eEJeM8Kd6KxZ0ZIgn9QCNwDBASX94zJJvbhPXoA"),
    Map.entry("device", "DELL"),
    Map.entry("ip", "105.113.69.38"),
    Map.entry("lat", "40.741895"),
    Map.entry("long", "-73.989308"),
    Map.entry("origin", "https://qa.fgntreasury.gov.ng"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site")
  );
  
  private String uri2 = "https://api-qa.fgntreasury.gov.ng";

  private ScenarioBuilder scn = scenario("outflowreport2")
    .exec(
      http("request_0")
        .get("/OAGFLogo.png")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri2 + "/services/organization/api/organizations/1-4-1/descendants")
            .headers(headers_1),
          http("request_2")
            .get(uri2 + "/services/collection/api/payment-total-amount")
            .headers(headers_1),
          http("request_3")
            .get(uri2 + "/services/organization/api/onboarding-step-two/organizations/64bd154645b00d68611793b9/banks")
            .headers(headers_1),
          http("request_4")
            .get(uri2 + "/api/organizations/outflow-payment-summary?size=1000")
            .headers(headers_1),
          http("request_5")
            .get(uri2 + "/services/organization/api/organizations/1-4-1/descendants")
            .headers(headers_1)
        )
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
