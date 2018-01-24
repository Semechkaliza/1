package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.RegistrationLogic;
import by.bsu.hr.logic.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.RU;


public class RegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String sname=request.getParameter("sname");
        String page;
        ResourseBundle.ResourceBundleEnum rb;
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
                request.setAttribute("login",rb.getMessage("login"));
                request.setAttribute("name",rb.getMessage("name"));
                request.setAttribute("sname",rb.getMessage("sname"));
                request.setAttribute("role",rb.getMessage("role"));
                request.setAttribute("rating",rb.getMessage("rating"));
                request.setAttribute("vacancy",rb.getMessage("vacancy"));
                request.setAttribute("welcome",rb.getMessage("welcome"));
                request.setAttribute("LogOut",rb.getMessage("LogOut"));
                request.setAttribute("user", resList);
                request.setAttribute("result",rb.getMessage("result"));
                request.setAttribute("myProfile",rb.getMessage("myProfile"));
                page= PageConstant.MY_PROFILE_PAGE;
            } else {
                request.setAttribute("errorLoginPassMessage",rb.getMessage("message.RepetitiveUser"));
                request.setAttribute("registration",rb.getMessage("registration"));
                request.setAttribute("yes",rb.getMessage("yes"));
                request.setAttribute("no",rb.getMessage("no"));
                request.setAttribute("login",rb.getMessage("login"));
                request.setAttribute("password",rb.getMessage("password"));
                request.setAttribute("name",rb.getMessage("name"));
                request.setAttribute("sname",rb.getMessage("sname"));
                page = PageConstant.LOGIN_PAGE;
            }
        }else{
            request.setAttribute("errorLoginPassMessage",rb.getMessage("message.NotAllInfo"));
            request.setAttribute("registration",rb.getMessage("registration"));
            request.setAttribute("yes",rb.getMessage("yes"));
            request.setAttribute("no",rb.getMessage("no"));
            request.setAttribute("login",rb.getMessage("login"));
            request.setAttribute("password",rb.getMessage("password"));
            request.setAttribute("name",rb.getMessage("name"));
            request.setAttribute("sname",rb.getMessage("sname"));
            page = PageConstant.LOGIN_PAGE;
        }
        return page;
    }
}
