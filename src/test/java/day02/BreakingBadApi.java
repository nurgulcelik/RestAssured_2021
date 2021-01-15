package day02;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class BreakingBadApi {
    @DisplayName("Get All Characters Simple Test")
    @Test
    public void testBreakingBad(){
        //https://www.breakingbadapi.com/api/characters
        given()

       .when()
                .get("https://www.breakingbadapi.com/api/characters")
                .prettyPeek().
                then()
                .statusCode( is(200) )   // checking status code
                .header("Content-Type", is("application/json; charset=utf-8") )
        ;
    }
}
