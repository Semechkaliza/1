package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.User;
import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.CloseVacancyLogic;
import by.bsu.hr.logic.GetVacanciesLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.bsu.hr.command.GetVacanciesCommand.PAGE_SIZE;

public class CloseVacancyCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(CancelProposalCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int vacancyId= Integer.parseInt(request.getParameter("id"));
        List<Vacancy> resList;
        try {
            CloseVacancyLogic.closeVacancy(vacancyId);
            resList = GetVacanciesLogic.getAllVacancies(0,PAGE_SIZE);
            request.setAttribute("page",1);
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error close vacancy");
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
