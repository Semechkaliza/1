package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * Logic to add interview command
 */
public class AddInterviewLogic {
    /**
     * @param userId
     * @param vacancyId
     * @param dateSQL
     * @param timeSQL
     * @param place
     * @param type
     * @throws LogicException
     */
    public static void addInterview(int userId, int vacancyId, Date dateSQL, Time timeSQL, String place,
                                    String type) throws LogicException {
        try {
            if (InterviewDAO.checkInterview(userId, vacancyId, type)) {
                InterviewDAO.addInterview(userId, vacancyId, dateSQL, timeSQL, place, type);
            }
            if (type.equalsIgnoreCase("prev")) {
                InterviewDAO.processProposal(userId, vacancyId);
            } else {
                InterviewDAO.closeInterview(userId, vacancyId, "PREV");
            }
        } catch (DateTimeParseException | DAOException e) {
            throw new LogicException("Error add interview", e);
        }
    }

    /**
     * Parse date from string to Date by 2 patterns(en and ru)
     *
     * @param date
     * @return java.sql.Date
     */
    public static Date getDateSQL(String date) {
        Date dateSQL;
        LocalDate locDate;
        if (date.contains("/")) {
            locDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else {
            locDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        dateSQL = Date.valueOf(locDate);
        return dateSQL;
    }

    /**
     * Parse string time to Time in 2 patterns (en and ru)
     *
     * @param time
     * @return java.sql.Time
     */
    public static Time getTimeSQL(String time) {
        Time timeSQL;
        LocalTime locTime;
        if (time.contains("M")) {
            locTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("h:m a"));
        } else {
            locTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:m"));
        }
        timeSQL = Time.valueOf(locTime);
        return timeSQL;
    }
}
