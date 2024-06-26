package tests;

import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C8_JsonPathKullanimi {
           /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]


    }


     */

    @Test
    public void jSonPathKullanimi(){

     JSONObject homeTel=new JSONObject();
     homeTel.put("type","home");
     homeTel.put("number","0123-4567-8910");


     JSONObject iPhone=new JSONObject();
     iPhone.put("type","iPhone");
     iPhone.put("type","0123-4567-8888");



     JSONArray phoneNumbers=new JSONArray();
     phoneNumbers.put(0,homeTel);
     phoneNumbers.put(1,iPhone);

     JSONObject adress=new JSONObject();
     adress.put("streetAddress","naist street");
     adress.put("city","Nara");
     adress.put("postalCode","630-0192");

     JSONObject personalInfo=new JSONObject();
     personalInfo.put("firstName","John");
     personalInfo.put("lastName","doe");
     personalInfo.put("age","26");
     personalInfo.put("address",adress);
     personalInfo.put("phoneNumbers",phoneNumbers);

        System.out.println("İsim : "+personalInfo.get("firstName"));
        System.out.println("Soyisim : "+personalInfo.get("lastName"));
        System.out.println("Yaş  : "+personalInfo.get("age"));
        System.out.println("Adres : "+personalInfo.getJSONObject("address").get("streetAddress")+"\n\t\t\t"
                +personalInfo.getJSONObject("address").get("postalCode")+"     "
                +personalInfo.getJSONObject("address").get("city"));

        System.out.println("Telefon : "+personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("type")+"-"
                +personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("number")+"\n\t\t"
                +personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("type")+"-"
                +personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));








    }

}
