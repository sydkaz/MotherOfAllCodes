package com.herokuapp.samkaz.bean;

/**
 * Created by Henry Truong
 */
public class TemplateHolder {
    private String name;
    private String destination;

    public TemplateHolder() {
    }

    public TemplateHolder(String name, String destination) {
        this.name = name;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBinder() {
        return binder;
    }

    public void setBinder(String binder) {
        this.binder = binder;
    }

    private String binder;

}
