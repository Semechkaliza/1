package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.HRInterviewLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoHRTechInterviewsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        List<Interview> resList= null;
        try {
            resList = HRInterviewLogic.findInterviews("TECH");
        } catch (LogicException e) {
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("prevList",resList);
        SetAttributes.setAttributesHRInterviewsPage(rb,request);
        return PageConstant.HR_TECH_INTERVIEWS_PAGE;
    }
}
