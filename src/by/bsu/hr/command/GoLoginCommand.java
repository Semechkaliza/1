package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.RU;

public class GoLoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        LocaleResourceBundle.ResourceBundleEnum lang;
        switch(Locale.getDefault().toString()){
            case "ru_RU": lang=RU;
                break;
            case "be_BY": lang=BE;
                break;
            default:    lang=EN;
                break;
        }
        SetAttributes.setAttributesLoginPage(lang,request);
        return PageConstant.LOGIN_PAGE;
    }
}
