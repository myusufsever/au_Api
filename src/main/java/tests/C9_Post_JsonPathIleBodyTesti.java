package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class C9_Post_JsonPathIleBodyTesti {

      /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
     bir POST request gonderdigimizde
     {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" :{
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                        },
        "additionalneeds" : "wi-fi"
     }
     donen Response’un,
     status code’unun 200,
     ve content type’inin application/json,
     ve response body’sindeki
     "firstname“in,"Ahmet",
     ve "lastname“in, "Bulut",
     ve "totalprice“in,500,
     ve "depositpaid“in,false,
     ve "checkin" tarihinin 2021-06-01 ve "checkout" tarihinin 2021-06-10
     ve "additionalneeds“in,"wi-fi"
     oldugunu test edin

     */

    @Test

    public void JsonPathIleBodyTesti(){

       String url=" https://restful-booker.herokuapp.com/booking";

        JSONObject reqBody=new JSONObject();

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");

        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice","500");
        reqBody.put("depositpaid","false");
        reqBody.put("bookingdates",bookingdates );
        reqBody.put( "additionalneeds" , "wi-fi");

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);


        //Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);


        response.then().assertThat()
                .statusCode(200).contentType("application/json")
                .body("booking.firstname", equalTo("Ahmet"),
                "booking.lastname",equalTo("Bulut"),
                "booking.totalprice",equalTo(500),
                "booking.depositpaid",equalTo("false"),
                "booking.bookingdates.checkin",equalTo("2021-06-01"),
                "booking.bookingdates.checkout",equalTo("2021-06-10"),
                "booking.additionalneeds",equalTo("wi-fi"));

/*

        response.then().assertThat()
                            .statusCode(200).contentType("application/json")
                                              .body("booking.firstname", equalTo("Ahmet"),
                                              "booking.lastname", equalTo("Bulut"),
                                                       "booking.totalprice", equalTo(500),
                                                       "booking.depositpaid", equalTo(false),
                                                       "booking.bookingdates.checkin", equalTo("2021-06-01"),
                                                       "booking.bookingdates.checkout", equalTo("2021-06-10"),
                                                       "booking.additionalneeds",equalTo("wi-fi"));
 */






    }








}
