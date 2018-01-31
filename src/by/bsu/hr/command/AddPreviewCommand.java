package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.logic.AddInterviewLogic;
import by.bsu.hr.logic.HRPreviewLogic;
import by.bsu.hr.logic.HRProposalsLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class AddPreviewCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb = (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int userId = Integer.parseInt(request.getParameter("userId"));
        int vacancyId = Integer.parseInt(request.getParameter("vacancyId"));
        String type = request.getParameter("type");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String place = request.getParameter("place");
        List<Proposal> resList;
        List<Interview> prevList;
        try {
            AddInterviewLogic.addInterview(userId, vacancyId, date, time, place, type);
            if (type.equalsIgnoreCase("PREV")) {
                System.out.println("at prev");
                resList = HRProposalsLogic.getProposals();
                request.setAttribute("propList", resList);
                SetAttributes.setAttributesHRProposalsPage(rb, request);
                return PageConstant.HR_PROPOSALS_PAGE;
            } else {
                System.out.println("at tech");
                prevList = HRPreviewLogic.findFullPreviews("PREV");
                request.setAttribute("prevList", prevList);
                SetAttributes.setAttributesHRPreviewsFullPage(rb, request);
                return PageConstant.HR_PREVIEW_FULL_PAGE;
            }
        } catch (ParseException | LogicException e) {
            e.printStackTrace();//message & return appointPreview

        }
        SetAttributes.setAttributesHRProposalsPage(rb, request);
        return PageConstant.HR_PROPOSALS_PAGE;
    }
}
