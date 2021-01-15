package day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PutAndDeleteRequestExample {
  @BeforeAll
    public static void setUp(){

      RestAssured.baseURI="http://107.20.53.61";
      RestAssured.port=8000;
      RestAssured.basePath="/api";
  }

  @Test
    @DisplayName("Update Existing Data")
    public void updateData(){
      String updateBody="{\n" +
              "        \"id\": 112,\n" +
              "        \"name\": \"Talha\",\n" +
              "        \"gender\": \"Male\",\n" +
              "        \"phone\": 1536037088\n" +
              "    }";
      given()
              .contentType(ContentType.JSON)
              .body(updateBody)
              .log().all()
              .when()
              .put("/spartans/{id}",112)

              .then()
              .log().all()
              .statusCode(204);

  }
  @Test
    @DisplayName("Delete data using delete method")
    public void deleteData(){
      when().delete("/spartans/{id}",113)
              .then()
              .statusCode(204);
  }

}
