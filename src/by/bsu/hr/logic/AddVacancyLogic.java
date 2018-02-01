package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.VacancyDAO;

public class AddVacancyLogic {
    public static void addVacancy(String vacancy, String company, int salary, String other) throws LogicException {
        try {
            VacancyDAO.addVacancy(vacancy,company,salary,other);
        } catch (DAOException e) {
            throw new LogicException("Error add proposal",e);
        }
    }
}
