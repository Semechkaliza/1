package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;

public class HandleWinnerLogic {
    public static void handleWinner(int user, int vacancy) throws LogicException {
        try {
            UserDAO.handleWinner(user,vacancy);
        } catch (DAOException e) {
            throw new LogicException("Error handle winner",e);
        }
    }
}
