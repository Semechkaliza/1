package by.bsu.hr.logic;

import by.bsu.hr.entity.User;

import javax.servlet.http.HttpSession;
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
    public static boolean registrationValid(String login, String pass, String name, String sname, String phone, String email) {
        return !login.isEmpty() && !pass.isEmpty() && !name.isEmpty() && !sname.isEmpty() && !phone.isEmpty() && !email.isEmpty();
    }

    /**
     * @param session
     * @return boolean
     * Check if the role is equals 'user'
     */
    public static boolean isUser(HttpSession session) {
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
     *
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
     *
     * @param time
     * @return boolean
     */
    public static boolean timeValid(String time) {
        Pattern pattern24 = Pattern.compile("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$");
        Pattern pattern12 = Pattern.compile("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(AM|PM)");
        Matcher matcher24 = pattern24.matcher(time);
        Matcher matcher12 = pattern12.matcher(time);
        return (matcher24.matches() || matcher12.matches());
    }

    /**
     * Check if 0 less than mark less than 10
     *
     * @param mark
     * @return boolean
     */
    public static boolean markValid(String mark) {
        Pattern pattern = Pattern.compile("[0-9]|10");
        Matcher matcher = pattern.matcher(mark);
        return matcher.matches();
    }

    /**
     * Check correct info in registration
     *
     * @param login
     * @param password
     * @param email
     * @param phone
     * @return boolean
     */
    public static boolean registrationInputValid(String login, String password, String email, String phone) {
        Pattern patternLogin = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{4}[A-Za-z0-9_]{0,}$");
        Pattern patternPass = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}");
        Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        Pattern patternPhone = Pattern.compile("^((9|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcherLogin = patternLogin.matcher(login);
        Matcher matcherPass = patternPass.matcher(password);
        Matcher matcherEmail = patternEmail.matcher(email);
        Matcher matcherPhone = patternPhone.matcher(phone);
        return matcherEmail.matches() && matcherLogin.matches() && matcherPass.matches() && matcherPhone.matches();
    }
}
