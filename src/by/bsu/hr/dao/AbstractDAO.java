package by.bsu.hr.dao;


import com.mysql.jdbc.Statement;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import java.sql.SQLException;

public interface AbstractDAO {
    Logger logger=Logger.getLogger(AbstractDAO.class);
    default void close(Statement st){
        try{
            if(st!=null) {
                st.close();
            }
        }catch (SQLException e){
            logger.log(Level.INFO, "Error closing the connection.", e);
        }
    }
}