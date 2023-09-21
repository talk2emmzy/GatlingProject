package tmsendpointsapi;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class awaitingrequest extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://qa.fgntreasury.gov.ng")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Mobile Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("accept-encoding", "gzip, deflate, br"),
    Map.entry("accept-language", "en-US,en;q=0.9"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("sec-fetch-user", "?1"),
    Map.entry("upgrade-insecure-requests", "1")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("Origin", "https://qa.fgntreasury.gov.ng"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?1"),
    Map.entry("sec-ch-ua-platform", "Android")
  );
  
  private Map<CharSequence, String> headers_12 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br"),
    Map.entry("accept-language", "en-US,en;q=0.9"),
    Map.entry("access-control-request-headers", "authorization,device,ip,lat,long"),
    Map.entry("access-control-request-method", "GET"),
    Map.entry("origin", "https://qa.fgntreasury.gov.ng"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site")
  );
  
  private Map<CharSequence, String> headers_16 = Map.ofEntries(
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
  
  private String uri2 = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css";
  
  private String uri3 = "https://api-qa.fgntreasury.gov.ng";

  private ScenarioBuilder scn = scenario("awaitingrequest")
    .exec(
      http("request_0")
        .get("/fontawesome-free-5.12.1-web/css/all.min.css")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri2)
            .headers(headers_0),
          http("request_2")
            .get("/static/css/main.0b6f542a.css")
            .headers(headers_0),
          http("request_3")
            .get("/static/js/main.76d7d64d.js")
            .headers(headers_0),
          http("request_4")
            .get("/admin")
            .headers(headers_4),
          http("request_5")
            .get("/static/media/Poppins-SemiBold.ac8d04b620e54be9b0f0.ttf")
            .headers(headers_5),
          http("request_6")
            .get("/static/media/Poppins-Medium.673ed42382ab264e0bf5.ttf")
            .headers(headers_5),
          http("request_7")
            .get("/static/media/Poppins-Bold.cdb29a5d7ccf57ff05a3.ttf")
            .headers(headers_5),
          http("request_8")
            .get("/static/media/Poppins-Regular.35d26b781dc5fda684cc.ttf")
            .headers(headers_5),
          http("request_9")
            .get("/static/media/coatOfArm.b61814ff3410d491ca4b.png")
            .headers(headers_0),
          http("request_10")
            .get("/static/media/avatar.988eb1c6471031178e81.png")
            .headers(headers_0),
          http("request_11")
            .get("/OAGFLogo.png")
            .headers(headers_0),
          http("request_12")
            .options(uri3 + "/services/organization/api/onboarding-step-two/organizations/64bd154645b00d68611793b9/banks")
            .headers(headers_12),
          http("request_13")
            .options(uri3 + "/api/organizations/64bd154645b00d68611793b9/total-payment")
            .headers(headers_12),
          http("request_14")
            .options(uri3 + "/services/accountingservice/api/inflow/outflow/64bd154645b00d68611793b9")
            .headers(headers_12),
          http("request_15")
            .options(uri3 + "/services/organization/api/organizations/requests/awaiting-requests")
            .headers(headers_12),
          http("request_16")
            .get(uri3 + "/services/accountingservice/api/inflow/outflow/64bd154645b00d68611793b9")
            .headers(headers_16),
          http("request_17")
            .get(uri3 + "/services/organization/api/organizations/requests/awaiting-requests")
            .headers(headers_16),
          http("request_18")
            .get(uri3 + "/services/organization/api/onboarding-step-two/organizations/64bd154645b00d68611793b9/banks")
            .headers(headers_16),
          http("request_19")
            .get(uri3 + "/api/organizations/64bd154645b00d68611793b9/total-payment")
            .headers(headers_16)
        )
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
