package day02;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class SpartanTest {

 @BeforeAll
 public static void setUp(){

     RestAssured.baseURI="http://107.20.53.61:8000";
     RestAssured.basePath="/api";
 }
 @Test
    @DisplayName("Get 1 spartan")
    public void getOneSpartan(){
       given()
               .log().all()
               .when()
               .get("/spartans/25")
               .prettyPeek()
               .then()
               .statusCode(200)
               .contentType(ContentType.JSON);


 }
 @Test
    @DisplayName("Get all spartan")
    public void getAllSpartan(){



     given()
             .log().all()
             .accept(ContentType.JSON)
             .when()
             .get("/spartans")
             .prettyPeek()
             .then()
             .statusCode(200);
 }
 @Test
    @DisplayName("Spartan search test with parameter")
    public void spartanQueryParams(){
     given()
             .accept(ContentType.JSON)
             .log().all()
             .queryParam("gender","male")
             .queryParam("nameContains","al")
             .when()
             .get("/spartans/search")
             .prettyPeek()
             .then()
             .statusCode(200)
             .body(not(contains("Female")));

 }
 @Test
    @DisplayName("Testing spartans /{id} endpoint")
    public void getSingleSpartan(){
     given()
             .accept(ContentType.JSON)
             .log().all()
             .pathParam("id","27")
             .when()
             .get("/spartans/{id}")
             .prettyPeek()
             .then()
             .statusCode(200)
             .body("gender",is("Female"))
             .body("phone",is(6662999903l));
 }



}
