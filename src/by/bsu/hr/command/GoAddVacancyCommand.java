package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Command to go to add new vacancy page
 */
public class GoAddVacancyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.ADD_VACANCY_PAGE;
    }
}
