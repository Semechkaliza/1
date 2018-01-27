package by.bsu.hr.logic;

import by.bsu.hr.dao.UserDAO;

public class AddProposalLogic {
    public static void addProposal(int vacancy_id,int user_id) {
        UserDAO.addProposal(vacancy_id,user_id);
    }
}
