package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.GoAppointPreviewLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GoAppointPreviewCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int userId= Integer.parseInt(request.getParameter("userId"));
        int vacancyId = Integer.parseInt(request.getParameter("vacancyId"));
        Interview info = GoAppointPreviewLogic.findInfoToPreview(userId,vacancyId);
        request.setAttribute("info",info);
        SetAttributes.setAttributesAppointPreviewPage(rb,request);
        return PageConstant.APPOINT_PREVIEW_PAGE;
    }
}
