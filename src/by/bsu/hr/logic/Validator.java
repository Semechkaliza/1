package by.bsu.hr.logic;

import by.bsu.hr.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public class Validator {
    public static boolean registrationValid(String login, String pass, String name, String sname, String phone, String email){
        return !login.isEmpty() && !pass.isEmpty() && !name.isEmpty() && !sname.isEmpty() && !phone.isEmpty() && !email.isEmpty();
    }
    public static boolean isUser(HttpSession session){
        return ((User) session.getAttribute("user")).getRole().equalsIgnoreCase("user");
    }

    public static boolean validVacancy(String vacancy, String company) {
        return !vacancy.isEmpty() && !company.isEmpty();
    }
}
