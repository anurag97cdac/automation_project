package com.sdet.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    
    Properties prop;

    public ConfigReader(){
        try{
            prop = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(is);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getProperty(String key){
        return prop.getProperty(key);
    }
}
