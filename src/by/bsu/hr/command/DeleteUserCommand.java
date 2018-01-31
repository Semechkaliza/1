package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.DeleteUserLogic;
import by.bsu.hr.logic.LogicException;

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
        try {
            DeleteUserLogic.deleteUser(((User)session.getAttribute("user")).getUserId());
        } catch (LogicException e) {
            e.printStackTrace();
        }
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
