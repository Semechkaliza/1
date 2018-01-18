package by.bsu.hr.dao;

import by.bsu.hr.entity.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements AbstractDAO {
    private static Logger logger=Logger.getLogger(UserDAO.class);
    private static String findUserQuery="SELECT * FROM users WHERE login LIKE ? AND password=md5(?);";
    private static String checkUserQuery="SELECT * FROM users WHERE login LIKE ?;";
    private static String AddUserQuery="insert into users(login,password,name,sname) values(?,md5(?),?,?);";
    public static List findUser(String login, String password){
        List<User> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs = null;
        try {new PropertiesManager();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println(PropertiesManager.getDbUrl());
            cn = DriverManager.getConnection(PropertiesManager.getDbUrl(), PropertiesManager.getDbProperties());
            PreparedStatement st = null;
            st = cn.prepareStatement(findUserQuery);
            st.setString(1,login);
            st.setString(2,password);
            rs=st.executeQuery();
            try {
                if (rs.next()) {
                    try {
                        do {
                            User res = new User();
                            res.setLogin(rs.getString("login"));
                            res.setPassword(rs.getString("password"));
                            res.setName(rs.getString("name"));
                            res.setSname(rs.getString("sname"));
                            res.setRole(rs.getString("role"));
                            res.setRating(rs.getInt("rating"));
                            resList.add(res);
                        } while (rs.next());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }catch (IOException e){

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resList;
    }

    public static boolean checkUser(String login){
        Connection cn = null;
        ResultSet rs = null;
        boolean check=true;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(PropertiesManager.getDbUrl(), PropertiesManager.getDbProperties());
            PreparedStatement st = null;
            st = cn.prepareStatement(checkUserQuery);
            st.setString(1,login);
            rs=st.executeQuery();
            if(rs.next()){
                check=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public static void add(String login, String password, String name, String sname) {
        String url = "jdbc:mysql://localhost:3306/HR_system";
        Connection cn = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(PropertiesManager.getDbUrl(), PropertiesManager.getDbProperties());
            PreparedStatement st = null;
            st = cn.prepareStatement(AddUserQuery);
            st.setString(1,login);
            st.setString(2,password);
            st.setString(3,name);
            st.setString(4,sname);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
