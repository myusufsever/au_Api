package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C14_baseUrlHerOkuApp extends BaseUrlHerOkuApp {
    /*
    //1-  https://restful-booker.herokuapp.com/booking endpointine
    //    bir GET request gonderdigimizde
    //    donen response’un
    //          status code’unun 200 oldugunu
    //          ve Response’ta 12 booking oldugunu test edin

     */

    public void test01(){

        //1-EndPoint ve reqBody hazırlama hazırlama
       specHerOkuApp.pathParam("pp1","booking");
        //2-expBody hazırlama

        Response response=given().when().spec(specHerOkuApp).get("/{pp1}");

        //3-response kaydet

        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasItem(51));



    }


}
