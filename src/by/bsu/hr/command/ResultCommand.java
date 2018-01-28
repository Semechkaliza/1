package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.bsu.hr.command.PageConstant.RESULT_PAGE;

public class ResultCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        SetAttributes.setAttributesResultPage(rb,request);
        return RESULT_PAGE;
    }
}
