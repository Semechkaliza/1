package by.bsu.hr.dao;

import by.bsu.hr.connection.ConnectionPool;
import by.bsu.hr.connection.ConnectionPoolException;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.entity.Winner;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.bsu.hr.connection.ConnectionPool.closeSt;
import static by.bsu.hr.connection.ConnectionPool.returnConnectionToPool;

public class UserDAO {
    private static Logger logger=Logger.getLogger(UserDAO.class);
    private static final String FIND_USER_QUERY="SELECT * FROM users WHERE login LIKE ? AND password=md5(?) and ACTIVE=1;";
    private static final String CHECK_USER_QUERY="SELECT * FROM users WHERE login LIKE ? and ACTIVE=1;";
    private static final String ADD_USER_QUERY="insert into users(login,password,name,sname) values(?,md5(?),?,?);";
    private static final String UPDATE_INFO_QUERY="UPDATE users SET NAME=?,SNAME=?,PHONE=?,EMAIL=? WHERE ID=?";
    private static final String DELETE_USER_QUERY="UPDATE users set ACTIVE=0 WHERE ID=? and ACTIVE=1";
    private static final String GET_WINNERS_QUERY="select users_id,vacancy_id,name,sname,phone,email,vacancy,company " +
            "from winners join vacancy join users " +
            "on winners.VACANCY_ID=vacancy.ID and winners.USERS_ID=users.ID " +
            "where winners.ACTIVE=1;";
    private static final String HANDLE_WINNER_QUERY="UPDATE winners set active=0 where USERS_ID=? and vacancy_id=?";
    public static User findUser(String login, String password){
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        User res = new User();
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(FIND_USER_QUERY);
            st.setString(1,login);
            st.setString(2,password);
            rs=st.executeQuery();
                if (rs.next()) {
                            res.setUserId(rs.getInt("id"));
                            res.setLogin(rs.getString("login"));
                            res.setPassword(rs.getString("password"));
                            res.setName(rs.getString("name"));
                            res.setSname(rs.getString("sname"));
                            res.setRole(rs.getString("role"));
                            res.setPhone(rs.getString("phone"));
                            res.setEmail(rs.getString("email"));
                            res.setActive(rs.getBoolean("active"));
                }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing finding user");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return res;
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
                check = false;
            }
        } catch (ConnectionPoolException | SQLException e) {
            logger.log(Level.ERROR,"Missing check user");
        }finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
        return check;
    }
    public static void addUser(String login, String password, String name, String sname) throws DAOException {
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
            throw new DAOException("Error registration user", e);
        }finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
    }

    public static void updateInfo(String name, String sname, String phone, String email, int id) {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(UPDATE_INFO_QUERY);
            st.setString(1,name);
            st.setString(2,sname);
            st.setString(3,phone);
            st.setString(4,email);
            st.setInt(5,id);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing cancel proposal");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
    }


    public static void deleteUser(int userId) {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(DELETE_USER_QUERY);
            st.setInt(1,userId);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing delete user");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
    }

    public static List<Winner> findWinners() {
        List<Winner> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(GET_WINNERS_QUERY);
            rs=st.executeQuery();
            if (rs.next()) {
                do {
                    Winner res=new Winner();
                    res.setuserId(rs.getInt("users_id"));
                    res.setvacancyId(rs.getInt("vacancyId"));
                    res.setName(rs.getString("name"));
                    res.setSname(rs.getString("sname"));
                    res.setPhone(rs.getString("phone"));
                    res.setEmail(rs.getString("email"));
                    res.setVacancy(rs.getString("vacancy"));
                    res.setCompany(rs.getString("company"));
                    resList.add(res);
                } while (rs.next());
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing finding winners");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList;
    }

    public static void handleWinner(int userId, int vacancyId) {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(HANDLE_WINNER_QUERY);
            st.setInt(1,userId);
            st.setInt(2,vacancyId);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing handle winner");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
    }
}
