package by.bsu.hr.command;

import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.GetVacanciesLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoVacanciesHRCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        List<Vacancy> resList;
        try {
            resList = GetVacanciesLogic.getAllVacancies();
        } catch (LogicException e) {
           return PageConstant.ERROR_PAGE;
        }
        if (!resList.isEmpty()) {
            request.setAttribute("vacanciesList", resList);
        } else {
            request.setAttribute("emptyVacanciesList",rb.getMessage("message.emptyVacanciesList"));
        }
        SetAttributes.setAttributesHRVacancyPage(rb,request);
        return PageConstant.HR_VACANCY_PAGE;
    }
}
