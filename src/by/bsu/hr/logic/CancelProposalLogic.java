package by.bsu.hr.logic;

import by.bsu.hr.dao.InterviewDAO;

public class CancelProposalLogic {
    public static void cancelProposal(int id) {
        InterviewDAO.cancelProposal(id);
    }
}
