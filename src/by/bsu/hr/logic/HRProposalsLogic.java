package by.bsu.hr.logic;

import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.entity.Proposal;

import java.util.List;

public class HRProposalsLogic {
    public static List<Proposal> getProposals() {
        return InterviewDAO.findHRProposals();
    }
}
