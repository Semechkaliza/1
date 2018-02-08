package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Command to go to admin's profile
 */
public class GoHRProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        request.setAttribute("user",session.getAttribute("user"));
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.HR_PROFILE_PAGE;
    }
}
