package by.bsu.hr.logic;

import by.bsu.hr.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public class Validator {
    public static boolean registrationValid(String login,String pass,String name,String sname){
        if(login.isEmpty()||pass.isEmpty()||name.isEmpty()||sname.isEmpty())
            return false;
        else return true;
    }
    public static boolean isUser(HttpSession session){
       if(((User)session.getAttribute("user")).getRole().equalsIgnoreCase("user"))
           return true;
           else return false;
    }
}
