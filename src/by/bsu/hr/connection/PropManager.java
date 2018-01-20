package by.bsu.hr.connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropManager {
    private void initialize(){
        InputStream input=getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties properties= new Properties();
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
