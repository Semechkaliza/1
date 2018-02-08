package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.HRInterviewLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Command to go to page, where admin add results of TI
 */
public class GoHRTechInterviewsCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(GoHRTechInterviewsCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        List<Interview> resList;
        try {
            resList = HRInterviewLogic.findInterviews("TECH");
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error find technical interviews");
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("prevList",resList);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.HR_TECH_INTERVIEWS_PAGE;
    }
}
