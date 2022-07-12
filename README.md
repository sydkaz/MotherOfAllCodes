## This is the mother of all codes(Literally)!

This code allows you to generate the Model, Controller, and Repository from the database table.

This project is done as a part of a test project after getting code generation techniques from SAP Commerce(Hybris)

---

**How to Run?**

First, you will have to open this project in an IDE i.e IntelliJ. Then Set the below parameters in the application.properties file.

1. Specify database URL for the database table you want to generate code for i.e db.url=jdbc:mysql://localhost:3306/cq?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false
2. Specify Username for DB i.e db.username=root
3. Specify Password for DB i.e db.password=
5. Specify context by setting a package name i.e app.package=com.samkaz.heroku
6. Specify app scope will be used in package notation i.e app.name=mechanic

---

## Set Template Data

The application uses apache velocity templates and the templates are saved under the templates.java folder, you can modify any existing template or add a new template based on the requirement.
---

## Run the code

To run the code you have to run the main application which will generate code for the database in generatedcode folder in the root of this project. 
