package by.bsu.hr.connection;

import by.bsu.hr.dao.UserDAO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

public class DBResourceManager {
    private static Logger logger=Logger.getLogger(UserDAO.class);
        private final static DBResourceManager instance = new DBResourceManager();

        private ResourceBundle bundle = ResourceBundle.getBundle("resources/db");

        public static DBResourceManager getInstance() {
            logger.log(Level.INFO,"at getInstance");
            return instance;
        }

         public String getValue(String key){
             return bundle.getString(key);
        }

    }
