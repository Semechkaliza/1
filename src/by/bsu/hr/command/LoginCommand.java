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

import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.RU;


public class LoginCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(LoginCommand.class);
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String lang=request.getParameter("locale");
        System.out.println(lang);
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String page;
        List<User> resList = LoginLogic.logIn(login,pass);
        if(!resList.isEmpty()){
            HttpSession session=request.getSession(true);
            Locale current=new Locale(lang);
            session.setAttribute("locale",current);
            session.setAttribute("user",resList);
            ResourseBundle.ResourceBundleEnum rb;
            switch(current.toString()){
                case "ru": rb=RU;
                    break;
                case "be": rb=BE;
                    break;
                default:    rb=EN;
                    break;
            }
            session.setAttribute("rb",rb);
            //тут пока везде ничего нет.экспериментируем с sql.
            List<Proposal> proposalList=LoginLogic.getProposals(resList.get(0).getLogin());
            List<Interview> previewList=LoginLogic.getFutureInterview(resList.get(0).getLogin(),"PREV");
            List<Interview> techList=LoginLogic.getFutureInterview(resList.get(0).getLogin(),"TECH");
            request.setAttribute("previewList",previewList);
            request.setAttribute("techList",techList);
            request.setAttribute("proposalList",proposalList);
            request.setAttribute("futurePreview",rb.getMessage("futurePreview"));
            request.setAttribute("futureTechInterview",rb.getMessage("futureTechInterview"));
            request.setAttribute("date",rb.getMessage("date"));
            request.setAttribute("time",rb.getMessage("time"));
            request.setAttribute("place",rb.getMessage("place"));
            request.setAttribute("cancel",rb.getMessage("cancel"));
            request.setAttribute("vacancyName",rb.getMessage("vacancyName"));
            request.setAttribute("companyName",rb.getMessage("companyName"));
            request.setAttribute("login",rb.getMessage("login"));
            request.setAttribute("name",rb.getMessage("name"));
            request.setAttribute("sname",rb.getMessage("sname"));
            request.setAttribute("role",rb.getMessage("role"));
            request.setAttribute("rating",rb.getMessage("rating"));
            request.setAttribute("vacancy",rb.getMessage("vacancy"));
            request.setAttribute("welcome",rb.getMessage("welcome"));
            request.setAttribute("LogOut",rb.getMessage("LogOut"));
            request.setAttribute("user", resList);
            request.setAttribute("result",rb.getMessage("result"));
            request.setAttribute("myProfile",rb.getMessage("myProfile"));
            request.setAttribute("myProposal",rb.getMessage("myProposal"));
            request.setAttribute("addProposal",rb.getMessage("addProposal"));
            request.setAttribute("changeInfo",rb.getMessage("changeInfo"));
            page= PageConstant.MY_PROFILE_PAGE;
        } else {
            ResourseBundle.ResourceBundleEnum rb;
            switch(Locale.getDefault().toString()){
                case "ru_RU": rb=RU;
                    break;
                case "be_BY": rb=BE;
                    break;
                default:    rb=EN;
                    break;
            }
            request.setAttribute("errorLoginPassMessage",rb.getMessage("message.IncorrectInfo"));
            request.setAttribute("login",rb.getMessage("login"));
            request.setAttribute("password",rb.getMessage("password"));
            request.setAttribute("registration",rb.getMessage("registration"));
            request.setAttribute("LogIn",rb.getMessage("LogIn"));
            page = PageConstant.LOGIN_PAGE;
        }
        return page;
    }
}