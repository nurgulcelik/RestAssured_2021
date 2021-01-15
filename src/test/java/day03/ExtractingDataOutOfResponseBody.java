package day03;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ExtractingDataOutOfResponseBody {

    @Test
    @DisplayName("Getting movie info")
    public void extractDataFromResponseBody(){
       Response response= given()
                .log().all()
                .baseUri("http://www.omdbapi.com")
                .queryParam("apikey","26aa5b74")
                .queryParam("t","Boss Baby")
                .when()
                .get()
               .prettyPeek();
       String title=response.path("Title");
        System.out.println("Title is : "+title);
        String ratingSource1=response.path("Ratings[0].Source");
        System.out.println("Rating First Source : "+ratingSource1);

    }
}
