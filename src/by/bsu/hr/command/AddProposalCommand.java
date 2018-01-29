package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.AddProposalLogic;
import by.bsu.hr.logic.UserProfileLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddProposalCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int vacancyId= Integer.parseInt(request.getParameter("id"));
        int userId=((User)session.getAttribute("user")).getUserId();
        AddProposalLogic.addProposal(vacancyId,userId);
        SetAttributes.setAttributesMyProfilePage(rb,request);
        request.setAttribute("user",session.getAttribute("user"));
        List<Proposal> proposalList= UserProfileLogic.getProposals(((User)session.getAttribute("user")).getUserId());
        request.setAttribute("proposalList",proposalList);
        List<Interview> previewList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"PREV");
        List<Interview> techList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"TECH");
        request.setAttribute("previewList",previewList);
        request.setAttribute("techList",techList);
        request.setAttribute("proposalList",proposalList);
        return PageConstant.USER_PROFILE_PAGE;
    }
}
