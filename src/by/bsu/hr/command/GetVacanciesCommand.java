package by.bsu.hr.command;

import by.bsu.hr.dao.PropertiesManager;
import by.bsu.hr.entity.Vacancy;
import by.bsu.hr.logic.GetVacanciesLogic;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetVacanciesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page= GetVacanciesLogic.getAllVacancies(request);
        return page;
    }
}
