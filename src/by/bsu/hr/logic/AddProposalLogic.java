package by.bsu.hr.logic;

import by.bsu.hr.dao.InterviewDAO;

public class AddProposalLogic {
    public static void addProposal(int vacancyId,int userId) {
        if(InterviewDAO.checkProposal(vacancyId,userId)){
            InterviewDAO.addProposal(vacancyId,userId);
        }
    }
}
