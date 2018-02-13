package by.bsu.hr.command;

import by.bsu.hr.logic.AddAdminLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Command to make user with role "user" to "admin". All his proposals and interviews will be delete.
 */
public class AddAdminCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(AddAdminCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null){
            LocaleResourceBundle.ResourceBundleEnum rb = (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
            String login=request.getParameter("login");
            try {
                if(AddAdminLogic.checkLogin(login)){
                    AddAdminLogic.addAdmin(login);
                    request.setAttribute("errorMessage",rb.getMessage("message.goodLoginAdmin"));
                }else{
                    request.setAttribute("errorMessage",rb.getMessage("message.errorLoginAdmin"));
                }
            } catch (LogicException e) {
                logger.log(Level.INFO,"Error find info about interview");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("user",session.getAttribute("user"));
            request.setAttribute("lang",session.getAttribute("locale"));
            return PageConstant.HR_PROFILE_PAGE;
        }else{
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
        }

}
