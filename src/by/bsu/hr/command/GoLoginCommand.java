package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Command to go to login page
 */
public class GoLoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("lang", Locale.getDefault());
        return PageConstant.LOGIN_PAGE;
    }
}
