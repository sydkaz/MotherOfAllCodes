package com.herokuapp.samkaz.generator;

import com.herokuapp.samkaz.bean.Entity;
import com.herokuapp.samkaz.bean.TemplateHolder;
import com.herokuapp.samkaz.utils.ConfigUtils;
import com.herokuapp.samkaz.utils.TextUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;


public abstract class AbstractGenerator {

    private VelocityEngine ve;
    private TemplateHolder templateHolder;


    private VelocityContext velocityContext;


    private Template template;

    public void generate(TemplateHolder template, Entity entity) {
        this.templateHolder = template;
        this.getVe().setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        this.getVe().setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        this.getVe().init();
        this.template = this.getVe().getTemplate("templates"+ File.separator + template.getName(), "UTF-8");
        this.getVelocityContext().put("entity", entity);

        Properties properties = ConfigUtils.getProperties();
        this.getVelocityContext().put("namespace", properties.getProperty("app.package"));
        this.getVelocityContext().put("project", properties.getProperty("app.name"));
        this.getVelocityContext().put("formattedProject", TextUtils.formatName(properties.getProperty("app.name")));
        this.getVelocityContext().put("path", properties.getProperty("app.package").replace(".", "/"));

        try{
            Files.createDirectories(Paths.get(template.getDestination()));
        }catch(Exception ex){
            System.out.println("Error while creating folder for template: " + template.getName() +  ", destination: " + template.getDestination());
        }
    }

    public void writeToFile(Template template, Path path){
        try{
            BufferedWriter writer = Files.newBufferedWriter(path);
            template.merge (this.getVelocityContext(), writer);
            writer.flush();
            writer.close();
        }catch (Exception ex){
            System.out.println("Error while writing to file: " + ex.getMessage());
        }
    }

    public String getHeader(String headerName){
        try {

            VelocityEngine ve = new VelocityEngine();
            ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            ve.init();

            Template template = ve.getTemplate("templates/java"+ File.separator + headerName, "UTF-8");
            VelocityContext context = new VelocityContext();
            context.put("YEAR", Calendar.getInstance().get(Calendar.YEAR));
            StringWriter w = new StringWriter();
            template.merge(context, w);
            return w.toString();

        } catch (Exception ex) {
            System.out.println("Error while generating template: " + template.getName() + ex.getMessage());
        }
        return null;
    }

    public void generate(TemplateHolder template, List<Entity> entities) {
        this.templateHolder = template;
        this.getVe().setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        this.getVe().setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        this.getVe().init();
        this.template = this.getVe().getTemplate("templates"+ File.separator + template.getName(), "UTF-8");
        this.getVelocityContext().put("entities", entities);

        Properties properties = ConfigUtils.getProperties();
        this.getVelocityContext().put("namespace", properties.getProperty("app.package"));
        this.getVelocityContext().put("project", properties.getProperty("app.name"));
        this.getVelocityContext().put("formattedProject", TextUtils.formatName(properties.getProperty("app.name")));
        this.getVelocityContext().put("path", properties.getProperty("app.package").replace(".", "/"));

        try{
            Files.createDirectories(Paths.get(template.getDestination()));
        }catch(Exception ex){
            System.out.println("Error while creating folder for template: " + template.getName() +  ", destination: " + template.getDestination());
        }
    }

    public VelocityEngine getVe() {
        if (ve == null) {
            this.ve = new VelocityEngine();
        }
        return ve;
    }

    public TemplateHolder getTemplateHolder() {
        return templateHolder;
    }

    public void setTemplateHolder(TemplateHolder templateHolder) {
        this.templateHolder = templateHolder;
    }

    public VelocityContext getVelocityContext() {
        if (velocityContext == null){
            velocityContext = new VelocityContext();
        }
        return velocityContext;
    }

    public void setVelocityContext(VelocityContext velocityContext) {
        this.velocityContext = velocityContext;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }



}
