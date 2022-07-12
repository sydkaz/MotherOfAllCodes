package com.herokuapp.samkaz.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    public static Properties getProperties(){
        InputStream inputStream = null;
        try{
            ClassLoader loader = Thread.currentThread().getContextClassLoader();

            inputStream = loader.getResourceAsStream("application.properties");
            if (inputStream != null){
                Properties pros = new Properties();
                pros.load(inputStream);
                return pros;
            }
        }catch (Exception ex){
            System.out.println("Error while reading the application.properties");
        }finally {
            if (inputStream != null){
                try{
                    inputStream.close();
                }catch (Exception ex){}


            }
        }
        return null;
    }
}
