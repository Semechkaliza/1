package by.bsu.hr.command;

import by.bsu.hr.entity.Proposal;
import by.bsu.hr.logic.HRProposalsLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoHRProposalsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        List<Proposal> resList= null;
        try {
            resList = HRProposalsLogic.getProposals();
        } catch (LogicException e) {
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("propList",resList);
        SetAttributes.setAttributesHRProposalsPage(rb,request);
        return PageConstant.HR_PROPOSALS_PAGE;
    }
}
