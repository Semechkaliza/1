package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Empty command
 */
public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("lang", Locale.getDefault());
        return PageConstant.LOGIN_PAGE;
    }
}
