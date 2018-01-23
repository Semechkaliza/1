package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LoginLogic;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.tomcat.jni.Local;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(LoginCommand.class);
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String lang=request.getParameter("locale");
        System.out.println(lang);
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String page;
        List<User> resList = LoginLogic.logIn(login,pass);
        if(!resList.isEmpty()){
            HttpSession session=request.getSession(true);
            Locale current=new Locale(lang);
            session.setAttribute("locale",current);
            ResourceBundle rb=ResourceBundle.getBundle("resources.text",current);
            request.setAttribute("login",rb.getString("login"));
            request.setAttribute("name",rb.getString("name"));
            request.setAttribute("sname",rb.getString("sname"));
            request.setAttribute("role",rb.getString("role"));
            request.setAttribute("rating",rb.getString("rating"));
            request.setAttribute("vacancy",rb.getString("vacancy"));
            request.setAttribute("welcome",rb.getString("welcome"));
            request.setAttribute("LogOut",rb.getString("LogOut"));
            request.setAttribute("main",rb.getString("main"));
            request.setAttribute("user", resList);
            page= PageConstant.MAIN_PAGE;
        } else {
            ResourceBundle rb=ResourceBundle.getBundle("resources.text",Locale.getDefault());
            request.setAttribute("errorLoginPassMessage",rb.getString("message.IncorrectInfo"));
            request.setAttribute("login",rb.getString("login"));
            request.setAttribute("password",rb.getString("password"));
            request.setAttribute("registration",rb.getString("registration"));
            request.setAttribute("LogIn",rb.getString("LogIn"));
            page = PageConstant.LOGIN_PAGE;
        }
        return page;
    }
}