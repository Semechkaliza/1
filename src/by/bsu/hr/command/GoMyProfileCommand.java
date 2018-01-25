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
        String page=MY_PROFILE_PAGE;
        HttpSession session=request.getSession(false);
        ResourseBundle.ResourceBundleEnum rb= (ResourseBundle.ResourceBundleEnum) session.getAttribute("rb");
        request.setAttribute("user",session.getAttribute("user"));
        List<Proposal> proposalList= MyProfileLogic.getProposals(((List<User>) session.getAttribute("user")).get(0).getLogin());
        request.setAttribute("proposalList",proposalList);
        List<Interview> previewList=MyProfileLogic.getFutureInterview(((List<User>) session.getAttribute("user")).get(0).getLogin(),"PREV");
        List<Interview> techList=MyProfileLogic.getFutureInterview(((List<User>) session.getAttribute("user")).get(0).getLogin(),"TECH");
        request.setAttribute("previewList",previewList);
        request.setAttribute("techList",techList);
        request.setAttribute("proposalList",proposalList);
        request.setAttribute("futurePreview",rb.getMessage("futurePreview"));
        request.setAttribute("futureTechInterview",rb.getMessage("futureTechInterview"));
        request.setAttribute("date",rb.getMessage("date"));
        request.setAttribute("time",rb.getMessage("time"));
        request.setAttribute("place",rb.getMessage("place"));
        request.setAttribute("vacancyName",rb.getMessage("vacancyName"));
        request.setAttribute("companyName",rb.getMessage("companyName"));
        request.setAttribute("login",rb.getMessage("login"));
        request.setAttribute("name",rb.getMessage("name"));
        request.setAttribute("sname",rb.getMessage("sname"));
        request.setAttribute("role",rb.getMessage("role"));
        request.setAttribute("rating",rb.getMessage("rating"));
        request.setAttribute("vacancy",rb.getMessage("vacancy"));
        request.setAttribute("welcome",rb.getMessage("welcome"));
        request.setAttribute("LogOut",rb.getMessage("LogOut"));
        request.setAttribute("result",rb.getMessage("result"));
        request.setAttribute("myProfile",rb.getMessage("myProfile"));
        request.setAttribute("myProposal",rb.getMessage("myProposal"));
        request.setAttribute("addProposal",rb.getMessage("addProposal"));
        return page;
    }
}
