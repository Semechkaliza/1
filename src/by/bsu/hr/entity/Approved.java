package by.bsu.hr.entity;

/**
 * Approved entity
 */
public class Approved {
    private int userId;
    private int vacancyId;
    private String name;
    private String sname;
    private String phone;
    private String email;
    private String vacancy;
    private String company;

    @Override
    public String toString() {
        return "Approved{" +
                "userId='" + userId + '\'' +
                ", vacancyId='" + vacancyId + '\'' +
                ", name='" + name + '\'' +
                ", sname='" + sname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", vacancy='" + vacancy + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public int getvacancyId() {
        return vacancyId;
    }

    public void setvacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
