package com.herokuapp.samkaz.db;

import com.herokuapp.samkaz.Constants;
import com.herokuapp.samkaz.utils.ConfigUtils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBManagement {

    private static DBManagement dBManagementInstance;

    public DBManagement(){}
    public static DBManagement getInstance(){
        if (dBManagementInstance == null){
            dBManagementInstance = new DBManagement();
        }
        return dBManagementInstance;
    }


    public Connection getConnection(){
        Connection con = null;
        try{
            Properties pros = ConfigUtils.getProperties();
            Class.forName(pros.getProperty(Constants.DB_JDBC_DRIVER_CLASS_KEY));
            con = DriverManager.getConnection(pros.getProperty(Constants.DB_URL_KEY),
                    pros.getProperty(Constants.DB_USERNAME_KEY),
                    pros.getProperty(Constants.DB_PASSWORD_KEY));

            return con;

        }catch (Exception ex){
            System.out.println("Error while connecting to DB: " + ex.getMessage());
            return null;
        }
    }

}
