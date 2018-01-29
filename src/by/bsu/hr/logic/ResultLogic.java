package by.bsu.hr.logic;

import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

import java.util.List;

public class ResultLogic {
    public static List<Interview> getPreviewResult(int userId) {
        List<Interview> resList= InterviewDAO.findInterviewResult(userId,"PREV");
        return resList;
    }

    public static List<Interview> getInterviewResult(int userId) {
        List<Interview> resList= InterviewDAO.findInterviewResult(userId,"TECH");
        return resList;
    }
}
