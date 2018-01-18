package by.bsu.hr.logic;

import by.bsu.hr.command.PageConstant;
import by.bsu.hr.dao.VacancyDAO;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetVacanciesLogic {
    public static String getAllVacancies(HttpServletRequest request) {
            String page = null;
            List resList = VacancyDAO.getAllVacancies();
                if (!resList.isEmpty()) {
                    request.setAttribute("vacancy", resList);
                    System.out.println(resList);
                    page = PageConstant.VACANCY_PAGE;
                } else {
                    page = PageConstant.LOGIN_PAGE;
                }
            return page;
    }
}
