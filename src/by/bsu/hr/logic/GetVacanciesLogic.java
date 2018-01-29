package by.bsu.hr.logic;

import by.bsu.hr.dao.VacancyDAO;
import by.bsu.hr.entity.Vacancy;
import java.util.List;

public class GetVacanciesLogic {
    public static List<Vacancy> getAllVacancies() {
        return VacancyDAO.findAllVacancies();
    }
}
