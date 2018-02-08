package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;

/**
 * Logic to registration command
 */
public class RegistrationLogic {
    /**
     * @param login
     * @param password
     * @param name
     * @param sname
     * @param phone
     * @param email
     * @return User
     * @throws LogicException
     */
    public static User registration(String login,String password,String name,String sname,String phone,String email) throws LogicException {
        User user=new User();
        try {
            if (UserDAO.checkUser(login)) {
                UserDAO.addUser(login, password, name, sname, phone, email);
                user = UserDAO.findUser(login, password);
            }
        }catch (DAOException e) {
            throw new LogicException("Error registration",e);
        }
        return user;
    }
}
