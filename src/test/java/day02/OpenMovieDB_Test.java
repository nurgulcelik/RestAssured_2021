package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class OpenMovieDB_Test {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI ="https://www.omdbapi.com";
    }
    @Test
    @DisplayName("Test Movie Api")
    public void testMovies(){
        given()
                .log().all()
                .queryParam("apikey","26aa5b74")
                .queryParam("t","Boss Baby")
                .queryParam("plot","full")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("Title",containsString("Boss Baby"))
                .body("Ratings[0].Value",is("6.3/10"))
                .body("Ratings[-1].Value",is("50/100"))
                .body("Country",comparesEqualTo("USA"))
                .body("Type",comparesEqualTo("movie"))
                .body("Ratings[1].Source",is("Rotten Tomatoes"));

    }
}
