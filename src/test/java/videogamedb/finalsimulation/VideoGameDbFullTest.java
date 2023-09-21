package videogamedb.finalsimulation;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class VideoGameDbFullTest extends Simulation {

    // HTTP PROTOCOL
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://api-web.fgntreasury.gov.ng")
            .acceptHeader("application/json, text/plain, */*")
            .contentTypeHeader("application/json");

    // RUNTIME PARAMETERS
    private static final int USER_COUNT = Integer.parseInt(System.getProperty("USERS", "5"));
    private static final int RAMP_DURATION = Integer.parseInt(System.getProperty("RAMP_DURATION", "10"));
    private static final int TEST_DURATION = Integer.parseInt(System.getProperty("TEST_DURATION", "60"));

    // FEEDER FOR TEST - CSV, JSON etc.
    private static FeederBuilder.FileBased<Object> jsonFeeder = jsonFile("data/gameJsonFile.json").random();

    // BEFORE BLOCK
    @Override
    public void before() {
        System.out.printf("Running test with %d users%n", USER_COUNT);
        System.out.printf("Ramping users over %d seconds%n", RAMP_DURATION);
        System.out.printf("Total test duration: %d seconds%n", TEST_DURATION);
    }

    // HTTP CALLS
    private static ChainBuilder authenticate =
            exec(http("Authenticate")
                    .post("/api/authenticate")
                    .body(StringBody("{\n" +
                            "  \"username\": \"NFFINIT\",\n" +
                            "  \"password\": \"Simple@123\"\n" +
                            "}"))
                    .check(jmesPath("token").saveAs("jwtToken")));

//    private static ChainBuilder getAllVideoGames =
//            exec(http("User login with valid data")
//                    .get(""));
//
//    private static ChainBuilder createNewGame =
//            feed(jsonFeeder)
//                    .exec(http("Create New Game - #{name}")
//                                    .post("/videogame")
//                                    .header("Authorization", "Bearer #{jwtToken}")
//                                    .body(ElFileBody("bodies/newGameTemplate.json")).asJson());
//
//    private static ChainBuilder getLastPostedGame =
//            exec(http("Get Last Posted Game - #{name}")
//                    .get("/videogame/#{id}")
//                    .check(jmesPath("name").isEL("#{name}")));
//
//    private static ChainBuilder deleteLastPostedGame =
//            exec(http("Delete game - #{name}")
//                    .delete("/videogame/#{id}")
//                    .header("Authorization", "Bearer #{jwtToken}")
//                    .check(bodyString().is("Video game deleted")));

    // SCENARIO OR USER JOURNEY
    private ScenarioBuilder scn = scenario("TMS API LoadTest - final simulation")
            .forever().on(
                    exec(authenticate)
                            .pause(2)
//                            .exec(authenticate)
////                            .pause(2)
////                            .exec(createNewGame)
////                            .pause(2)
////                            .exec(getLastPostedGame)
////                            .pause(2)
////                            .exec(deleteLastPostedGame)
            );

    // LOAD SIMULATION
    {
        setUp(
                scn.injectOpen(
                        nothingFor(5),
                        rampUsers(USER_COUNT).during(RAMP_DURATION)
                ).protocols(httpProtocol)
        ).maxDuration(TEST_DURATION);
    }

    // AFTER BLOCK
    @Override
    public void after() {
        System.out.println("Stress test completed");
    }


}
