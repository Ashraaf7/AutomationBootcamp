import io.restassured.RestAssured;

public class Utility {
    public static String injectRequest()
    {
      String response=   RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"test740740\",\n" +
                        "\"password\":\"YXNocmFmMTIz\"}")
                .when()
                .post("https://api.demoblaze.com/signup")
                .then()
                .extract()
                .body()
                .asString();
        System.out.println(response);
        return response;

    }

}
