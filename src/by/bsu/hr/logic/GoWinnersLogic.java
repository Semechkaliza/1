package by.bsu.hr.logic;

import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.Winner;

import java.util.List;

public class GoWinnersLogic {
    public static List<Winner> getWinners() {
        return UserDAO.findWinners();
    }
}
