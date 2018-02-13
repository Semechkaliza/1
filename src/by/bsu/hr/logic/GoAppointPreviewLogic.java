package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

/**
 * Logic to appoint preview command
 */
public class GoAppointPreviewLogic {

    /**
     * @param vacancyId
     * @param userId
     * @return Interview
     * @throws LogicException
     */
    public static Interview findInfoToInterview(int vacancyId, int userId) throws LogicException {
        try {
            return InterviewDAO.findInfoToAppointInterview(vacancyId, userId);
        } catch (DAOException e) {
            throw new LogicException("Error find info", e);
        }
    }
}
