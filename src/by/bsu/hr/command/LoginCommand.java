package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.LoginLogic;
import by.bsu.hr.logic.UserProfileLogic;
import by.bsu.hr.logic.Validator;
import org.apache.log4j.Level;
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
        logger.log(Level.INFO,"Error login");
        String lang=request.getParameter("locale");
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        User user;
        try {
            user = LoginLogic.logIn(login,pass);
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error login");
            return PageConstant.ERROR_PAGE;
        }
        if(user.getLogin()!=null){
            HttpSession session=request.getSession(true);
            Locale current=new Locale(lang);
            session.setAttribute("locale",current);
            session.setAttribute("user",user);
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
            if(Validator.isUser(session)){
                List<Proposal> proposalList;
                List<Interview> previewList;
                List<Interview> techList;
                try {
                    proposalList = UserProfileLogic.getProposals(user.getUserId());
                    previewList= UserProfileLogic.getFutureInterview(user.getUserId(),"PREV",(Locale)session.getAttribute("locale"));
                    techList=UserProfileLogic.getFutureInterview(user.getUserId(),"TECH",(Locale)session.getAttribute("locale"));
                } catch (LogicException e) {
                    logger.log(Level.INFO,"Error find info for user profile");
                   return PageConstant.ERROR_PAGE;
                }
                request.setAttribute("previewList",previewList);
                request.setAttribute("techList",techList);
                request.setAttribute("proposalList",proposalList);
                request.setAttribute("user", user);
                request.setAttribute("lang",session.getAttribute("locale"));
                return PageConstant.USER_PROFILE_PAGE;
            }else{
                request.setAttribute("user", user);
                request.setAttribute("lang",session.getAttribute("locale"));
                return PageConstant.HR_PROFILE_PAGE;
            }
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
            request.setAttribute("lang",Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
    }
}