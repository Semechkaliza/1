package by.bsu.hr.command;

import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.OneVacancyLogic;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OneVacancyCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(OneVacancyCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        int id= Integer.parseInt(request.getParameter("id"));
        Vacancy vac;
        try {
            vac = OneVacancyLogic.getVacancy(id);
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error find vacancy");
            return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("lang",session.getAttribute("locale"));
        request.setAttribute("oneVacancy", vac);
        return PageConstant.ONE_VACANCY_PAGE;
    }
}
