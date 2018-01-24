package by.bsu.hr.dao;

import by.bsu.hr.connection.ConnectionPool;
import by.bsu.hr.connection.ConnectionPoolException;
import by.bsu.hr.entity.Vacancy;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancyDAO {
    private static Logger logger= Logger.getLogger(VacancyDAO.class);
    private static final String ALL_VACANCIES_QUERY = "SELECT * FROM vacancy";
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
            ConnectionPool.closeSt(st);
            ConnectionPool.returnConnectionToPool(cn);
        }
        return resList2;
    }
}
