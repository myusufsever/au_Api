package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceData {
public static int basariliSC=200;
public static String contentType="application/json; charset=utf-8";
public static  String header="keep-alive";

    public static JSONObject expectedDataOlustur22() {
JSONObject expData=new JSONObject();
        expData.put(  "userId",3);
        expData.put("id",22);
        expData.put(  "userId",3);
        expData.put( "title","dolor sint quo a velit explicabo quia nam");
        expData.put("body",
                "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

    return expData;

    }

  /*
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
         */

    public static JSONObject JsonDataOlustur(int userId,int id,String title,String body){
        JSONObject expData=new JSONObject();

        expData.put(  "userId", userId);
        expData.put("id",id);
        expData.put(  "title",title);
        expData.put( "body",body);

        return expData;


    }


        /*
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
         */









}
