package by.bsu.hr.dao;

import by.bsu.hr.entity.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancyDAO {
    private static String allVacanciesQuery = "SELECT * FROM vacancy";
    public static List getAllVacancies () {
        Connection cn = null;
        ResultSet rs = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cn = DriverManager.getConnection(PropertiesManager.getDbUrl(), PropertiesManager.getDbProperties());
            Statement st = null;
            st = cn.createStatement();
            rs = st.executeQuery(allVacanciesQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Vacancy> resList2 = new ArrayList<>();
        try {
            if(rs.next()){
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
