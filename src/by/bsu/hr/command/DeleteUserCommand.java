package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.DeleteUserLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.RU;

public class DeleteUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        DeleteUserLogic.deleteUser(((List<User>) session.getAttribute("user")).get(0).getUserId());
        LocaleResourceBundle.ResourceBundleEnum rb;
        switch(Locale.getDefault().toString()){
            case "ru_RU": rb=RU;
                break;
            case "be_BY": rb=BE;
                break;
            default:    rb=EN;
                break;
        }
        SetAttributes.setAttributesLoginPage(rb,request);
        session.invalidate();
        return PageConstant.LOGIN_PAGE;
    }
}
