package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.HRInterviewLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Command to go to page, where admin add previews results.
 */
public class GoHRPreviewsCommand implements ActionCommand {
    private static Logger logger = Logger.getLogger(GoHRPreviewsCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            List<Interview> resList;
            try {
                resList = HRInterviewLogic.findInterviews("PREV");
            } catch (LogicException e) {
                logger.log(Level.INFO, "Error find previews");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("prevList", resList);
            request.setAttribute("lang", session.getAttribute("locale"));
            return PageConstant.HR_PREVIEWS_PAGE;
        } else {
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
    }

}
