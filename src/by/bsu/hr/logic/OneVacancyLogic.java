package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.VacancyDAO;
import by.bsu.hr.entity.Vacancy;

/**
 * Logic to one vacancy command
 */
public class OneVacancyLogic {
    /**
     * @param id
     * @return Vacancy
     * @throws LogicException
     */
    public static Vacancy getVacancy(int id) throws LogicException {
        Vacancy vacancy;
        try {
            vacancy = VacancyDAO.findVacancy(id);
        } catch (DAOException e) {
            throw new LogicException("Error find vacancies", e);
        }
        return vacancy;
    }
}
