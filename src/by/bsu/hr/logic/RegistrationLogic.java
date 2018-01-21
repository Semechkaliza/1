package by.bsu.hr.logic;

import by.bsu.hr.command.PageConstant;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RegistrationLogic {
    public static List<User> registraton(String login,String password,String name,String sname){
        List<User> resList=null;
            if (UserDAO.checkUser(login)) {
                resList= UserDAO.findUser(login,password);
                User res=new User();
                res.setLogin(login);
                res.setPassword(password);
                res.setName(name);
                res.setSname(sname);
                res.setRole("USER");
                res.setRating(0);
                resList.add(res);
                UserDAO.add(login,password,name,sname);
            }
        return resList;
    }
}
