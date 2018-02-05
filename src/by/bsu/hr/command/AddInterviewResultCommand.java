package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.AddInterviewResultLogic;
import by.bsu.hr.logic.HRInterviewLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddInterviewResultCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(AddInterviewResultCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int userId= Integer.parseInt(request.getParameter("userId"));
        int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
        String type=request.getParameter("type");
        int mark= Integer.parseInt(request.getParameter("mark"));
        String feedback=request.getParameter("feedback");
        List<Interview> resList;
        try {
            AddInterviewResultLogic.addResult(userId,vacancyId,type,mark,feedback);
            resList = HRInterviewLogic.findInterviews(type);
        } catch ( LogicException e) {
            logger.log(Level.INFO,"Error add interview result");
            return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("prevList",resList);
        request.setAttribute("lang",session.getAttribute("locale"));
        if(type.equalsIgnoreCase("PREV")) return PageConstant.HR_PREVIEWS_PAGE;
        else return PageConstant.HR_TECH_INTERVIEWS_PAGE;
    }
}
