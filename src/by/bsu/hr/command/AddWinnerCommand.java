package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.AddWinnerLogic;
import by.bsu.hr.logic.CloseInterviewLogic;
import by.bsu.hr.logic.HRInterviewLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddWinnerCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(AddWinnerCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int userId= Integer.parseInt(request.getParameter("userId"));
        int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
        String type=request.getParameter("type");
        List<Interview> resList;
        try {
            AddWinnerLogic.addWinner(userId,vacancyId);
            CloseInterviewLogic.closeInterview(userId,vacancyId,type);
            resList = HRInterviewLogic.findFullInterviews(type);
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error add winner");
            return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("prevList",resList);
        request.setAttribute("lang",session.getAttribute("locale"));
        if(type.equalsIgnoreCase("TECH")) {
            return PageConstant.HR_TECH_INTERVIEW_FULL_PAGE;
        }else {
            return PageConstant.HR_PREVIEW_FULL_PAGE;
        }
    }
}
