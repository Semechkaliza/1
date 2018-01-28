package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LoginLogic;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.LocaleResourceBundle.ResourceBundleEnum.RU;


public class LoginCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(LoginCommand.class);
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String lang=request.getParameter("locale");
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String page;
        List<User> resList = LoginLogic.logIn(login,pass);
        if(!resList.isEmpty()){
            HttpSession session=request.getSession(true);
            Locale current=new Locale(lang);
            session.setAttribute("locale",current);
            session.setAttribute("user",resList);
            LocaleResourceBundle.ResourceBundleEnum rb;
            switch(current.toString()){
                case "ru": rb=RU;
                    break;
                case "be": rb=BE;
                    break;
                default:    rb=EN;
                    break;
            }
            session.setAttribute("rb",rb);
            List<Proposal> proposalList=LoginLogic.getProposals(resList.get(0).getUserId());
            List<Interview> previewList=LoginLogic.getFutureInterview(resList.get(0).getUserId(),"PREV");
            List<Interview> techList=LoginLogic.getFutureInterview(resList.get(0).getUserId(),"TECH");
            request.setAttribute("previewList",previewList);
            request.setAttribute("techList",techList);
            request.setAttribute("proposalList",proposalList);
            request.setAttribute("user", resList);
            SetAttributes.setAttributesMyProfilePage(rb,request);
            page= PageConstant.MY_PROFILE_PAGE;
        } else {
            LocaleResourceBundle.ResourceBundleEnum rb;
            switch(Locale.getDefault().toString()){
                case "ru_RU": rb=RU;
                    break;
                case "be_BY": rb=BE;
                    break;
                default:    rb=EN;
                    break;
            }
            request.setAttribute("errorLoginPassMessage",rb.getMessage("message.IncorrectInfo"));
            SetAttributes.setAttributesLoginPage(rb,request);
            page = PageConstant.LOGIN_PAGE;
        }
        return page;
    }
}