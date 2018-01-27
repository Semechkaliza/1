package by.bsu.hr.logic;

import by.bsu.hr.dao.VacancyDAO;
import by.bsu.hr.entity.Vacancy;

public class OneVacancyLogic {
    public static Vacancy getVacancy(int id) {
        Vacancy vacancy= VacancyDAO.findVacancy(id);
    return vacancy;
    }
}
