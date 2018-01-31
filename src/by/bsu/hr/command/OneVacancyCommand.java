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
            e.printStackTrace();
        }
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        SetAttributes.setAttributesOneVacancyPage(rb,request);
        request.setAttribute("oneVacancy", vac);
        return PageConstant.ONE_VACANCY_PAGE;
    }
}
