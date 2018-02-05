package by.bsu.hr.command;

import by.bsu.hr.entity.Proposal;
import by.bsu.hr.logic.HRProposalsLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoHRProposalsCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(GoHRProposalsCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        List<Proposal> resList;
        try {
            resList = HRProposalsLogic.getProposals();
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error find proposals");
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("propList",resList);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.HR_PROPOSALS_PAGE;
    }
}
