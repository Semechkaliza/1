package by.bsu.hr.dao;

import by.bsu.hr.connection.ConnectionPool;
import by.bsu.hr.connection.ConnectionPoolException;
import by.bsu.hr.entity.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancyDAO {
    private static String allVacanciesQuery = "SELECT * FROM vacancy";
    public static List getAllVacancies () {
        Connection cn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            cn= ConnectionPool.getInstance().takeConnection();
            st = cn.createStatement();
            rs = st.executeQuery(allVacanciesQuery);
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
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
                    resList2.add(vac);

                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resList2;
    }
}
