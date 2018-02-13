package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.GoAppointPreviewLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Command to go to appint interview page
 */
public class GoAppointInterviewCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(CancelProposalCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null){
            int userId= Integer.parseInt(request.getParameter("userId"));
            int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
            String type=request.getParameter("type");
            Interview info;
            try {
                info = GoAppointPreviewLogic.findInfoToInterview(vacancyId,userId);
                info.setType(type);
            } catch (LogicException e) {
                logger.log(Level.INFO,"Error find info to interview");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("info",info);
            request.setAttribute("lang",session.getAttribute("locale"));
            return PageConstant.APPOINT_PREVIEW_PAGE;
        }else{
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
        }

}
