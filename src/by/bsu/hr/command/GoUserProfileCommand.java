package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.UserProfileLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Locale;

import static by.bsu.hr.command.PageConstant.USER_PROFILE_PAGE;

public class GoUserProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        request.setAttribute("user",session.getAttribute("user"));
        List<Proposal> proposalList= null;
        List<Interview> previewList=null;
        List<Interview> techList=null;
        try {
            proposalList = UserProfileLogic.getProposals(((User)session.getAttribute("user")).getUserId());
            previewList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"PREV", (Locale) session.getAttribute("locale"));
            techList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"TECH",(Locale)session.getAttribute("locale"));
        } catch (LogicException e) {
            return PageConstant.ERROR_PAGE;
        }
       request.setAttribute("proposalList",proposalList);
        request.setAttribute("previewList",previewList);
        request.setAttribute("techList",techList);
        request.setAttribute("proposalList",proposalList);
        request.setAttribute("lang",session.getAttribute("locale"));
        return USER_PROFILE_PAGE;
    }
}
