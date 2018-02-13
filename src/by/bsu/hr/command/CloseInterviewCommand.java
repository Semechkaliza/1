package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.CloseInterviewLogic;
import by.bsu.hr.logic.HRInterviewLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Command to close preview and TI by admin after decision-making
 */
public class CloseInterviewCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(CancelProposalCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null){
            int userId= Integer.parseInt(request.getParameter("userId"));
            int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
            String type=request.getParameter("type");
            List<Interview> resList;
            try {
                CloseInterviewLogic.closeInterview(userId,vacancyId,type);
                resList = HRInterviewLogic.findFullInterviews(type);
            } catch (LogicException e) {
                logger.log(Level.INFO,"Error close interview");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("prevList",resList);
            request.setAttribute("lang",session.getAttribute("locale"));
            if(type.equalsIgnoreCase("TECH")) {
                return PageConstant.HR_TECH_INTERVIEW_FULL_PAGE;
            }else {
                return PageConstant.HR_PREVIEW_FULL_PAGE;
            }
        }else{
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
        }

}
