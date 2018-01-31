package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.User;

public class RegistrationLogic {
    public static User registraton(String login,String password,String name,String sname) throws LogicException {
        User user=new User();
            if (UserDAO.checkUser(login)) {
                try {
                    user= UserDAO.findUser(login,password);
                    user.setLogin(login);
                    user.setPassword(password);
                    user.setName(name);
                    user.setSname(sname);
                    user.setRole("USER");
                    UserDAO.addUser(login,password,name,sname);
                } catch (DAOException e) {
                    throw new LogicException("Error registration",e);
                }
            }
        return user;
    }
}
