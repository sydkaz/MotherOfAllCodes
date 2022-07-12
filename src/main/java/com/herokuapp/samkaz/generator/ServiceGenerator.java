package com.herokuapp.samkaz.generator;

import com.herokuapp.samkaz.bean.Entity;
import com.herokuapp.samkaz.bean.TemplateHolder;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ServiceGenerator extends AbstractGenerator {

    @Override
    public void generate(TemplateHolder template, Entity entity) {
        try {
            super.generate(template, entity);
            Path path = Paths.get(template.getDestination(), entity.getName() + "Service.java");
            this.getVelocityContext().put("header", this.getHeader("java_header_template.vm"));
            this.writeToFile(this.getTemplate(),  path);

        } catch (Exception ex) {
            System.out.println("Error while generating template: " + template.getName() + " : " + ex.getMessage());
        }
    }
}
