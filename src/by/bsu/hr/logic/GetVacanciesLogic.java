package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.VacancyDAO;
import by.bsu.hr.entity.Vacancy;
import java.util.List;

public class GetVacanciesLogic {
    public static List<Vacancy> getAllVacancies() throws LogicException {
        try {
            return VacancyDAO.findAllVacancies();
        } catch (DAOException e) {
            throw new LogicException("Error find vacancies",e);
        }
    }
}
