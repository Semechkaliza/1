package by.bsu.hr.command;

import by.bsu.hr.entity.Approved;
import by.bsu.hr.logic.GoApprovedLogic;
import by.bsu.hr.logic.HandleApprovedLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Command to close info about approved after that admin phoned/wrote him.
 */
public class HandleApprovedCommand implements ActionCommand {
    private static Logger logger = Logger.getLogger(HandleApprovedCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            int user = Integer.parseInt(request.getParameter("user"));
            int vacancy = Integer.parseInt(request.getParameter("vacancy"));
            List<Approved> resList;
            try {
                HandleApprovedLogic.handleApproved(user, vacancy);
                resList = GoApprovedLogic.findApproved();
            } catch (LogicException e) {
                logger.log(Level.INFO, "Error handle approved");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("winList", resList);
            request.setAttribute("lang", session.getAttribute("locale"));
            return PageConstant.HR_APPROVED_PAGE;
        } else {
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
    }

}
