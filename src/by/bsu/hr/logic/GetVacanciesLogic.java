package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.VacancyDAO;
import by.bsu.hr.entity.Vacancy;
import java.util.List;

/**
 * Logic to get vacancies command
 */
public class GetVacanciesLogic {
    /**
     * @param fromId
     * @param size
     * @return List of Vacancy
     * @throws LogicException
     */
    public static List<Vacancy> getAllVacancies(int fromId,int size) throws LogicException {
        try {
            return VacancyDAO.findAllVacancies(fromId, size);
        } catch (DAOException e) {
            throw new LogicException("Error find vacancies",e);
        }
    }
}
