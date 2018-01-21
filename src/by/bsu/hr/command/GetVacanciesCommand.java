package by.bsu.hr.command;

import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.GetVacanciesLogic;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetVacanciesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        List<Vacancy> resList = GetVacanciesLogic.getAllVacancies();
        if (!resList.isEmpty()) {
            request.setAttribute("vacancy", resList);
            page = PageConstant.VACANCY_PAGE;
        } else {
            page = PageConstant.LOGIN_PAGE;
        }
        return page;
    }
}
