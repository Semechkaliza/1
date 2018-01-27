package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.AddProposalLogic;
import by.bsu.hr.logic.MyProfileLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddProposalCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        ResourseBundle.ResourceBundleEnum rb= (ResourseBundle.ResourceBundleEnum) session.getAttribute("rb");
        int vacancy_id= Integer.parseInt(request.getParameter("id"));
        int user_id=((List<User>) session.getAttribute("user")).get(0).getUser_id();
        AddProposalLogic.addProposal(vacancy_id,user_id);
        SetAttributes.setAttributesMyProfilePage(rb,request);
        request.setAttribute("user",session.getAttribute("user"));
        List<Proposal> proposalList= MyProfileLogic.getProposals(((List<User>) session.getAttribute("user")).get(0).getLogin());
        request.setAttribute("proposalList",proposalList);
        List<Interview> previewList=MyProfileLogic.getFutureInterview(((List<User>) session.getAttribute("user")).get(0).getLogin(),"PREV");
        List<Interview> techList=MyProfileLogic.getFutureInterview(((List<User>) session.getAttribute("user")).get(0).getLogin(),"TECH");
        request.setAttribute("previewList",previewList);
        request.setAttribute("techList",techList);
        request.setAttribute("proposalList",proposalList);
        return PageConstant.MY_PROFILE_PAGE;
    }
}
