package by.bsu.hr.command;

import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.RegistrationLogic;
import by.bsu.hr.logic.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class RegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String sname=request.getParameter("sname");
        String page;
        if(Validator.registrationValid(login,password,name,sname)){
            List<User> resList=RegistrationLogic.registraton(login,password,name,sname);
            if (!(resList==null)) {
                request.setAttribute("user", resList);
                page= PageConstant.MAIN_PAGE;
            } else {
                request.setAttribute("errorLoginPassMessage","There is such user.Try other login.");
                page = PageConstant.REGISTRATION_PAGE;
            }
        }else{
            request.setAttribute("errorLoginPassMessage","Enter all information.");
            page = PageConstant.REGISTRATION_PAGE;
        }
        return page;
    }
}
