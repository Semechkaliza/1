package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AppointPreviewCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        int user= Integer.parseInt(request.getParameter("user"));
        int vacancy= Integer.parseInt(request.getParameter("vacancy"));

        SetAttributes.setAttributesHRWinnersPage(rb,request);
        return PageConstant.HR_WINNERS_PAGE;
    }
}
