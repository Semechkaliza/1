package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.VacancyDAO;

/**
 * Logic to close vacancy command
 */
public class CloseVacancyLogic {
    /**
     * @param vacancyId
     * @throws LogicException
     */
    public static void closeVacancy(int vacancyId) throws LogicException {
        try {
            VacancyDAO.closeVacancy(vacancyId);
        } catch (DAOException e) {
            throw new LogicException("Error close vacancy",e);
        }
    }
}
