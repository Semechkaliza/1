package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.AddVacancyLogic;
import by.bsu.hr.logic.GetVacanciesLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.bsu.hr.command.GetVacanciesCommand.PAGE_SIZE;

public class AddVacancyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        List<Vacancy> resList = null;
        String vacancy=request.getParameter("vacancy");
        String company=request.getParameter("company");
        String salary= request.getParameter("salary");
        String other=request.getParameter("other");
        try {
            AddVacancyLogic.addVacancy(vacancy,company,salary,other);
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
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.HR_VACANCY_PAGE;
    }
}
