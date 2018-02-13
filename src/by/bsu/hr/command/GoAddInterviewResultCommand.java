package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.GoAddInterviewResultLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Command to go to add result of interview page
 */
public class GoAddInterviewResultCommand implements ActionCommand {
    private static Logger logger = Logger.getLogger(GoAddInterviewResultCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") != null) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int vacancyId = Integer.parseInt(request.getParameter("vacancyId"));
            String type = request.getParameter("type");
            Interview info;
            try {
                info = GoAddInterviewResultLogic.findInterviewInfo(userId, vacancyId, type);
            } catch (LogicException e) {
                logger.log(Level.INFO, "Error find info about interview");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("info", info);
            request.setAttribute("lang", session.getAttribute("locale"));
            return PageConstant.ADD_INTERVIEW_RESULT_PAGE;
        } else {
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
    }

}
