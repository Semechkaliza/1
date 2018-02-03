package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class AddInterviewLogic {
    public static void addInterview(int userId, int vacancyId, Date dateSQL, Time timeSQL, String place,
                                    String type) throws LogicException {
        try{
            InterviewDAO.addInterview(userId,vacancyId,dateSQL,timeSQL,place,type);
            if(type.equalsIgnoreCase("prev")) InterviewDAO.processProposal(userId,vacancyId);
            else InterviewDAO.closeInterview(userId,vacancyId,"PREV");
        } catch (DateTimeParseException | DAOException e) {
            throw new LogicException("Error add interview",e);
        }
        }

    public static Date getDateSQL(String date) {
     Date dateSQL;
     LocalDate locDate;
     if(date.contains("/")){
         locDate= LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
     }else{
         locDate= LocalDate.parse(date,DateTimeFormatter.ofPattern("dd.MM.yyyy"));
     }
     dateSQL= Date.valueOf(locDate);
     return dateSQL;
    }

    public static Time getTimeSQL(String time) {
        Time timeSQL;
        LocalTime locTime;
        if(time.contains("M")){
            locTime=LocalTime.parse(time,DateTimeFormatter.ofPattern("h:m a"));
        }else{
            locTime=LocalTime.parse(time,DateTimeFormatter.ofPattern("H.m"));
        }
        timeSQL= Time.valueOf(locTime);
        return timeSQL;
    }
}
