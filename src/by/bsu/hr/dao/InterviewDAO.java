package by.bsu.hr.dao;

import by.bsu.hr.connection.ConnectionPool;
import by.bsu.hr.connection.ConnectionPoolException;
import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.bsu.hr.connection.ConnectionPool.closeSt;
import static by.bsu.hr.connection.ConnectionPool.returnConnectionToPool;

public class InterviewDAO {
    private static Logger logger=Logger.getLogger(Interview.class);
    private static final String FIND_PROPOSALS_QUERY="SELECT interested_users.id,vacancy,company,interested_users.ACTIVE " +
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
    private static final String HR_PROPOSALS_QUERY="SELECT interested_users.id,vacancy,company,VACANCY_ID,USERS_ID,NAME,SNAME " +
            "from users join interested_users join vacancy " +
            "on users.id=interested_users.USERS_ID and interested_users.VACANCY_ID=vacancy.ID " +
            "where vacancy.ACTIVE=1 and interested_users.ACTIVE=1 and users.ACTIVE=1;";
    private static final String FIND_INFO_TO_APPOINT_INTERVIEW_QUERY="select name,sname,vacancy,company,USERS_ID,VACANCY_ID " +
            "from interested_users join users join vacancy " +
            "on interested_users.USERS_ID=users.ID and interested_users.VACANCY_ID=vacancy.ID " +
            "where interested_users.ID=?;";
    private static final String ADD_INTERVIEW_QUERY="insert into interview (vacancy_id,users_id,type,date,time,place) values (?,?,?,?,?,?);";
    private static final String PROCESS_PROPOSAL_QUERY = "update interested_users set ACTIVE=0 and processed=1 where ID=?;";
    private static final String CHECK_PROCESSED_PROPOSAL_QUERY="SELECT * from interested_users where USERS_ID like ? and VACANCY_ID " +
            "like ? and ACTIVE=1 and PROCESSED=1";
    public static List<Proposal> findProposals(int userId){
        List<Proposal> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs;
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
            st.execute();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.INFO,"Missing add proposal");
        }finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
    }

    public static boolean checkProposal(int vacancyId, int userId) {
        Connection cn = null;
        ResultSet rs;
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
        ResultSet rs;
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
                    res.setCompany(rs.getString("company"));
                    res.setVacancy(rs.getString("vacancy"));
                    res.setDate(rs.getDate("date"));
                    res.setTime(rs.getTime("time"));
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

    public static List<Interview> findInterviewResult(int userId, String type) {
        List<Interview> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs;
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
                    res.setDate(rs.getDate("date"));
                    res.setTime(rs.getTime("time"));
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

    public static List<Proposal> findHRProposals() {
        List<Proposal> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(HR_PROPOSALS_QUERY);
            rs=st.executeQuery();
            if (rs.next()) {
                do {
                    Proposal res=new Proposal();
                    res.setCompany(rs.getString("company"));
                    res.setVacancy(rs.getString("vacancy"));
                    res.setId(rs.getInt("id"));
                    res.setVacancyId(rs.getInt("vacancy_id"));
                    res.setUserId(rs.getInt("users_id"));
                    res.setName(rs.getString("name"));
                    res.setSname(rs.getString("sname"));
                    resList.add(res);
                } while (rs.next());
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing find hr proposals");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList;
    }

    public static Interview findInfoToAppointPreview(int proposalId) {
        Connection cn = null;
        Interview res = new Interview();
        ResultSet rs;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(FIND_INFO_TO_APPOINT_INTERVIEW_QUERY);
            st.setInt(1,proposalId);
            rs=st.executeQuery();
            if (rs.next()) {
                    res.setCompany(rs.getString("company"));
                    res.setVacancy(rs.getString("vacancy"));
                    res.setName(rs.getString("name"));
                    res.setSname(rs.getString("sname"));
                    res.setUserId(rs.getInt("users_id"));
                    res.setVacancyId(rs.getInt("vacancy_id"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing finding info to appoint preview");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return res;
    }

    public static void addInterview(int userId, int vacancyId, java.sql.Date date, Time time, String place, String type) throws DAOException {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn=ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(ADD_INTERVIEW_QUERY);
            st.setInt(1,vacancyId);
            st.setInt(2,userId);
            st.setString(3,type);
            st.setDate(4,date);
            st.setTime(5,time);
            st.setString(6,place);
            st.execute();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException("Error adding preview",e);
        } finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
    }

    public static void processProposal(int proposalId) {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(PROCESS_PROPOSAL_QUERY);
            st.setInt(1,proposalId);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing process proposal");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
    }

    public static boolean checkIfProposalProcessed(int vacancyId, int userId) {
        Connection cn = null;
        ResultSet rs;
        PreparedStatement st = null;
        boolean check=false;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(CHECK_PROCESSED_PROPOSAL_QUERY);
            st.setInt(1,userId);
            st.setInt(2,vacancyId);
            rs=st.executeQuery();
            if(!rs.next()){
                check=true;
            }
        } catch (ConnectionPoolException | SQLException e) {
            logger.log(Level.ERROR,"Missing check processed proposal");
        }finally {
            closeSt(st);
            returnConnectionToPool(cn);
        }
        return check;
    }
}
