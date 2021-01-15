package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ExtractingDataUsingJsonPath {

    @Test
    @DisplayName("Getting Movie info")
    public void extractDataByUsingJsonPath(){
      Response response= given()
               .log().all()
               .queryParam("apikey","26aa5b74")
               .queryParam("t","Boss Baby")
               .when()
               .get("http://www.omdbapi.com")
               .prettyPeek();
        JsonPath jsonPath= response.jsonPath();
        String title= jsonPath.getString("Title");
        System.out.println("Title is "+title);
        Map<String,Object> ratings1= jsonPath.getMap("Ratings[1]");

        System.out.println(ratings1);
        List<String> sourceList= jsonPath.getList("Ratings.Source");
        System.out.println(sourceList);




    }

}
