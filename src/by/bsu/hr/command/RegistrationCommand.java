package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.RegistrationLogic;
import by.bsu.hr.logic.Validator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.*;


/**
 * Command to register new user
 */
public class RegistrationCommand implements ActionCommand {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String sname = request.getParameter("sname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        LocaleResourceBundle.ResourceBundleEnum rb;
        switch (Locale.getDefault().toString()) {
            case "ru_RU":
                rb = RU;
                break;
            case "be_BY":
                rb = BE;
                break;
            default:
                rb = EN;
                break;
        }
        if (Validator.registrationValid(login, password, name, sname, phone, email)) {
            if (Validator.registrationInputValid(login, password, email, phone)) {
                User user;
                try {
                    user = RegistrationLogic.registration(login, password, name, sname, phone, email);
                } catch (LogicException e) {
                    logger.log(Level.INFO, "Error registration");
                    return PageConstant.ERROR_PAGE;
                }
                if (user.isActive()) {
                    String lang = request.getParameter("locale");
                    HttpSession session = request.getSession(true);
                    Locale curr = new Locale(lang);
                    switch (lang) {
                        case "ru":
                            rb = RU;
                            break;
                        case "be":
                            rb = BE;
                            break;
                        default:
                            rb = EN;
                            break;
                    }
                    session.setAttribute("locale", curr);
                    session.setAttribute("rb", rb);
                    session.setAttribute("user", user);
                    request.setAttribute("user", user);
                    request.setAttribute("lang", session.getAttribute("locale"));
                    return PageConstant.USER_PROFILE_PAGE;
                } else {
                    request.setAttribute("errorLoginPassMessage", rb.getMessage("message.RepetitiveUser"));
                    request.setAttribute("lang", Locale.getDefault());
                    return PageConstant.REGISTRATION_PAGE;
                }

            } else {
                request.setAttribute("errorLoginPassMessage", rb.getMessage("message.NotValidInfo"));
                request.setAttribute("lang", Locale.getDefault());
                return PageConstant.REGISTRATION_PAGE;
            }
        } else {
            request.setAttribute("errorLoginPassMessage", rb.getMessage("message.NotAllInfo"));
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.REGISTRATION_PAGE;
        }
    }
}
