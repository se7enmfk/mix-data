package com.se7en;

import com.ftx.frame.util.cg.AutoGenerator;
import com.ftx.frame.util.cg.ConfigDataSource;
import com.ftx.frame.util.cg.ConfigGenerator;
import com.ftx.frame.util.properties.PropertiesUtil;

public class CustomGenerator {


    public static void main(String[] args) {
        ConfigGenerator configGenerator = new ConfigGenerator();
        AutoGenerator autoGenerator = new AutoGenerator();
        PropertiesUtil p = PropertiesUtil.getInstance("database");
        configGenerator.setDbDriverName(p.getProperty("database.jdbc.driverClassName"));
        configGenerator.setDbUrl(p.getProperty("database.jdbc.url"));
        configGenerator.setDbUser(p.getProperty("database.jdbc.username"));
        configGenerator.setDbPassword(p.getProperty("database.jdbc.password"));
        configGenerator.setDbName(p.getProperty("database.name"));
        configGenerator.setDbSchema(p.getProperty("database.schema"));
        configGenerator.setConfigDataSource(ConfigDataSource.POSTGRESQL);
        configGenerator.setSaveDir("D:\\github\\java\\mix-data\\mix-client\\");
        configGenerator.setTableNames(new String[]{"pro_area"});
        configGenerator.setBuliderModel(true);
        configGenerator.setEntityPackage("com.se7en.biz.%s.entity");
        configGenerator.setMapperPackage("com.se7en.biz.%s.mapper");
        configGenerator.setServicePackage("com.se7en.biz.%s.service");
        configGenerator.setControllerPackage("com.se7en.biz.%s.controller");
        configGenerator.setAuthor("se7en zhou");
        autoGenerator.run(configGenerator);
    }
}
