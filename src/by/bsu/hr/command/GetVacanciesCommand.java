package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.GetVacanciesLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Command to get the list of all active vacancies
 */
public class GetVacanciesCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(CancelProposalCommand.class);
    static final int PAGE_SIZE=2;
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        List<Vacancy> resList;
        int fromId;
        int page= Integer.parseInt(request.getParameter("page"));
        String direction=request.getParameter("direction");
        switch (direction){
            case "next":{
                page++;
                break;
            }
            case "prev":{
                if(page!=1){
                    page--;
                }
            }
        }
        try {
            fromId=(page-1)*PAGE_SIZE;
            resList = GetVacanciesLogic.getAllVacancies(fromId,PAGE_SIZE);
            if(resList.isEmpty()){
                if(page!=1){
                    page--;
                    fromId=(page-1)*PAGE_SIZE;
                    resList=GetVacanciesLogic.getAllVacancies(fromId,PAGE_SIZE);
                    request.setAttribute("vacanciesList", resList);
                }else{
                    request.setAttribute("emptyVacanciesList",rb.getMessage("message.emptyVacanciesList"));
                }
            }else{
                request.setAttribute("vacanciesList", resList);
            }
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error get vacancies");
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("page",page);
        User user= (User) session.getAttribute("user");
        request.setAttribute("lang",session.getAttribute("locale"));
        if(user.getRole().equalsIgnoreCase("ADMIN")){
            return PageConstant.HR_VACANCY_PAGE;
        }else {
            return PageConstant.VACANCY_PAGE;
        }
    }
}
