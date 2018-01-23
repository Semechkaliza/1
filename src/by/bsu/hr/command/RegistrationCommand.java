package by.bsu.hr.command;

import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.RegistrationLogic;
import by.bsu.hr.logic.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class RegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String sname=request.getParameter("sname");
        String page;
        Locale current=Locale.getDefault();
        ResourceBundle rb=ResourceBundle.getBundle("resources.text",current);
        if(Validator.registrationValid(login,password,name,sname)){
            List<User> resList=RegistrationLogic.registraton(login,password,name,sname);
            if (!(resList==null)) {
                request.setAttribute("login",rb.getString("login"));
                request.setAttribute("name",rb.getString("name"));
                request.setAttribute("sname",rb.getString("sname"));
                request.setAttribute("role",rb.getString("role"));
                request.setAttribute("rating",rb.getString("rating"));
                request.setAttribute("vacancy",rb.getString("vacancy"));
                request.setAttribute("welcome",rb.getString("welcome"));
                request.setAttribute("LogOut",rb.getString("LogOut"));
                request.setAttribute("main",rb.getString("main"));
                request.setAttribute("user", resList);
                page= PageConstant.MAIN_PAGE;
            } else {
                request.setAttribute("errorLoginPassMessage",rb.getString("message.RepetitiveUser"));
                request.setAttribute("registration",rb.getString("registration"));
                request.setAttribute("yes",rb.getString("yes"));
                request.setAttribute("no",rb.getString("no"));
                request.setAttribute("login",rb.getString("login"));
                request.setAttribute("password",rb.getString("password"));
                request.setAttribute("name",rb.getString("name"));
                request.setAttribute("sname",rb.getString("sname"));
                page = PageConstant.REGISTRATION_PAGE;
            }
        }else{
            request.setAttribute("errorLoginPassMessage",rb.getString("message.NotAllInfo"));
            request.setAttribute("registration",rb.getString("registration"));
            request.setAttribute("yes",rb.getString("yes"));
            request.setAttribute("no",rb.getString("no"));
            request.setAttribute("login",rb.getString("login"));
            request.setAttribute("password",rb.getString("password"));
            request.setAttribute("name",rb.getString("name"));
            request.setAttribute("sname",rb.getString("sname"));
            page = PageConstant.REGISTRATION_PAGE;
        }
        return page;
    }
}
