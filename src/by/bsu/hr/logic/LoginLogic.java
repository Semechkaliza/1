package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;

/**
 * Logic to login command
 */
public class LoginLogic {
    /**
     * @param login
     * @param pass
     * @return User
     * @throws LogicException
     */
    public static User logIn(String login, String pass) throws LogicException {
        try {
            return UserDAO.findUser(login, pass);
        } catch (DAOException e) {
            throw new LogicException("Error find user", e);
        }
    }
}
