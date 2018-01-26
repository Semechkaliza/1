package by.bsu.hr.logic;

import by.bsu.hr.dao.UserDAO;

public class ChangeInfoLogic {
    public static void updateInfo(String name, String sname, String phone, String email,int id) {
        UserDAO.updateInfo(name,sname,phone,email,id);
    }
}
