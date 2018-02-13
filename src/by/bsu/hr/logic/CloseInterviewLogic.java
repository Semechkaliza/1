package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

/**
 * Logic to close interview command
 */
public class CloseInterviewLogic {
    /**
     * @param userId
     * @param vacancyId
     * @param type
     * @throws LogicException
     */
    public static void closeInterview(int userId, int vacancyId, String type) throws LogicException {
        try {
            InterviewDAO.closeInterview(userId, vacancyId, type);
        } catch (DAOException e) {
            throw new LogicException("Error close interview", e);
        }
    }
}
