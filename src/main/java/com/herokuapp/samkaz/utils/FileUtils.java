package com.herokuapp.samkaz.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.File;

public class FileUtils {

    public static String getTemplateFolder() {

        try{
            File folder = new ClassPathResource("templates").getFile();
            if(folder.exists()){
                return folder.getPath();
            }
        }catch (Exception ex){

        }
        return null;
    }

    public static File createFolder(String path){
        try {
            File newFile = new File(path);
            if (!newFile.exists()) {
                newFile.mkdir();
                return newFile;
            }
        }catch (Exception ex){
            System.out.println("Error while creating new folder: " + ex.getMessage());
        }
        return null;
    }
}
