package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.VacancyDAO;

/**
 * Logic to add vacancy command
 */
public class AddVacancyLogic {
    /**
     * @param vacancy
     * @param company
     * @param salary
     * @param other
     * @throws LogicException
     */
    public static void addVacancy(String vacancy, String company, String salary, String other) throws LogicException {
        try {
            VacancyDAO.addVacancy(vacancy, company, salary, other);
        } catch (DAOException e) {
            throw new LogicException("Error add proposal", e);
        }
    }
}
