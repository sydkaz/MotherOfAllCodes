package com.herokuapp.samkaz.generator;

import com.herokuapp.samkaz.bean.Entity;
import com.herokuapp.samkaz.bean.TemplateHolder;
import com.herokuapp.samkaz.utils.ConfigUtils;
import com.herokuapp.samkaz.utils.TextUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class BeanManagementGenerator extends AbstractGenerator{

    @Override
    public void generate(TemplateHolder template, List<Entity> entities) {
        super.generate(template, entities);

        Properties properties = ConfigUtils.getProperties();
        Path path = Paths.get(template.getDestination(), TextUtils.formatName(properties.getProperty("app.name")) + "BeansConfiguration.java");
        this.getVelocityContext().put("header", this.getHeader("java_header_template.vm"));
        this.writeToFile(this.getTemplate(),  path);

    }
}
