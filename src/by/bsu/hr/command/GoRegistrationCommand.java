package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Command to go to registration page
 */
public class GoRegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("lang", Locale.getDefault());
        return PageConstant.REGISTRATION_PAGE;
    }
}
