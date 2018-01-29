package by.bsu.hr.logic;

import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;

import java.util.List;

public class UserProfileLogic {
    public static List<Proposal> getProposals(int userId) {
        return InterviewDAO.findProposals(userId);
    }
    public static List<Interview> getFutureInterview(int userId, String type) {
        return InterviewDAO.findFutureInterview(userId,type);
    }
}
