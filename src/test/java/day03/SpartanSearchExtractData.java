package day03;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SpartanSearchExtractData {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI="http://107.20.53.61";
        RestAssured.port=8000;
        RestAssured.basePath="/api";
    }
    @Test
    @DisplayName("Extracting data")
    public void test1(){
        Response response=given()
               .log().all()
                .queryParam("gender","Female")
                .when()
                .get("spartans/search")
                .prettyPeek();
        JsonPath jp = response.jsonPath();
        int numOfElements= jp.getInt("numberOfElements");
        System.out.println("numOfElements = " + numOfElements);
        List<String> nameList= jp.getList("content.name");
        System.out.println("nameList = " + nameList);
        List<Integer> idList = jp.getList("content.id");
        System.out.println("idList = " + idList);
    }
}
