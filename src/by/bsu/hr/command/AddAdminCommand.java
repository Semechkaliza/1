package by.bsu.hr.command;

import by.bsu.hr.logic.AddAdminLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddAdminCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        String login=request.getParameter("login");
        try {
            AddAdminLogic.addAdmin(login);
        } catch (LogicException e) {
            e.printStackTrace();
        }
        request.setAttribute("user",session.getAttribute("user"));
        SetAttributes.setAttributesHRProfilePage(rb,request);
        return PageConstant.HR_PROFILE_PAGE;
    }
}
