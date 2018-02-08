package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Proposal;

import java.util.List;

/**
 * Logic to HRProposals Logic
 */
public class HRProposalsLogic {
    /**
     * @return List of Proposal
     * @throws LogicException
     */
    public static List<Proposal> getProposals() throws LogicException {
        try {
            return InterviewDAO.findHRProposals();
        } catch (DAOException e) {
            throw new LogicException("Error find proposals",e);
        }
    }
}
