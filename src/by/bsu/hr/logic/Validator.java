package by.bsu.hr.logic;

import by.bsu.hr.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * All validators
 */
public class Validator {
    /**
     * @param login
     * @param pass
     * @param name
     * @param sname
     * @param phone
     * @param email
     * @return boolean
     * Validator of not empty data
     */
    public static boolean registrationValid(String login, String pass, String name, String sname, String phone, String email){
        return !login.isEmpty() && !pass.isEmpty() && !name.isEmpty() && !sname.isEmpty() && !phone.isEmpty() && !email.isEmpty();
    }

    /**
     * @param session
     * @return boolean
     * Check if the role is equals 'user'
     */
    public static boolean isUser(HttpSession session){
        return ((User) session.getAttribute("user")).getRole().equalsIgnoreCase("user");
    }

    /**
     * @param vacancy
     * @param company
     * @return boolean
     * Check if vacancy and company in add new vacancy are empty
     */
    public static boolean validVacancy(String vacancy, String company) {
        return !vacancy.isEmpty() && !company.isEmpty();
    }

    /**
     * Check if date format true
     * @param date
     * @return boolean
     */
    public static boolean dateValid(String date) {
        Pattern pattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    /**
     * Check if time format is true
     * @param time
     * @return boolean
     */
    public static boolean timeValid(String time) {
        Pattern pattern24 = Pattern.compile("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$");
        Pattern pattern12=Pattern.compile("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(AM|PM)");
        Matcher matcher24 = pattern24.matcher(time);
        Matcher matcher12=pattern12.matcher(time);
        return (matcher24.matches()||matcher12.matches());
    }

    /**
     * Check if 0 less than mark less than 10
     * @param mark
     * @return boolean
     */
    public static boolean markValid(String mark) {
        Pattern pattern=Pattern.compile("[0-9]|10");
        Matcher matcher=pattern.matcher(mark);
        return matcher.matches();
    }
}
