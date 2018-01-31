package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

public class CloseInterviewLogic {
    public static void closeInterview(int userId, int vacancyId, String type) throws LogicException {
        try {
            InterviewDAO.closeInterview(userId,vacancyId,type);
        } catch (DAOException e) {
            throw new LogicException("Error close interview",e);
        }
    }
}
