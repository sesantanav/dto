package com.sendai.dto.customerDAO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Map;

public class CustomerApiUrl {
  
  public static void llamado() throws Exception {
    String url = "http://localhost/northwindapi/customersapi.php";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    
    int responseCode = con.getResponseCode();
    System.out.println("enviado get a: " + url);
    System.out.println("Response code : " + responseCode);

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
    
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    System.out.println(response.toString());

    // in.close();

    String json = response.toString();
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = (JSONObject) parser.parse(json);
    System.out.println(jsonObject);

    //JSONObject customerResponse = new JSONObject(in);
  }
}