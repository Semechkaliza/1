package by.bsu.hr.command;

import by.bsu.hr.entity.Proposal;
import by.bsu.hr.logic.HRProposalsLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoHRProposalsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        List<Proposal> resList= HRProposalsLogic.getProposals();
        request.setAttribute("propList",resList);
        SetAttributes.setAttributesHRProposalsPage(rb,request);
        return PageConstant.HR_PROPOSALS_PAGE;
    }
}
