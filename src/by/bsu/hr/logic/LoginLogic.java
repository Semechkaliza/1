package by.bsu.hr.logic;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.dao.VacancyDAO;
import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LoginLogic {
    private static Logger logger=Logger.getLogger(LoginLogic.class);
    public static List<User> logIn(String login, String pass){
        return UserDAO.findUser(login,pass);
    }

    public static List<Proposal> getProposals(String login) {
        return UserDAO.findProposals(login);
    }
    public static List<Interview> getFutureInterview(String login,String type) {
        return VacancyDAO.findFutureInterview(login,type);
    }
}
