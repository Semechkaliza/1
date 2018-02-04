package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.RegistrationLogic;
import by.bsu.hr.logic.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.RU;


public class RegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String sname=request.getParameter("sname");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String page = null;
        LocaleResourceBundle.ResourceBundleEnum rb;
        switch(Locale.getDefault().toString()){
            case "ru_RU": rb=RU;
                break;
            case "be_BY": rb=BE;
                break;
            default:    rb=EN;
                break;
        }
        if(Validator.registrationValid(login,password,name,sname,phone,email)){
            User user= null;
            try {
                user = RegistrationLogic.registraton(login,password,name,sname,phone,email);
            } catch (LogicException e) {
               return PageConstant.ERROR_PAGE;
            }
            if (!(user==null)) {
                String lang=request.getParameter("locale");
                HttpSession session=request.getSession(true);
                Locale curr=new Locale(lang);
                session.setAttribute("locale",curr);
                session.setAttribute("rb",rb);
                session.setAttribute("user",user);
                request.setAttribute("user",user);
                request.setAttribute("lang",session.getAttribute("locale"));
                page= PageConstant.USER_PROFILE_PAGE;
            } else {
                request.setAttribute("errorLoginPassMessage",rb.getMessage("message.RepetitiveUser"));
                request.setAttribute("lang",Locale.getDefault());
                page = PageConstant.REGISTRATION_PAGE;
            }
        }else{
            request.setAttribute("errorLoginPassMessage",rb.getMessage("message.NotAllInfo"));
            request.setAttribute("lang",Locale.getDefault());
            page = PageConstant.REGISTRATION_PAGE;
        }
        return page;
    }
}
