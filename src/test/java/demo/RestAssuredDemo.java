package demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RestAssuredDemo {

    public String createToken() {
        String body = """
                {
                "username" : "admin",
                 "password" : "password123"
                }
                """;
        return RestAssured.
                given()
                .header("Content-Type", "application/json")
                .body(body)
                .log().all().
                when()
                .post("https://restful-booker.herokuapp.com/auth").
                then()
                .assertThat().statusCode(200).
                and().
                log().body().extract().body().jsonPath().get("token").toString();
    }

    public String createBooking() {
        String body = """
                { "firstname" : "Tasnim", 
                "lastname" : "Adel Mohamed", 
                "totalprice" : 21, 
                "depositpaid" : true, 
                "bookingdates" : 
                { 
                   "checkin" : "2024-22-2",              
                  "checkout" : "2025-02-02"                
                },                
                "additionalneeds" : "Breakfast"     
                }  
                """;

       return RestAssured
               .given()
               .contentType(ContentType.JSON)
               .body(body)
               .log()
               .all()
               .when()
               .post("https://restful-booker.herokuapp.com/booking").
               then().statusCode(200)
               .and().log().body().extract().body().jsonPath().get("bookingid").toString();
    }
    @Test
    public void deleteBooking(){
        RestAssured.
                given()
                .header("Content-Type", "application/json")
                .cookie("token=" + createToken())
                .log().all().
                when()
                .delete("https://restful-booker.herokuapp.com/booking/"+createBooking()).
                then().
                log().body();

    }

}
