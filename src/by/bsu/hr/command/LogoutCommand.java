package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Command to log out
 */
public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("lang", Locale.getDefault());
        request.getSession().invalidate();
        return PageConstant.LOGIN_PAGE;
    }
}