package by.bsu.hr.dao;

import by.bsu.hr.connection.ConnectionPool;
import by.bsu.hr.connection.ConnectionPoolException;
import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Vacancy;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.bsu.hr.connection.ConnectionPool.closeSt;

public class VacancyDAO {
    private static Logger logger= Logger.getLogger(VacancyDAO.class);
    private static final String ALL_VACANCIES_QUERY = "SELECT * FROM vacancy";
    private static final String FIND_FUTURE_INTERVIEW_QUERY="SELECT vacancy,company,login,date,time,place,RESULT " +
            "from users join interview join vacancy " +
            "on users.id=interview.USERS_ID and interview.VACANCY_ID=vacancy.ID " +
            "where vacancy.ACTIVE=1 and type LIKE ? and users.LOGIN LIKE ? and result is NULL;";
    private static final String CANCEL_PROPOSAL_QUERY = "update interested_users set ACTIVE=0 where ID=?;";
    public static List<Vacancy> getAllVacancies () {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn= ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(ALL_VACANCIES_QUERY);
            rs = st.executeQuery();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing db connecting");
        }
        List<Vacancy> resList2 = new ArrayList<>();
        try {
            if(rs != null && rs.next()){
                do {
                    Vacancy vac = new Vacancy();
                    vac.setCompany(rs.getString("company"));
                    vac.setVacancy(rs.getString("vacancy"));
                    vac.setSalary(rs.getInt("salary"));
                    vac.setSkill(rs.getString("priority_skill"));
                    vac.setOther(rs.getString("other"));
                    vac.setActive(rs.getBoolean("active"));
                    resList2.add(vac);

                } while (rs.next());
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR,"Missing get all vacancies list");
        }finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList2;
    }

    public static List<Interview> findFutureInterview(String login,String type){
        List<Interview> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(FIND_FUTURE_INTERVIEW_QUERY);
            st.setString(1,type);
            st.setString(2,login);
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
            System.out.println(st);
            st.setInt(1,id);
            System.out.println(st);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing cancel proposal");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
    }
}
