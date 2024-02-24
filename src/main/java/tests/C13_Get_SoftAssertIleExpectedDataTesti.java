package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {

     /*
   http://dummy.restapiexample.com/api/v1/employee/3 url'ine
   bir GET request gonderdigimizde
   donen response'un asagidaki gibi oldugunu test edin.

       Response Body (expectedBody)
       {
           "status":"success",
           "data":{
                   "id":3,
                   "employee_name":"Ashton Cox",
                   "employee_salary":86000,
                   "employee_age":66,
                   "profile_image":""
                   },
           "message":"Successfully! Record has been fetched."

*/

     @Test
    public void expBodyTesti(){
         String url="  http://dummy.restapiexample.com/api/v1/employee/3";

         JSONObject data=new JSONObject();
          data.put("id",3);
         data.put("employee_name","Ashton Cox");
         data.put("employee_salary",86000);
         data.put("employee_age",66);
         data.put("profile_image","");

         JSONObject reqBody=new JSONObject();
         reqBody.put( "status","success");
         reqBody.put( "data",data);
         reqBody.put("message","Successfully! Record has been fetched.");



         Response response=given().when().get(url);


         JsonPath resJp=response.jsonPath();
         SoftAssert softAssert=new SoftAssert();

         softAssert.assertEquals(resJp.get("status"),reqBody.get("status"));
         softAssert.assertEquals(resJp.get("data.id"),reqBody.getJSONObject("data").get("id"));
         softAssert.assertEquals(resJp.get("data.employee_name"),reqBody.getJSONObject("data").get("employee_name"));
         softAssert.assertEquals(resJp.get("data.employee_salary"),reqBody.getJSONObject("data").get("employee_salary"));
          softAssert.assertEquals(resJp.get("data.employee_age"),reqBody.getJSONObject("data").get("employee_age"));
          softAssert.assertEquals(resJp.get("data.profile_image"),reqBody.getJSONObject("data").get("profile_image"));
          softAssert.assertEquals(resJp.get("message"),reqBody.get("message"));








     }

















}
