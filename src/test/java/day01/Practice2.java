package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Practice2 {

    @DisplayName("Printing the response body using method")
    @Test
    public void printingBody() {
        //  Response response = get("http://54.174.216.245:8000/api/hello");

        // Hamcrest already come with RestAssured dependency
        // hamcrest library use the assertThat method for all assertions
        // hamcrest use built in matchers to do assertion
        // couple common ones are :
        //  is( some value )
        // equalTo( some value)
        //  or optionally   is ( equalTo(some value) )
        int num1 = 5;
        int num2 = 4;
        assertThat(num1 + num2, is(9));
        assertThat(num1 + num2, equalTo(9));
        assertThat(num1 + num2, is(equalTo(9)));
        int num3=5;
        int num4=8;
        // not( value )
        // is( not (some value ) )
        // not( equalTo(11) )
        assertThat(num1 + num2, not(11));
        assertThat(num1 + num2, is(not(11)));

       assertThat(num3+num4,notNullValue());
       assertThat(num3*num4,is(40));
       assertThat(num3+num4,equalTo(13));
        // save your first name and last name into 2 variables
        // test the concatenation result using hamcrest matcher
        String firstName = "Kaisar "; // there is a space in last character here
        String lastName = "Anvar";
        assertThat(firstName + lastName, is("Kaisar Anvar"));
        assertThat(firstName + lastName, equalTo("Kaisar Anvar"));
        assertThat(firstName + lastName, is(equalTo("Kaisar Anvar")));
        String firstName1="Nurgul";
        String lastName2="Celik";
        assertThat(firstName1+lastName2,equalTo("NurgulCelik"));
        // String matchers
        // equalToIgnoringCase
        // equalToCompressingWhiteSpace
        //containsString, endsWith, startsWith - test string matching
        // how to check in case insensitive manner
        assertThat(firstName, equalToIgnoringCase("kaisar "));
        // how to ignore all whitespaces
        assertThat(firstName, equalToCompressingWhiteSpace("Kaisar"));
        List<Integer> numList = Arrays.asList(11, 44, 3, 55, 88, 5);
        List<Integer>numList2=Arrays.asList(2,5,8,9,20);
        assertThat(numList2,hasSize(5));
        assertThat(numList2,hasItem(20));
        assertThat(numList2,hasItems(5,8,20));
        // checking the list size is list
        assertThat(numList, hasSize(6));
        // checking the list contains 11
        assertThat(numList, hasItem(11));
        // has items is used to check multiple items : 11, 3, 5
        assertThat(numList, hasItems(11, 3, 5));
        // contains method works like equals here
        // checking the list contains all the items in exact order : 11,44,3,55,88,5
        assertThat(numList, contains(11, 44, 3, 55, 88, 5));

    }

}
