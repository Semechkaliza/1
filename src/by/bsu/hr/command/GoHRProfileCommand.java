package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Command to go to admin's profile
 */
public class GoHRProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            request.setAttribute("user", session.getAttribute("user"));
            request.setAttribute("lang", session.getAttribute("locale"));
            return PageConstant.HR_PROFILE_PAGE;
        } else {
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }

    }
}
