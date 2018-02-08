package by.bsu.hr.logic;

import by.bsu.hr.dao.InterviewDAO;

/**
 * Logic to cancel proposal command
 */
public class CancelProposalLogic {
    /**
     * @param id
     */
    public static void cancelProposal(int id) {
        InterviewDAO.cancelProposal(id);
    }
}
