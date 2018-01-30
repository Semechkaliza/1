package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.logic.AddPreviewLogic;
import by.bsu.hr.logic.GoAppointPreviewLogic;
import by.bsu.hr.logic.HRProposalsLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class AddPreviewCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int userId= Integer.parseInt(request.getParameter("userId"));
        int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
        int proposalId= Integer.parseInt(request.getParameter("proposalId"));
        String date= request.getParameter("date");
        String time=request.getParameter("time");
        String place=request.getParameter("place");
        try {
            AddPreviewLogic.addPreview(userId,vacancyId,date,time,place,proposalId);
        } catch (ParseException e) {
            e.printStackTrace();//message & return appointPreview
        }
        List<Proposal> resList= HRProposalsLogic.getProposals();
        request.setAttribute("propList",resList);
        SetAttributes.setAttributesHRProposalsPage(rb,request);
        return PageConstant.HR_PROPOSALS_PAGE;
    }
}
