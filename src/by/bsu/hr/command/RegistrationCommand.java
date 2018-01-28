package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.RegistrationLogic;
import by.bsu.hr.logic.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
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
        String page;
        LocaleResourceBundle.ResourceBundleEnum rb;
        switch(Locale.getDefault().toString()){
            case "ru_RU": rb=RU;
                break;
            case "be_BY": rb=BE;
                break;
            default:    rb=EN;
                break;
        }
      //  Locale current=Locale.getDefault();
     //   ResourceBundle rb=ResourceBundle.getBundle("resources.text",current);
        if(Validator.registrationValid(login,password,name,sname)){
            List<User> resList=RegistrationLogic.registraton(login,password,name,sname);
            if (!(resList==null)) {
                String lang=request.getParameter("locale");
                HttpSession session=request.getSession(true);
                Locale curr=new Locale(lang);
                session.setAttribute("locale",curr);
                switch(curr.toString()){
                    case "ru": rb=RU;
                        break;
                    case "be": rb=BE;
                        break;
                    default:    rb=EN;
                        break;
                }
                session.setAttribute("rb",rb);
                session.setAttribute("user",resList);
                request.setAttribute("user", resList);
                SetAttributes.setAttributesMyProfilePage(rb,request);
                page= PageConstant.MY_PROFILE_PAGE;
            } else {
                request.setAttribute("errorLoginPassMessage",rb.getMessage("message.RepetitiveUser"));
                SetAttributes.setAttributesRegistrationPage(rb,request);
                page = PageConstant.REGISTRATION_PAGE;
            }
        }else{
            request.setAttribute("errorLoginPassMessage",rb.getMessage("message.NotAllInfo"));
            SetAttributes.setAttributesRegistrationPage(rb,request);
            page = PageConstant.REGISTRATION_PAGE;
        }
        return page;
    }
}
