package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

import java.util.List;

/**
 * Logic to go interviews and full interviews pages commands
 */
public class HRInterviewLogic {
    /**
     * Return all interviews with type=String type and without info about date,time,place
     *
     * @param type
     * @return List of Interview
     * @throws LogicException
     */
    public static List<Interview> findInterviews(String type) throws LogicException {
        try {
            return InterviewDAO.findHRInterviews(type);
        } catch (DAOException e) {
            throw new LogicException("Error find interviews", e);
        }
    }

    /**
     * Return all interviews with type=String type and without results
     *
     * @param type
     * @return List of Interview
     * @throws LogicException
     */
    public static List<Interview> findFullInterviews(String type) throws LogicException {
        try {
            return InterviewDAO.findHRFullInterviews(type);
        } catch (DAOException e) {
            throw new LogicException("Error find full interviews", e);
        }
    }
}
