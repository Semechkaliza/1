package by.bsu.hr.entity;

public class Proposal {
    private String vacancy;
    private String company;
    private String login;
    private boolean active;

    @Override
    public String toString() {
        return "Proposal{" +
                "vacancy='" + vacancy + '\'' +
                ", company='" + company + '\'' +
                ", login='" + login + '\'' +
                ", active=" + active +
                '}';
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
