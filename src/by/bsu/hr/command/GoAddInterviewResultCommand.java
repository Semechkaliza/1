package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.GoAddInterviewResultLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GoAddInterviewResultCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int userId= Integer.parseInt(request.getParameter("userId"));
        int vacancyId= Integer.parseInt(request.getParameter("vacancyId"));
        String type=request.getParameter("type");
        Interview info = null;
        try {
            info = GoAddInterviewResultLogic.findInterviewInfo(userId,vacancyId,type);
        } catch (LogicException e) {
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("info",info);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.ADD_INTERVIEW_RESULT_PAGE;
    }
}
