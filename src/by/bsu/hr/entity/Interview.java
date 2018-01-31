package by.bsu.hr.entity;

import java.sql.Time;
import java.util.Date;

public class Interview {
    private String name;
    private String sname;
    private int userId;
    private int vacancyId;
    private String login;
    private String vacancy;
    private String company;
    private Date date;
    private Time time;
    private String dateStr;
    private String timeStr;
    private String place;
    private int mark;
    private String feedback;
    private String type;

    @Override
    public String toString() {
        return "Preview{" +
                "name='" + name + '\'' +
                "sname='" + sname + '\'' +
                "login='" + login + '\'' +
                ", vacancy='" + vacancy + '\'' +
                ", company='" + company + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", dateStr='" + dateStr + '\'' +
                ", timeStr='" + timeStr + '\'' +
                ", place='" + place + '\'' +
                ", mark=" + mark +
                ", feedback=" + feedback +
                ", type=" + type +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
