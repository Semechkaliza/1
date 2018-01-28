package by.bsu.hr.entity;

public class Vacancy {

    private int vacancyId;
    private String company;
    private String vacancy;
    private Integer salary;
    private String skill;
    private String other;
    private boolean active;

    @Override
    public String toString() {
        return "Vacancy{" +
                "vacancy id='" + vacancyId + '\'' +
                "company='" + company + '\'' +
                ", vacancy='" + vacancy + '\'' +
                ", salary=" + salary +
                ", skill='" + skill + '\'' +
                ", other='" + other + '\'' +
                ", active='" + active + '\'' +
                '}';
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
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
