package com.herokuapp.samkaz.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTypeDictionaryUtils {

    public static String convertMysqlDataType2Java(String dbType) {
        if (dbType != null && !dbType.equals("")) {
            if (dbType.equalsIgnoreCase("VARCHAR")
                    || dbType.equalsIgnoreCase("CHAR")
                    || dbType.equalsIgnoreCase("LONGVARCHAR")
                    || dbType.equalsIgnoreCase("TEXT")
                    || dbType.equalsIgnoreCase("LONGTEXT")) {
                return "String";
            } else if (dbType.equalsIgnoreCase("NUMERIC") || dbType.equalsIgnoreCase("DECIMAL")) {
                return "java.math.BigDecimal";
            } else if (dbType.equalsIgnoreCase("BIT")) {
                return "Boolean";
            } else if (dbType.equalsIgnoreCase("TINYINT")) {
                return "byte";
            } else if (dbType.equalsIgnoreCase("SMALLINT")) {
                return "short";
            } else if (dbType.equalsIgnoreCase("INT")) {
                return "int";
            } else if (dbType.equalsIgnoreCase("BIGINT")) {
                return "long";
            } else if (dbType.equalsIgnoreCase("REAL")) {
                return "float";
            } else if (dbType.equalsIgnoreCase("FLOAT") || dbType.equalsIgnoreCase("DOUBLE")) {
                return "double";
            } else if (dbType.equalsIgnoreCase("BINARY") || dbType.equalsIgnoreCase("VARBINARY") || dbType.equalsIgnoreCase("LONGVARBINARY")) {
                return "byte []";
            } else if (dbType.equalsIgnoreCase("DATE")) {
                return "java.sql.Date";
            } else if (dbType.equalsIgnoreCase("TIME")) {
                return "java.util.Date";
            } else if (dbType.equalsIgnoreCase("TIMESTAMP") || dbType.equalsIgnoreCase("DATETIME")) {
                return "java.util.Date";
            }
        }
        return "";
    }

    public static Boolean isJavaDataType(String newType){
        String typeList = "String,java.math.BigDecimal,Boolean,byte,short,int,long,float,double,byte [],java.sql.Date,java.sql.Time,java.sql.Timestamp";
        List<String> myList = new ArrayList<String>(Arrays.asList(typeList.split(",")));
        return myList.contains(newType);
    }
}
