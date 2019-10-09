package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="employees")
public class Employee {

    private static int employeesCount;

    @Id
    @GeneratedValue
    private Integer employeeNumber;

    private String firstName;

    private String lastName;

    private String extension;

    private String email;

    private String officeCode;

    private Integer reportsTo;

    private String jobTitle;

    //bi-directional many-to-one association to Customer
//    @OneToMany(mappedBy="employee", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customers;
//
//    //bi-directional many-to-one association to Office
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="officeCode", insertable=false, updatable=false)
    @ManyToOne
    @JoinColumn(name = "officeCode", insertable = false, updatable = false)
    private Office office;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String extension, String email, String officeCode, Integer reportsTo,
                    String jobTitle) {
        super();
        this.employeeNumber = ++employeesCount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.jobTitle = jobTitle;
    }

    public static Integer getEmployeesCount() {
        return employeesCount;
    }

    public static void setEmployeesCount(Integer employeesCount) {
        Employee.employeesCount = employeesCount;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

//    public List<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(List<Customer> customers) {
//        this.customers = customers;
//    }
//
//    public Office getOffice() {
//        return office;
//    }
//
//    public void setOffice(Office office) {
//        this.office = office;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", officeCode='" + officeCode + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
