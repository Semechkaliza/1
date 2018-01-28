package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GoHRProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        request.setAttribute("user",session.getAttribute("user"));
        SetAttributes.setAttributesHRProfilePage(rb,request);
        return PageConstant.HR_PROFILE_PAGE;
    }
}
