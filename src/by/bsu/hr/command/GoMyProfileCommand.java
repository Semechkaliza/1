package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.MyProfileLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static by.bsu.hr.command.PageConstant.MY_PROFILE_PAGE;

public class GoMyProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        request.setAttribute("user",session.getAttribute("user"));
        List<Proposal> proposalList= MyProfileLogic.getProposals(((List<User>) session.getAttribute("user")).get(0).getUserId());
        request.setAttribute("proposalList",proposalList);
        List<Interview> previewList=MyProfileLogic.getFutureInterview(((List<User>) session.getAttribute("user")).get(0).getUserId(),"PREV");
        List<Interview> techList=MyProfileLogic.getFutureInterview(((List<User>) session.getAttribute("user")).get(0).getUserId(),"TECH");
        request.setAttribute("previewList",previewList);
        request.setAttribute("techList",techList);
        request.setAttribute("proposalList",proposalList);
        SetAttributes.setAttributesMyProfilePage(rb,request);
        return MY_PROFILE_PAGE;
    }
}
