package edu.ucdavis.afs.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 4954164778973708466L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String jobTitle;
    @Column(nullable = false)
    private Date hiredDate;
    private String email;
    private String phone;
    private String address;
    @ManyToMany
    @JoinTable(name="EMPLOYEE_PROJECT")
    private List<Project> projects = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) { this.projects.add(project); }

    public void removeProject(Project project) { this.projects.remove(project); }

    public void copyEmployee(Employee clone) {
        if (this.firstName != null && !this.firstName.equals(clone.getFirstName())) {
            clone.setFirstName(this.firstName);
        }
        if (this.lastName != null && !this.lastName.equals(clone.getLastName())) {
            clone.setLastName(this.lastName);
        }
        if (this.jobTitle != null && !this.jobTitle.equals(clone.getJobTitle())) {
            clone.setJobTitle(this.jobTitle);
        }
        if (this.hiredDate != null && !this.hiredDate.equals(clone.getHiredDate())) {
            clone.setHiredDate(this.hiredDate);
        }
        if (this.email != null && !this.email.equals(clone.getEmail())) {
            clone.setEmail(this.email);
        }
        if (this.phone != null && !this.phone.equals(clone.getPhone())) {
            clone.setPhone(this.phone);
        }
        if (this.address != null && !this.address.equals(clone.getAddress())) {
            clone.setAddress(this.address);
        }
        if (this.projects != null && this.projects.size() > 0 && !this.projects.equals(clone.getProjects())) {
            clone.setProjects(this.projects);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", hiredDate=" + hiredDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (jobTitle != null ? !jobTitle.equals(employee.jobTitle) : employee.jobTitle != null) return false;
        if (hiredDate != null ? !hiredDate.equals(employee.hiredDate) : employee.hiredDate != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        return projects != null ? projects.equals(employee.projects) : employee.projects == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (hiredDate != null ? hiredDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (projects != null ? projects.hashCode() : 0);
        return result;
    }

}
