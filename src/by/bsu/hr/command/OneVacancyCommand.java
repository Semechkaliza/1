package by.bsu.hr.command;

import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.OneVacancyLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OneVacancyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        int id= Integer.parseInt(request.getParameter("id"));
        Vacancy vac = null;
        try {
            vac = OneVacancyLogic.getVacancy(id);
        } catch (LogicException e) {
            return PageConstant.ERROR_PAGE;
        }
        HttpSession session=request.getSession(false);
        request.setAttribute("lang",session.getAttribute("locale"));
        request.setAttribute("oneVacancy", vac);
        return PageConstant.ONE_VACANCY_PAGE;
    }
}
