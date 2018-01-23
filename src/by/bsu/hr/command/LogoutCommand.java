package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String  page= PageConstant.LOGIN_PAGE;
        Locale current=Locale.getDefault();
        System.out.println("country");
        System.out.println(current.getCountry());
        ResourceBundle rb=ResourceBundle.getBundle("resources.text",current);
        request.setAttribute("login",rb.getString("login"));
        request.setAttribute("password",rb.getString("password"));
        request.setAttribute("registration",rb.getString("registration"));
        request.setAttribute("LogIn",rb.getString("LogIn"));
        request.getSession().invalidate();
        return page;
    }
}