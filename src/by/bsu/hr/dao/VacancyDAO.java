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
    private static final String ALL_VACANCIES_QUERY = "SELECT id,VACANCY,COMPANY FROM vacancy where ACTIVE=1";
    private static final String FIND_VACANCY_QUERY="SELECT * FROM vacancy WHERE ID=?";
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
                    vac.setVacancyId(rs.getInt("id"));
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

    public static Vacancy findVacancy(int id) {
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
                    vacancy.setSalary(rs.getInt("salary"));
                    vacancy.setOther(rs.getString("other"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            logger.log(Level.ERROR,"Missing finding vacancy");
        } finally {
            closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return vacancy;
    }
}
