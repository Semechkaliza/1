package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.Winner;

import java.util.List;

public class GoWinnersLogic {
    public static List<Winner> findWinners() throws LogicException {
        try {
            return UserDAO.findWinners();
        } catch (DAOException e) {
            throw new LogicException("Error find winners",e);
        }
    }
}
