package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.User;
import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.CloseVacancyLogic;
import by.bsu.hr.logic.GetVacanciesLogic;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.ResultLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.bsu.hr.command.GetVacanciesCommand.PAGE_SIZE;
import static by.bsu.hr.command.PageConstant.RESULT_PAGE;

public class CloseVacancyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int vacancyId= Integer.parseInt(request.getParameter("id"));
        List<Vacancy> resList = null;
        try {
            CloseVacancyLogic.closeVacancy(vacancyId);
            resList = GetVacanciesLogic.getAllVacancies(0,PAGE_SIZE);
            request.setAttribute("page",1);
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
