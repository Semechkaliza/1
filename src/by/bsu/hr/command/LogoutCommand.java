package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.RU;

public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String  page= PageConstant.LOGIN_PAGE;
        ResourseBundle.ResourceBundleEnum rb;
        switch(Locale.getDefault().toString()){
            case "ru_RU": rb=RU;
                break;
            case "be_BY": rb=BE;
                break;
            default:    rb=EN;
                break;
        }
        request.setAttribute("login",rb.getMessage("login"));
        request.setAttribute("password",rb.getMessage("password"));
        request.setAttribute("registration",rb.getMessage("registration"));
        request.setAttribute("LogIn",rb.getMessage("LogIn"));
        request.getSession().invalidate();
        return page;
    }
}