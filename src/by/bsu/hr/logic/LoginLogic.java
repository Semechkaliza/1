package by.bsu.hr.logic;

import by.bsu.hr.command.PageConstant;
import by.bsu.hr.dao.UserDAO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginLogic {
    private static Logger logger=Logger.getLogger(LoginLogic.class);
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    public static String logIn(HttpServletRequest request){
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String page;
        List resList = UserDAO.findUser(login,pass);
        if(!resList.isEmpty()){
            request.setAttribute("user", resList);
            System.out.println(resList);
            page= PageConstant.MAIN_PAGE;
        } else {

            request.setAttribute("errorLoginPassMessage","Incorrect login or password.");
            page = PageConstant.LOGIN_PAGE;
            logger.log(Level.INFO,"Incorrect login or password");
        }
        return page;
    }

}
