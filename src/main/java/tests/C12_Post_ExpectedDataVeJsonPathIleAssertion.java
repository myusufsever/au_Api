package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

     /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un bookingid haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Hasan",
        "lastname" : "Yagmur",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }

        Expected Response Body
        {
        "bookingid":24,
        "booking":{
            "firstname":"Hasan",
            "lastname":"Yagmur",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2021-06-10"
                },
        "additionalneeds":"wi-fi"
        }
        }
         */



    @Test
    public void expBodyPostaTesti(){


        String url=" https://restful-booker.herokuapp.com/booking";

        JSONObject innerData=new JSONObject();
        innerData.put( "checkin","2021-06-01");
        innerData.put( "checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Hasan");
        reqBody.put("lastname" ,"Yagmur");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" , innerData);
        reqBody.put("additionalneeds","wi-fi");

        //2-ExpBody hazırlama
        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        //3-Request Gönder ve Response Kaydet

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        //response.prettyPrint();
        //4-Assertion yapma (assertEqual(expected,respons)

        JsonPath resJp=response.jsonPath();




        assertEquals(expBody.getJSONObject("booking").get("firstname"),  resJp.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJp.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJp.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJp.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJp.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJp.get("booking.bookingdates.checkout"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJp.get("booking.additionalneeds"));




















    }











}
