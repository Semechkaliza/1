package by.bsu.hr.command;

import by.bsu.hr.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.bsu.hr.command.PageConstant.MY_PROFILE_PAGE;

public class GoMyProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page=MY_PROFILE_PAGE;
        HttpSession session=request.getSession(false);
        ResourseBundle.ResourceBundleEnum rb= (ResourseBundle.ResourceBundleEnum) session.getAttribute("rb");
        request.setAttribute("user",session.getAttribute("user"));
        request.setAttribute("login",rb.getMessage("login"));
        request.setAttribute("name",rb.getMessage("name"));
        request.setAttribute("sname",rb.getMessage("sname"));
        request.setAttribute("role",rb.getMessage("role"));
        request.setAttribute("rating",rb.getMessage("rating"));
        request.setAttribute("vacancy",rb.getMessage("vacancy"));
        request.setAttribute("welcome",rb.getMessage("welcome"));
        request.setAttribute("LogOut",rb.getMessage("LogOut"));
        //   request.setAttribute("main",rb.getMessage("main"));
        request.setAttribute("result",rb.getMessage("result"));
        request.setAttribute("myProfile",rb.getMessage("myProfile"));
        return page;
    }
}
