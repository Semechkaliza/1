package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GoAddVacancyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        SetAttributes.setAttributesAddVacancyPage(rb,request);
        return PageConstant.ADD_VACANCY_PAGE;
    }
}
