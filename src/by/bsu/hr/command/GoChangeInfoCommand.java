package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GoChangeInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        ResourseBundle.ResourceBundleEnum rb= (ResourseBundle.ResourceBundleEnum) session.getAttribute("rb");
        request.setAttribute("changeInfo",rb.getMessage("changeInfo"));
        request.setAttribute("name",rb.getMessage("name"));
        request.setAttribute("sname",rb.getMessage("sname"));
        request.setAttribute("phone",rb.getMessage("phone"));
        request.setAttribute("email",rb.getMessage("email"));
        request.setAttribute("apply",rb.getMessage("apply"));
        return PageConstant.CHANGE_INFO_PAGE;
    }
}
