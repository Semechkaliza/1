package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.AddWinnerLogic;
import by.bsu.hr.logic.CloseInterviewLogic;
import by.bsu.hr.logic.HRPreviewLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddWinnerCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int userId= Integer.parseInt(request.getParameter("userId"));
        int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
        String type=request.getParameter("type");
        List<Interview> resList=null;
        try {
            AddWinnerLogic.addWinner(userId,vacancyId);
            CloseInterviewLogic.closeInterview(userId,vacancyId,type);
            resList = HRPreviewLogic.findFullPreviews(type);
        } catch (LogicException e) {
            e.printStackTrace();
        }
        request.setAttribute("prevList",resList);
        SetAttributes.setAttributesHRPreviewsFullPage(rb,request);
        if(type.equalsIgnoreCase("TECH")) {
            return PageConstant.HR_TECH_INTERVIEW_FULL_PAGE;
        }else {
            return PageConstant.HR_PREVIEW_FULL_PAGE;
        }
    }
}
