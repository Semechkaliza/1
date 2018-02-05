package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

public class AddProposalLogic {
    public static void addProposal(int vacancyId,int userId) throws LogicException {
        try {
            InterviewDAO.addProposal(vacancyId, userId);
        } catch (DAOException e) {
            throw new LogicException("Error add proposal",e);
        }
    }
    public static boolean checkProposal(int vacancyId,int userId) throws LogicException {
        try {
            return InterviewDAO.checkProposal(vacancyId,userId);
        } catch (DAOException e) {
            throw new LogicException("Error check proposal",e);
        }
    }
}
