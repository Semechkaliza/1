package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

public class AddInterviewResultLogic {
    public static void addResult(int userId, int vacancyId, String type, int mark, String feedback) throws LogicException {
        try {
            InterviewDAO.addIntrviewResult(userId,vacancyId,type,mark,feedback);
        } catch (DAOException e) {
            throw new LogicException("Error add interview result",e);
        }
    }
}
