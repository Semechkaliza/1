package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.AddInterviewResultLogic;
import by.bsu.hr.logic.HRPreviewLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddInterviewResultCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int userId= Integer.parseInt(request.getParameter("userId"));
        int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
        String type=request.getParameter("type");
        int mark= Integer.parseInt(request.getParameter("mark"));
        String feedback=request.getParameter("feedback");
        List<Interview> resList= null;
        try {
            AddInterviewResultLogic.addResult(userId,vacancyId,type,mark,feedback);
            resList = HRPreviewLogic.findPreviews(type);
        } catch ( LogicException e) {
            e.printStackTrace();//message & return appointPreview
        }
        request.setAttribute("prevList",resList);
        SetAttributes.setAttributesHRInterviewsPage(rb,request);
        if(type.equalsIgnoreCase("PREV")) return PageConstant.HR_PREVIEWS_PAGE;
        else return PageConstant.HR_TECH_INTERVIEWS_PAGE;
    }
}
