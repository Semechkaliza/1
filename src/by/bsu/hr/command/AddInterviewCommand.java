package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.logic.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

/**
 * Command to appoint previews and technical interviews by admin
 */
public class AddInterviewCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(AddInterviewCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            LocaleResourceBundle.ResourceBundleEnum rb = (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
            int userId = Integer.parseInt(request.getParameter("userId"));
            int vacancyId = Integer.parseInt(request.getParameter("vacancyId"));
            String type = request.getParameter("type");
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String place = request.getParameter("place");
            List<Proposal> resList;
            List<Interview> prevList;
            Interview info;
            Date dateSQL;
            Time timeSQL;
            if(Validator.dateValid(date)&&Validator.timeValid(time)){
                try{
                    dateSQL=AddInterviewLogic.getDateSQL(date);
                    timeSQL=AddInterviewLogic.getTimeSQL(time);
                }catch (DateTimeParseException e){
                    logger.log(Level.INFO,"Error parse date and time");
                    return PageConstant.ERROR_PAGE;
                }
            }else {
                try {
                    info = GoAppointPreviewLogic.findInfoToInterview(vacancyId,userId);
                } catch (LogicException e1) {
                    logger.log(Level.INFO,"Error find info about interview");
                    return PageConstant.ERROR_PAGE;
                }
                info.setType(type);
                request.setAttribute("info",info);
                request.setAttribute("errorParse",rb.getMessage("errorParse"));
                request.setAttribute("lang",session.getAttribute("locale"));
                return PageConstant.APPOINT_PREVIEW_PAGE;
            }

            try {
                AddInterviewLogic.addInterview(userId, vacancyId, dateSQL, timeSQL, place, type);
            } catch (LogicException e) {
                logger.log(Level.INFO,"Error add interview");
                return PageConstant.ERROR_PAGE;
            }
            try {
                if (type.equalsIgnoreCase("PREV")) {
                    resList = HRProposalsLogic.getProposals();
                    request.setAttribute("propList", resList);
                    request.setAttribute("lang",session.getAttribute("locale"));
                    return PageConstant.HR_PROPOSALS_PAGE;
                } else {
                    prevList = HRInterviewLogic.findFullInterviews("PREV");
                    request.setAttribute("prevList", prevList);
                    request.setAttribute("lang",session.getAttribute("locale"));
                    return PageConstant.HR_PREVIEW_FULL_PAGE;
                }
            }catch (LogicException e){
                logger.log(Level.INFO,"Error find all interviews");
                return PageConstant.ERROR_PAGE;
            }
        }else {
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
        }

}
