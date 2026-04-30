package com.sdet.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    //Implement logic to read data from JSON file and return it as a 2D Object array for DataProvider

    // provide test Data from loginData.json
    @DataProvider(name = "loginData")
    public static Object[][] getLoginData(){
        
        Object[][] data = null;

        try{
            //Read file from Path and convert it to String
            String jsonContent = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\testData\\loginData.json")));
            //Parse the JSON content and convert it to a JSON Array
            JSONArray jsonArray = new JSONArray(jsonContent);
            //Initialize data Array
            data = new Object[jsonArray.length()][1];
            for(int i = 0;i < jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Map<String,Object> map = jsonObject.toMap();
                data[i][0] = map; 
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return data;
    }

}
