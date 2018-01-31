package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.HRPreviewLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoHRTechInterviewsFullCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        List<Interview> resList= null;
        try {
            resList = HRPreviewLogic.findFullPreviews("TECH");
        } catch (LogicException e) {
            e.printStackTrace();
        }
        request.setAttribute("prevList",resList);
        SetAttributes.setAttributesHRPreviewsFullPage(rb,request);
        return PageConstant.HR_TECH_INTERVIEW_FULL_PAGE;
    }
}
