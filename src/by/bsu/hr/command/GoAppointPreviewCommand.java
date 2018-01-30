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
        int proposalId= Integer.parseInt(request.getParameter("proposalId"));
        Interview info = GoAppointPreviewLogic.findInfoToPreview(proposalId);
        request.setAttribute("info",info);
        request.setAttribute("proposalId",proposalId);
        SetAttributes.setAttributesAppointPreviewPage(rb,request);
        return PageConstant.APPOINT_PREVIEW_PAGE;
    }
}
