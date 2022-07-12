package com.herokuapp.samkaz.utils;

import com.herokuapp.samkaz.bean.TemplateHolder;

public class VelocityUtils {


    private TemplateHolder templateHolder;

    public VelocityUtils() {
    }

    public VelocityUtils(TemplateHolder template) {
    }


    public TemplateHolder getTemplateHolder() {
        return templateHolder;
    }

    public void setTemplateHolder(TemplateHolder templateHolder) {
        this.templateHolder = templateHolder;
    }

}
