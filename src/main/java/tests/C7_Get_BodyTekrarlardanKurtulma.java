package tests;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C7_Get_BodyTekrarlardanKurtulma {
        /*
      https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json,
            ve response body’sindeki
            “firstname”in, “Eric”,
            ve “lastname”in, “Jackson”,
            ve “totalprice”in, 866,
            ve “depositpaid”in, true,
	        ve “additionalneeds”in, “Breakfast” oldugunu test edin
	        NOT: Veriler değişiyor Postman'de dataları kontrol ediniz
     */

    @Test
    public void bodyTekrarindanKurtulma(){

        String url=" https://restful-booker.herokuapp.com/booking/10";

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname", "Eric");
        reqBody.put("lastname","Smith");
        reqBody.put("totalprice","975");
        reqBody.put("depositpaid",true);

        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("firstname",equalTo("Eric"),"lastname",equalTo("Smith")
                        ,"totalprice",equalTo("975"),"depositpaid",equalTo(true));








    }















}
