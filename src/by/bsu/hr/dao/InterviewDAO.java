package by.bsu.hr.dao;

import by.bsu.hr.connection.ConnectionPool;
import by.bsu.hr.connection.ConnectionPoolException;
import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.bsu.hr.connection.ConnectionPool.closeSt;
import static by.bsu.hr.connection.ConnectionPool.returnConnectionToPool;

public class InterviewDAO {
    private static Logger logger=Logger.getLogger(Interview.class);
    private static final String FIND_PROPOSALS_QUERY="SELECT interested_users.id,vacancy,company,login,interested_users.ACTIVE " +
            "from users join interested_users join vacancy " +
            "on users.id=interested_users.USERS_ID and interested_users.VACANCY_ID=vacancy.ID " +
            "where vacancy.ACTIVE=1 and interested_users.ACTIVE=1 and users.ID LIKE ?;";
    private static final String ADD_PROPOSAL_QUERY="insert into interested_users(VACANCY_ID,USERS_ID) values(?,?);";
    private static final String CHECK_PROPOSAL_QUERY="SELECT * from interested_users where VACANCY_ID like ? and USERS_ID " +
            "like ? and (ACTIVE=1 or PROCESSED=1)";
    private static final String FIND_FUTURE_INTERVIEW_QUERY="SELECT vacancy,company,login,date,time,place,RESULT " +
            "from users join interview join vacancy " +
            "on users.id=interview.USERS_ID and interview.VACANCY_ID=vacancy.ID " +
            "where vacancy.ACTIVE=1 and type LIKE ? and users.ID LIKE ? and result is NULL;";
    private static final String CANCEL_PROPOSAL_QUERY = "update interested_users set ACTIVE=0 where ID=?;";
    private static final String FIND_INTERVIEW_RESULT_QUERY="select vacancy,company,type,date,time,place,result,feedback" +
            " from interview join vacancy" +
            " on interview.VACANCY_ID=vacancy.ID" +
            " where USERS_ID=? and TYPE=? and RESULT is not null;";
    public static List<Proposal> findProposals(int userId){
        List<Proposal> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(FIND_PROPOSALS_QUERY);
            st.setInt(1,userId);
            rs=st.executeQuery();
            if (rs.next()) {
                do {
                    Proposal res = new Proposal();
                    res.setId(rs.getInt("id"));
                    res.setLogin(rs.getString("login"));
                    res.setCompany(rs.getString("company"));
                    res.setVacancy(rs.getString("vacancy"));
                    res.setActive(rs.getBoolean("active"));
                    resList.add(res);
                } while (rs.next());
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing finding proposals");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList;
    }
    public static void addProposal(int vacancyId,int userId) {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn=ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(ADD_PROPOSAL_QUERY);
            st.setInt(1,vacancyId);
            st.setInt(2,userId);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.INFO,"Missing add proposal");
        }finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
    }

    public static boolean checkProposal(int vacancyId, int userId) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        boolean check=true;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(CHECK_PROPOSAL_QUERY);
            st.setInt(1,vacancyId);
            st.setInt(2,userId);
            rs=st.executeQuery();
            if(rs.next()){
                check=false;
            }
        } catch (ConnectionPoolException | SQLException e) {
            logger.log(Level.ERROR,"Missing check proposal");
        }finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
        return check;
    }

    public static List<Interview> findFutureInterview(int userId,String type){
        List<Interview> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(FIND_FUTURE_INTERVIEW_QUERY);
            st.setString(1,type);
            st.setInt(2,userId);
            rs=st.executeQuery();
            if (rs.next()) {
                do {
                    Interview res = new Interview();
                    res.setLogin(rs.getString("login"));
                    res.setCompany(rs.getString("company"));
                    res.setVacancy(rs.getString("vacancy"));
                    res.setDate(rs.getString("date"));
                    res.setTime(rs.getString("time"));
                    res.setPlace(rs.getString("place"));
                    res.setMark(rs.getInt("result"));
                    resList.add(res);
                } while (rs.next());
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing finding future interview");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList;
    }

    public static void cancelProposal(int id) {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(CANCEL_PROPOSAL_QUERY);
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing cancel proposal");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
    }

    public static List<Interview> getInterviewResult(int userId,String type) {
        List<Interview> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(FIND_INTERVIEW_RESULT_QUERY);
            st.setInt(1,userId);
            st.setString(2,type);
            rs=st.executeQuery();
            if (rs.next()) {
                do {
                    Interview res = new Interview();
                    res.setCompany(rs.getString("company"));
                    res.setVacancy(rs.getString("vacancy"));
                    res.setDate(rs.getString("date"));
                    res.setTime(rs.getString("time"));
                    res.setPlace(rs.getString("place"));
                    res.setMark(rs.getInt("result"));
                    res.setFeedback(rs.getString("feedback"));
                    resList.add(res);
                } while (rs.next());
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing finding interview results");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList;
    }
}
