package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.GoAppointPreviewLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GoAppointInterviewCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        int userId= Integer.parseInt(request.getParameter("userId"));
        int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
        String type=request.getParameter("type");
        Interview info = null;
        try {
            info = GoAppointPreviewLogic.findInfoToInterview(vacancyId,userId);
            info.setType(type);
        } catch (LogicException e) {
            return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("info",info);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.APPOINT_PREVIEW_PAGE;
    }
}
