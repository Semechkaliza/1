package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LoginLogic;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(LoginCommand.class);
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String page;
        List<User> resList = LoginLogic.logIn(login,pass);
        if(!resList.isEmpty()){
            request.setAttribute("user", resList);
            page= PageConstant.MAIN_PAGE;
        } else {
            request.setAttribute("errorLoginPassMessage","Incorrect login or password.");
            page = PageConstant.LOGIN_PAGE;
        }
        return page;
    }
}