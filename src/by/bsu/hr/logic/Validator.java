package by.bsu.hr.logic;

public class Validator {
    public static boolean registrationValid(String login,String pass,String name,String sname){
        if(login.isEmpty()||pass.isEmpty()||name.isEmpty()||sname.isEmpty())
            return false;
        else return true;
    }
}
