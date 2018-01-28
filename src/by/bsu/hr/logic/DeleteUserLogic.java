package by.bsu.hr.logic;

import by.bsu.hr.dao.UserDAO;

public class DeleteUserLogic {
    public static void deleteUser(int userId) {
        UserDAO.deleteUser(userId);
    }
}
