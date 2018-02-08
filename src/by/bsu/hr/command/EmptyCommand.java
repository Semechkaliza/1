package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.RU;

/**
 * Empty command
 */
public class EmptyCommand implements ActionCommand {
    @Override public String execute(HttpServletRequest request) {
        request.setAttribute("lang",Locale.getDefault());
        return PageConstant.LOGIN_PAGE;
    }
}
