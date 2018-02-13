package by.bsu.hr.command;

import by.bsu.hr.entity.User;
import by.bsu.hr.logic.DeleteUserLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.RU;

/**
 * Command to delete profile
 */
public class DeleteUserCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(DeleteUserCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null){
            try {
                DeleteUserLogic.deleteUser(((User)session.getAttribute("user")).getUserId());
            } catch (LogicException e) {
                logger.log(Level.INFO,"Error delete user");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("lang",Locale.getDefault());
            session.invalidate();
            return PageConstant.LOGIN_PAGE;
        }else{
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
        }

}
