package by.bsu.hr.connection;

import by.bsu.hr.dao.UserDAO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/**
 * Manager to get all parameters for db from properties file
 */
public class DBResourceManager {
        private final static DBResourceManager instance = new DBResourceManager();

        private ResourceBundle bundle = ResourceBundle.getBundle("resources/db");

        public static DBResourceManager getInstance() {
            return instance;
        }

         public String getValue(String key){
             return bundle.getString(key);
        }

    }
