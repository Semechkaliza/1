package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;

public class RegistrationLogic {
    public static User registraton(String login,String password,String name,String sname,String phone,String email) throws LogicException {
        User user=new User();
            if (UserDAO.checkUser(login)) {
                try {
                    UserDAO.addUser(login,password,name,sname,phone,email);
                    user= UserDAO.findUser(login,password);
                } catch (DAOException e) {
                    throw new LogicException("Error registration",e);
                }
            }
        return user;
    }
}
