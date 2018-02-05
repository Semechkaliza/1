package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

public class GoAppointPreviewLogic {

    public static Interview findInfoToInterview(int vacancyId, int userId) throws LogicException {
        try {
            return InterviewDAO.findInfoToAppointInterview(vacancyId,userId);
        } catch (DAOException e) {
            throw new LogicException("Error find info",e);
            }
    }
}
