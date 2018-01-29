package by.bsu.hr.logic;

import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Interview;

public class GoAppointPreviewLogic {

    public static Interview findInfoToPreview(int userId, int vacancyId) {
        return InterviewDAO.findInfoToAppointPreview(userId,vacancyId);
    }
}
