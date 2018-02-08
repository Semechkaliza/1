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
 * Command to go to page with TI, where admin decides future way of candidate.
 */
public class GoHRTechInterviewsFullCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(GoHRTechInterviewsFullCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        List<Interview> resList;
        try {
            resList = HRInterviewLogic.findFullInterviews("TECH");
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error find technical interviews without results");
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("prevList",resList);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.HR_TECH_INTERVIEW_FULL_PAGE;
    }
}
