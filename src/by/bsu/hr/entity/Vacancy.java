package by.bsu.hr.entity;

/**
 * Vacancy entity
 */
public class Vacancy {

    private int vacancyId;
    private String company;
    private String vacancy;
    private String salary;
    private String other;
    private boolean active;

    @Override
    public String toString() {
        return "Vacancy{" +
                "vacancy id='" + vacancyId + '\'' +
                "company='" + company + '\'' +
                ", vacancy='" + vacancy + '\'' +
                ", salary=" + salary +
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
