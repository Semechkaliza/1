package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AddInterviewLogic {
    public static void addInterview(int userId, int vacancyId, String date, String timeStr, String place,
                                    String type) throws LogicException {
        try{
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate LocDate= LocalDate.parse(date,dataFormatter);
        java.sql.Date dateSQL= java.sql.Date.valueOf(LocDate);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H.m");
        LocalTime time=LocalTime.parse(timeStr,timeFormatter);
        Time timeSQL= Time.valueOf(time);
            InterviewDAO.addInterview(userId,vacancyId,dateSQL,timeSQL,place,type);
            if(type.equalsIgnoreCase("prev")) InterviewDAO.processProposal(userId,vacancyId);
            else InterviewDAO.closeInterview(userId,vacancyId,"PREV");
        } catch (DateTimeParseException | DAOException e) {
            throw new LogicException("Error add interview",e);
        }
        }
}
