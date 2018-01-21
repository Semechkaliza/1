package by.bsu.hr.logic;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;
import org.apache.log4j.Logger;
import java.util.List;

public class LoginLogic {
    private static Logger logger=Logger.getLogger(LoginLogic.class);
    public static List<User> logIn(String login, String pass){
        return UserDAO.findUser(login,pass);
    }

}
