package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

import java.util.List;

public class HRInterviewLogic {
    public static List<Interview> findInterviews(String type) throws LogicException {
        try {
            return InterviewDAO.findHRInterviews(type);
        } catch (DAOException e) {
            throw new LogicException("Error find interviews",e);
        }
    }

    public static List<Interview> findFullInterviews(String type) throws LogicException {
        try {
            return InterviewDAO.findHRFullInterviews(type);
        } catch (DAOException e) {
            throw new LogicException("Error find full interviews",e);
        }
    }
}
