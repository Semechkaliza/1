package by.bsu.hr.command;

import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.GetVacanciesLogic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GetVacanciesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        List<Vacancy> resList = GetVacanciesLogic.getAllVacancies();
        HttpSession session=request.getSession(false);
        if (!resList.isEmpty()) {
            ResourceBundle rb=ResourceBundle.getBundle("resources.text", (Locale) session.getAttribute("locale"));
            request.setAttribute("vacancy",rb.getString("vacancy"));
            request.setAttribute("other",rb.getString("other"));
            request.setAttribute("skill",rb.getString("skill"));
            request.setAttribute("salary",rb.getString("salary"));
            request.setAttribute("company",rb.getString("company"));
            request.setAttribute("LogOut",rb.getString("LogOut"));
            request.setAttribute("vacanciesList", resList);
            page = PageConstant.VACANCY_PAGE;
        } else {
            ResourceBundle rb=ResourceBundle.getBundle("resources.text", (Locale) session.getAttribute("locale"));
            request.setAttribute("login",rb.getString("login"));
            request.setAttribute("password",rb.getString("password"));
            request.setAttribute("registration",rb.getString("registration"));
            request.setAttribute("LogIn",rb.getString("LogIn"));
            page = PageConstant.LOGIN_PAGE;
        }
        return page;
    }
}
