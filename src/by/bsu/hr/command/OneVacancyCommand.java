package by.bsu.hr.command;

import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.OneVacancyLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OneVacancyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        int id= Integer.parseInt(request.getParameter("id"));
        Vacancy vac = OneVacancyLogic.getVacancy(id);
        HttpSession session=request.getSession(false);
        ResourseBundle.ResourceBundleEnum rb= (ResourseBundle.ResourceBundleEnum) session.getAttribute("rb");
        SetAttributes.setAttributesOneVacancyPage(rb,request);
        request.setAttribute("oneVacancy", vac);
        return PageConstant.ONE_VACANCY_PAGE;
    }
}
