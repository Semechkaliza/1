package by.bsu.hr.logic;

import by.bsu.hr.dao.InterviewDAO;
import by.bsu.hr.dao.UserDAO;
import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class UserProfileLogic {
    public static List<Proposal> getProposals(int userId) {
        return InterviewDAO.findProposals(userId);
    }
    public static List<Interview> getFutureInterview(int userId, String type,Locale current) {
        List<Interview> interview=InterviewDAO.findFutureInterview(userId,type);
        Locale.setDefault(current);
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, current);
        DateTimeFormatter tf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        Date locDate;
        Time locTime;
        for(int i=0;i<interview.size();i++){
            locDate=interview.get(i).getDate();
            interview.get(i).setDateStr(df.format(locDate));
            locTime=interview.get(i).getTime();
            interview.get(i).setTimeStr(locTime.toLocalTime().format(tf));

        }
        return interview;
    }
}
