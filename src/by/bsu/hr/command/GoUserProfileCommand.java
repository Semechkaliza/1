package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.UserProfileLogic;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Locale;

import static by.bsu.hr.command.PageConstant.USER_PROFILE_PAGE;

public class GoUserProfileCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(GoUserProfileCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        request.setAttribute("user",session.getAttribute("user"));
        List<Proposal> proposalList;
        List<Interview> previewList;
        List<Interview> techList;
        try {
            proposalList = UserProfileLogic.getProposals(((User)session.getAttribute("user")).getUserId());
            previewList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"PREV", (Locale) session.getAttribute("locale"));
            techList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"TECH",(Locale)session.getAttribute("locale"));
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error find info to user profile");
            return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("proposalList",proposalList);
        request.setAttribute("previewList",previewList);
        request.setAttribute("techList",techList);
        request.setAttribute("lang",session.getAttribute("locale"));
        return USER_PROFILE_PAGE;
    }
}
