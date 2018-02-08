package by.bsu.hr.entity;

/**
 * Proposal entity
 */
public class Proposal {
    private int id;
    private String vacancy;
    private String company;
    private int userId;
    private int vacancyId;
    private String name;
    private String sname;
    private boolean active;
    private boolean processed;

    @Override
    public String toString() {
        return "Proposal{" +
                "id=" + id +
                ", vacancy='" + vacancy + '\'' +
                ", company='" + company + '\'' +
                ", userId=" + userId +
                ", vacancyId=" + vacancyId +
                ", name='" + name + '\'' +
                ", sname='" + sname + '\'' +
                ", active=" + active +
                ", processed=" + processed +
                '}';
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
