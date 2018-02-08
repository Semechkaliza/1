package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

/**
 * Logic to add proposal command
 */
public class AddProposalLogic {
    /**
     * Method to add proposal
     * @param vacancyId
     * @param userId
     * @throws LogicException
     */
    public static void addProposal(int vacancyId,int userId) throws LogicException {
        try {
            InterviewDAO.addProposal(vacancyId, userId);
        } catch (DAOException e) {
            throw new LogicException("Error add proposal",e);
        }
    }

    /**
     * Check, if user has already add proposal for this vacancy
     * @param vacancyId
     * @param userId
     * @return boolean
     * @throws LogicException
     */
    public static boolean checkProposal(int vacancyId,int userId) throws LogicException {
        try {
            return InterviewDAO.checkProposal(vacancyId,userId);
        } catch (DAOException e) {
            throw new LogicException("Error check proposal",e);
        }
    }
}
