package day02;

import io.restassured.RestAssured;
;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


public class ZipCodeTest {
    Response response;
    @BeforeAll
    @DisplayName("zippopotam api test")
    public static void init(){
        RestAssured.baseURI="http://api.zippopotam.us";
        RestAssured.basePath="/us";
    }
     @Test
    @DisplayName("Zip to city")
    public void testZipToCity(){
     given()
                .pathParam("zip",18064)
                .log().all()
                .when()
                .get("/{zip}")
               .prettyPeek()
             .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
             .body("'post code'",is("18064"))
             .body("places[0].'place name'",is("Nazareth"));


     }
     @DisplayName("City to Zip")
     @Test
    public void testCityToZip(){
          given().pathParam("state","VA")
                  .pathParam("city","Fairfax")
                  .log().all()
                  .when()
                  .get("/{state}/{city}")
                  .then()
                  .log().all()
                  .statusCode(200)
                  .body("'country abbreviation'",is("US"))
                  .body("places[-1].latitude",is("38.7602"))
                  .body("places[0].'post code'",is("22030"));
      }

}
