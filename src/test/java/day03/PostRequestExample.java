package day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class PostRequestExample {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI="http://107.20.53.61";
        RestAssured.port=8000;
        RestAssured.basePath="/api";
    }
    @Test
    @DisplayName("Testing POST/api/spartans endpoint")
    public void testAddingSpartan(){
   String myBody="{\n" +
           "    \"name\": \"Zeynep Nuran\",\n" +
           "    \"gender\": \"Female\",\n" +
           "    \"phone\": 1536037088\n" +
           "}";
        System.out.println(myBody);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(myBody)
                .log().all()
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("success",is("A Spartan is Born!"))
                .body("data.name",is("Zeynep Nuran"));
    }
    @Test
    @DisplayName("Extracting data from post request")
    public void postRequestExtractData(){
        String myBody="{\n" +
                "    \"name\": \"Enes Ihsan\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"phone\": 1536037088\n" +
                "}";
        Response response= given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(myBody)
                .when()
                .post("/spartans")
                .prettyPeek();
        JsonPath jp= response.jsonPath();
        String name= jp.getString("data.name");
        String gender = jp.getString("data.gender");
        System.out.println("Name is "+name+" , "+"Gender is "+gender);

    }
}
