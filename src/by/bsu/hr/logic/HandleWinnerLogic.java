package by.bsu.hr.logic;

import by.bsu.hr.dao.UserDAO;

public class HandleWinnerLogic {
    public static void handleWinner(int user, int vacancy) {
        UserDAO.handleWinner(user,vacancy);
    }
}
