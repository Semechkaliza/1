package by.bsu.hr.logic;

import by.bsu.hr.command.PageConstant;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RegistrationLogic {
    public static String registraton(HttpServletRequest request){
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String sname=request.getParameter("sname");
        String page = null;
        System.out.println(login);
        System.out.println(name);
        System.out.println(sname);
        if(Validator.registrationValid(login,password,name,sname)){
            if (UserDAO.checkUser(login)) {
                List resList= UserDAO.findUser(login,password);
                User res=new User();
                res.setLogin(login);
                res.setPassword(password);
                res.setName(name);
                res.setSname(sname);
                res.setRole("USER");
                res.setRating(0);
                resList.add(res);
                UserDAO.add(login,password,name,sname);
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
