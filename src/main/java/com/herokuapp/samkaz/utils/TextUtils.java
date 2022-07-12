package com.herokuapp.samkaz.utils;

import org.apache.commons.lang3.StringUtils;

public class TextUtils {

    public static String formatName(String name){
        if (name != null && !"".equals(name)){
            return StringUtils.remove(org.apache.commons.lang3.text.WordUtils.capitalizeFully(name, '_'), "_");
        }
        return "";
    }

    public static String formatPrivatePropertyName(String name){
        name = formatName(name);
        if (!"".equals(name)){
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        return "";
    }
}
