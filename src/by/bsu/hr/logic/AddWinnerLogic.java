package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

public class AddWinnerLogic {
    public static void addWinner(int userId, int vacancyId) throws LogicException {
        try {
            UserDAO.addWinner(userId,vacancyId);
        } catch (DAOException e) {
            throw new LogicException("Error add winner",e);
        }
    }
}
