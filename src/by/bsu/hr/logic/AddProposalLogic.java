package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

public class AddProposalLogic {
    public static void addProposal(int vacancyId,int userId) throws LogicException {
        try {
            if(InterviewDAO.checkProposal(vacancyId,userId)){
                    InterviewDAO.addProposal(vacancyId, userId);
            }
        } catch (DAOException e) {
            throw new LogicException("Error add proposal",e);
        }
    }
}
