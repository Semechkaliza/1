package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.VacancyDAO;
import by.bsu.hr.entity.Vacancy;

public class OneVacancyLogic {
    public static Vacancy getVacancy(int id) throws LogicException {
        Vacancy vacancy= null;
        try {
            vacancy = VacancyDAO.findVacancy(id);
        } catch (DAOException e) {
            throw new LogicException("Error find vacancies",e);
        }
        return vacancy;
    }
}
