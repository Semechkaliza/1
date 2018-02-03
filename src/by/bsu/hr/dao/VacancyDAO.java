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
    private static final String ALL_VACANCIES_QUERY = "SELECT id,VACANCY,COMPANY,SALARY,OTHER FROM vacancy where ACTIVE=1 order by id desc limit ?,?";
    private static final String FIND_VACANCY_QUERY="SELECT * FROM vacancy WHERE ID=?;";
    private static final String CLOSE_VACANCY_QUERY="UPDATE vacancy set ACTIVE=0 WHERE id=?;";
    private static final String ADD_VACANCY_QUERY="insert into vacancy (COMPANY, VACANCY, SALARY, OTHER) VALUE (?,?,?,?)";
    public static List<Vacancy> findAllVacancies(int fromId,int size) throws DAOException {
        List<Vacancy> resList = new ArrayList<>();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn= ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(ALL_VACANCIES_QUERY);
            st.setInt(1,fromId);
            st.setInt(2,size);
            rs = st.executeQuery();
            if(rs != null && rs.next()){
                do {
                    Vacancy vac = new Vacancy();
                    vac.setCompany(rs.getString("company"));
                    vac.setVacancy(rs.getString("vacancy"));
                    vac.setVacancyId(rs.getInt("id"));
                    vac.setSalary(rs.getString("salary"));
                    vac.setOther(rs.getString("other"));
                    resList.add(vac);
                } while (rs.next());
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException("Error finding all vacancies",e);
        }
         finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList;
    }

    public static Vacancy findVacancy(int id) throws DAOException {
        Vacancy vacancy = new Vacancy();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(FIND_VACANCY_QUERY);
            st.setInt(1,id);
            rs=st.executeQuery();
            if (rs.next()) {
                    vacancy.setVacancyId(rs.getInt("id"));
                    vacancy.setCompany(rs.getString("company"));
                    vacancy.setVacancy(rs.getString("vacancy"));
                    vacancy.setSalary(rs.getString("salary"));
                    vacancy.setOther(rs.getString("other"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException("Error finding vacancy",e);
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return vacancy;
    }

    public static void closeVacancy(int vacancyId) throws DAOException {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(CLOSE_VACANCY_QUERY);
            st.setInt(1,vacancyId);
            st.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException("Error close vacancy",e);
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
    }

    public static void addVacancy(String vacancy, String company, String salary, String other) throws DAOException {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn =ConnectionPool.getInstance().takeConnection();
            st = cn.prepareStatement(ADD_VACANCY_QUERY);
            st.setString(1,company);
            st.setString(2,vacancy);
            st.setString(3,salary);
            st.setString(4,other);
            st.execute();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException("Error add vacancy",e);
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
    }
}
