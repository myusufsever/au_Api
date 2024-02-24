package tests;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C5_Get_ResponseBodyTesti
{

    //   https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
    //   donen Response'in
    //   status code'unun 200,
    //   ve content type'inin application/json; charset=utf-8,
    //   ve response body'sinde bulunan userId'nin 5,
    //   ve response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.

    @Test
    public void get01(){
        //1-Endpoit to be ready
        String url=" https://jsonplaceholder.typicode.com/posts/44";

        //2-To have expectedbody to be ready


        //3-Actual data to be ready

   Response response=given().when().get(url);

   //Assertion islemi

        response.then().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", equalTo(5))
                .body("title",equalTo("optio dolor molestias sit"));



















        
    }







}
