package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

public class GoAddInterviewResultLogic {
    public static Interview findInterviewInfo(int userId, int vacancyId, String type) throws LogicException {
        try {
            return InterviewDAO.findInfoToFinishInterview(userId,vacancyId,type);
        } catch (DAOException e) {
            throw new LogicException("Error find info",e);
        }
    }
}
