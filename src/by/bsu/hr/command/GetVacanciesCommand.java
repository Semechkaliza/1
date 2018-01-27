package by.bsu.hr.command;

import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.GetVacanciesLogic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetVacanciesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        List<Vacancy> resList = GetVacanciesLogic.getAllVacancies();
        HttpSession session=request.getSession(false);
        ResourseBundle.ResourceBundleEnum rb= (ResourseBundle.ResourceBundleEnum) session.getAttribute("rb");
        if (!resList.isEmpty()) {
            SetAttributes.setAttributesVacancyPage(rb,request);
            request.setAttribute("vacanciesList", resList);
            page = PageConstant.VACANCY_PAGE;
        } else {
            request.setAttribute("emptyVacanciesList",rb.getMessage("message.emptyVacanciesList"));
            request.setAttribute("LogOut",rb.getMessage("LogOut"));
            page = PageConstant.VACANCY_PAGE;
        }
        return page;
    }
}
