package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

public class EmptyCommand implements ActionCommand {
    @Override public String execute(HttpServletRequest request) {
        ResourceBundle rb=ResourceBundle.getBundle("resources.text", Locale.getDefault());
        request.setAttribute("login",rb.getString("login"));
        request.setAttribute("password",rb.getString("password"));
        request.setAttribute("registration",rb.getString("registration"));
        request.setAttribute("LogIn",rb.getString("LogIn"));
        String page = PageConstant.LOGIN_PAGE;
        return page;
    }
}
