package com.herokuapp.samkaz.bean;

public class Column {

    private String name;
    private String dataType;
    private Boolean isJavaType;
    private String propertyName;
    private String dtoPropertyName;

    public Column() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Boolean getJavaType() {
        return isJavaType;
    }

    public void setJavaType(Boolean javaType) {
        isJavaType = javaType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getDtoPropertyName() {
        return dtoPropertyName;
    }

    public void setDtoPropertyName(String dtoPropertyName) {
        this.dtoPropertyName = dtoPropertyName;
    }

}
