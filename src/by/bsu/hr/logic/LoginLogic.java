package by.bsu.hr.logic;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import org.apache.log4j.Logger;
import java.util.List;

public class LoginLogic {
    private static Logger logger=Logger.getLogger(LoginLogic.class);
    public static User logIn(String login, String pass){
        return UserDAO.findUser(login,pass);
    }

    public static List<Proposal> getProposals(int userId) {
        return InterviewDAO.findProposals(userId);
    }
    public static List<Interview> getFutureInterview(int userId,String type) {
        return InterviewDAO.findFutureInterview(userId,type);
    }
}
