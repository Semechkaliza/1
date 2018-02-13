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
 * Command to go to page with previews, where admin decides future way of candidate.
 */
public class GoHRPreviewsFullCommand implements ActionCommand {
    private static Logger logger = Logger.getLogger(GoHRPreviewsFullCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            List<Interview> resList;
            try {
                resList = HRInterviewLogic.findFullInterviews("PREV");
            } catch (LogicException e) {
                logger.log(Level.INFO, "Error find previews without results");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("prevList", resList);
            request.setAttribute("lang", session.getAttribute("locale"));
            return PageConstant.HR_PREVIEW_FULL_PAGE;
        } else {
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
    }

}
