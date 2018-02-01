package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.logic.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.format.DateTimeParseException;
import java.util.List;

public class AddInterviewCommand implements ActionCommand {
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
        Interview info=null;
        try {
            AddInterviewLogic.addInterview(userId, vacancyId, date, time, place, type);
        } catch (DateTimeParseException | LogicException e) {
            System.out.println("catch");
            e.printStackTrace();//message & return appointPreview
            try {
                info = GoAppointPreviewLogic.findInfoToInterview(vacancyId,userId);
            } catch (LogicException e1) {
                e1.printStackTrace();
            }
            info.setType(type);
            request.setAttribute("info",info);
            SetAttributes.setAttributesHRInterviewsPage(rb,request);
            return PageConstant.APPOINT_PREVIEW_PAGE;
        }
        try {
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
                SetAttributes.setAttributesHRInterviewsFullPage(rb, request);
                return PageConstant.HR_PREVIEW_FULL_PAGE;
            }
        }catch (LogicException e){
            //
        }

        SetAttributes.setAttributesHRProposalsPage(rb, request);
        return PageConstant.HR_PROPOSALS_PAGE;
    }
}
