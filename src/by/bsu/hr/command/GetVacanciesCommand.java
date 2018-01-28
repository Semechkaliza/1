package by.bsu.hr.command;

import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.GetVacanciesLogic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetVacanciesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        List<Vacancy> resList = GetVacanciesLogic.getAllVacancies();
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        if (!resList.isEmpty()) {
            SetAttributes.setAttributesVacancyPage(rb,request);
            request.setAttribute("vacanciesList", resList);
        } else {
            request.setAttribute("emptyVacanciesList",rb.getMessage("message.emptyVacanciesList"));
            request.setAttribute("LogOut",rb.getMessage("LogOut"));
        }
        return PageConstant.VACANCY_PAGE;
    }
}
