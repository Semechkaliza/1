package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.bsu.hr.command.PageConstant.RESULT_PAGE;

public class ResultCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        ResourseBundle.ResourceBundleEnum rb= (ResourseBundle.ResourceBundleEnum) session.getAttribute("rb");
        request.setAttribute("result",rb.getMessage("result"));
        return RESULT_PAGE;
    }
}
