package by.bsu.hr.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static String DB_URL="jdbc:mysql://localhost:3306/HR_system";
    private static final Properties DB_PROPERTIES=new Properties();

    static {
        DB_PROPERTIES.setProperty("user","root");
        DB_PROPERTIES.setProperty("password","root");
        DB_PROPERTIES.setProperty("useSSL","false");
        DB_PROPERTIES.setProperty("autoReconnect","true");
    }
    public PropertiesManager() throws IOException{
        try{
            Properties props = new Properties();
            props.load(new FileInputStream(new File("WEB-INF/classes/db.properties")));

            DB_URL = props.getProperty("db.url");
        }
        catch (IOException e){
            System.out.println("Can't find the file");
        }
    }
    public static String getDbUrl(){return DB_URL;}

    public static Properties getDbProperties(){return DB_PROPERTIES;}

}
