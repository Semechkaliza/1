package by.bsu.hr.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.RU;

public class GoRegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        ResourseBundle.ResourceBundleEnum lang;
        switch(Locale.getDefault().toString()){
            case "ru_RU": lang=RU;
                break;
            case "be_BY": lang=BE;
                break;
            default:    lang=EN;
                break;
        }
        SetAttributes.setAttributesRegistrationPage(lang,request);
        return PageConstant.REGISTRATION_PAGE;
    }
}
