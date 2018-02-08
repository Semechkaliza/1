package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

import java.util.List;

/**
 * Logic to interviews results
 */
public class ResultLogic {
    /**
     * @param userId
     * @return List of Interview
     * @throws LogicException
     */
    public static List<Interview> getPreviewResult(int userId) throws LogicException {
        List<Interview> resList= null;
        try {
            resList = InterviewDAO.findInterviewResult(userId,"PREV");
        } catch (DAOException e) {
            throw new LogicException("Error fnd results",e);
        }
        return resList;
    }

    /**
     * @param userId
     * @return List of Interview
     * @throws LogicException
     */
    public static List<Interview> getInterviewResult(int userId) throws LogicException {
        List<Interview> resList= null;
        try {
            resList = InterviewDAO.findInterviewResult(userId,"TECH");
        } catch (DAOException e) {
            throw new LogicException("Error fnd results",e);
        }
        return resList;
    }
}
