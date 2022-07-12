package com.herokuapp.samkaz;


import com.herokuapp.samkaz.bean.Entity;
import com.herokuapp.samkaz.bean.TemplateHolder;
import com.herokuapp.samkaz.db.DBManagement;
import com.herokuapp.samkaz.db.TableMetadata;
import com.herokuapp.samkaz.generator.*;
import com.herokuapp.samkaz.utils.ConfigUtils;


import java.io.File;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MainApplication{
    private static final String JAVA_FOLDER = "java";
    public static void main(String args[]){
        MainApplication app = new MainApplication();
//        Application.launch(MainUI.class, args);
        app.run();

    }
    public void run(){
        Properties pros = ConfigUtils.getProperties();
        String generatedDestination = pros.getProperty("generator.destination", "./generatedcode");
        System.out.println("[~] Start generating JPA-Spring MVC ....");

        String excluded = pros.getProperty("app.excluded.list");
        List<String> excludedList = Arrays.asList(excluded.split(","));

        List<Entity> entities = (new TableMetadata()).getTableMetadata();
        if (!entities.isEmpty()){
            for(Entity entity : entities){
                if (!excludedList.contains(entity.getName())){
                    //Dtos
                    DtoGenerator dtoGenerator = new DtoGenerator();
                    TemplateHolder jpaTemplate = new TemplateHolder(JAVA_FOLDER + "/dto_template.vm",  generatedDestination + File.separator + Constants.PROJECT_SOURCE_PATH + File.separator + "dto");
                    dtoGenerator.generate(jpaTemplate, entity);

                    //Controllers
                    ControllerGenerator controllerGenerator = new ControllerGenerator();
                    TemplateHolder controllerTemplate = new TemplateHolder(JAVA_FOLDER + "/controller_template.vm",  generatedDestination  + File.separator + Constants.PROJECT_SOURCE_PATH + File.separator + "controller");
                    controllerGenerator.generate(controllerTemplate, entity);

                    //Repositories
                    RepositoryGenerator repositoryGenerator = new RepositoryGenerator();
                    TemplateHolder repositoryTemplate = new TemplateHolder(JAVA_FOLDER + "/repository_template.vm",  generatedDestination  + File.separator + Constants.PROJECT_SOURCE_PATH + File.separator + "repositories");
                    repositoryGenerator.generate(repositoryTemplate, entity);

                    //Service
                    ServiceGenerator serviceGenerator = new ServiceGenerator();
                    TemplateHolder serviceTemplate = new TemplateHolder(JAVA_FOLDER + "/service_template.vm",  generatedDestination  + File.separator + Constants.PROJECT_SOURCE_PATH + File.separator + "service");
                    serviceGenerator.generate(serviceTemplate, entity);

                    //Service Implementation
                    ServiceImplGenerator serviceImplGenerator = new ServiceImplGenerator();
                    TemplateHolder serviceImplTemplate = new TemplateHolder(JAVA_FOLDER + "/service_impl_template.vm",  generatedDestination  + File.separator + Constants.PROJECT_SOURCE_PATH + File.separator + "service"+ File.separator + "impl");
                    serviceImplGenerator.generate(serviceImplTemplate, entity);
                }

            }
        }

        //Generate Bean Configuration class
//        BeanManagementGenerator beanManagementGenerator = new BeanManagementGenerator();
//        TemplateHolder beanMgtTemplate = new TemplateHolder(JAVA_FOLDER + "/bean_management_template.vm",  generatedDestination  + File.separator + Constants.PROJECT_SOURCE_PATH + File.separator + "bean");
//        beanManagementGenerator.generate(beanMgtTemplate, entities);


        try{
            Connection connection = DBManagement.getInstance().getConnection();
            if (!connection.isClosed()){
                connection.close();
            }
        }catch (Exception ex){
            System.out.println("Error while closing the connection");
        }

    }
}
