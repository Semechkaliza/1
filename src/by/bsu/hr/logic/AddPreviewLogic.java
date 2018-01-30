package by.bsu.hr.logic;

import by.bsu.hr.dao.DAOException;
import by.bsu.hr.dao.InterviewDAO;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class AddPreviewLogic {
    public static void addPreview(int userId, int vacancyId, String date, String timeStr, String place,int proposalId) throws ParseException {
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd MM yyyy");
       //
        LocalDate LocDate= LocalDate.parse(date,dataFormatter);

        java.sql.Date dateSQL= java.sql.Date.valueOf(LocDate);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H.m");
      //  DateTimeFormatter timeForm = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        LocalTime time=LocalTime.parse(timeStr,timeFormatter);
     //   String text=time.format(timeForm);
         Time timeSQL= Time.valueOf(time);
       //  String s=timeSQL.toLocalTime().format(timeForm);
        try {
            InterviewDAO.addInterview(userId,vacancyId,dateSQL,timeSQL,place,"PREV");
            InterviewDAO.processProposal(proposalId);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        }

    public static void addTechInterview(int userId, int vacancyId, String date, String timeStr, String place,int proposalId) throws ParseException {
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            Date dateD = null;
            dateD = formatter.parse(date);
            System.out.println(formatter.format(dateD));
            java.sql.Date d=new java.sql.Date(dateD.getTime());
            DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("H.m");
            LocalTime time=LocalTime.parse(timeStr,formatterTime);
            Time timeSQL= Time.valueOf(time);
        try {
            InterviewDAO.addInterview(userId,vacancyId,d,timeSQL,place,"TECH");
            InterviewDAO.cancelProposal(proposalId);
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }
}
