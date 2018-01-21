package by.bsu.hr.dao;

import by.bsu.hr.connection.ConnectionPool;
import by.bsu.hr.connection.ConnectionPoolException;
import by.bsu.hr.entity.User;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.bsu.hr.connection.ConnectionPool.closeSt;
import static by.bsu.hr.connection.ConnectionPool.returnConnectionToPool;

public class UserDAO {
    private static Logger logger=Logger.getLogger(UserDAO.class);
    private static final String FIND_USER_QUERY="SELECT * FROM users WHERE login LIKE ? AND password=md5(?);";
    private static final String CHECK_USER_QUERY="SELECT * FROM users WHERE login LIKE ?;";
    private static final String ADD_USER_QUERY="insert into users(login,password,name,sname) values(?,md5(?),?,?);";
    public static List<User> findUser(String login, String password){
        List<User> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(FIND_USER_QUERY);
            st.setString(1,login);
            st.setString(2,password);
            rs=st.executeQuery();
                if (rs.next()) {
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
                }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.INFO,"Missing finding user");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList;
    }

    public static boolean checkUser(String login){
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        boolean check=true;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(CHECK_USER_QUERY);
            st.setString(1,login);
            rs=st.executeQuery();
            if(rs.next()){
                check=false;
            }
        } catch (ConnectionPoolException | SQLException e) {
            logger.log(Level.INFO,"Missing check user");
        }finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
        return check;
    }
    public static void add(String login, String password, String name, String sname) {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn=ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(ADD_USER_QUERY);
            st.setString(1,login);
            st.setString(2,password);
            st.setString(3,name);
            st.setString(4,sname);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.INFO,"Missing add user");
        }finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
    }
}
