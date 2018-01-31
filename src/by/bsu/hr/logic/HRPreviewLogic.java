package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

import java.util.List;

public class HRPreviewLogic {
    public static List<Interview> findPreviews(String type) throws LogicException {
        try {
            return InterviewDAO.findHRInterviews(type);
        } catch (DAOException e) {
            throw new LogicException("Error find previews",e);
        }
    }

    public static List<Interview> findFullPreviews(String type) throws LogicException {
        try {
            return InterviewDAO.findHRFullInterviews(type);
        } catch (DAOException e) {
            throw new LogicException("Error find previews",e);
        }
    }
}
