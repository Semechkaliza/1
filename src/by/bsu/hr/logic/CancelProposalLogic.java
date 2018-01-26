package by.bsu.hr.logic;

import by.bsu.hr.dao.VacancyDAO;

public class CancelProposalLogic {
    public static void cancelProposal(int id) {
        VacancyDAO.cancelProposal(id);
    }
}
