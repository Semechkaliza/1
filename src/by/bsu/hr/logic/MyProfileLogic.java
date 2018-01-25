package by.bsu.hr.logic;

import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.Proposal;

import java.util.List;

public class MyProfileLogic {
    public static List<Proposal> getProposals(String login) {
        return UserDAO.findProposals(login);
    }
}
