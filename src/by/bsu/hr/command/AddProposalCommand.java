package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.AddProposalLogic;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.UserProfileLogic;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

public class AddProposalCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(AddProposalCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int vacancyId= Integer.parseInt(request.getParameter("id"));
        int userId=((User)session.getAttribute("user")).getUserId();
        List<Proposal> proposalList;
        List<Interview> previewList;
        List<Interview> techList;
        try {
            if(AddProposalLogic.checkProposal(vacancyId,userId)){
                AddProposalLogic.addProposal(vacancyId,userId);
            }else{
                request.setAttribute("errorAddProposal",rb.getMessage("message.errorAddProposal"));
            }
            previewList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"PREV", (Locale) session.getAttribute("locale"));
            techList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"TECH",(Locale)session.getAttribute("locale"));
            proposalList = UserProfileLogic.getProposals(((User)session.getAttribute("user")).getUserId());
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error add proposal");
            return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("proposalList",proposalList);
        request.setAttribute("user",session.getAttribute("user"));
        request.setAttribute("previewList",previewList);
        request.setAttribute("techList",techList);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.USER_PROFILE_PAGE;
    }
}
