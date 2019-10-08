package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="offices")
public class Office {

    @Id
    private String officeCode;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String country;

    private String phone;

    private String postalCode;

    private String state;

    private String territory;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy="office", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Office() {
    }

    public Office(String officeCode, String addressLine1, String addressLine2, String city, String country,
                  String phone, String postalCode, String state, String territory) {
        super();
        this.officeCode = officeCode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.postalCode = postalCode;
        this.state = state;
        this.territory = territory;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Office)) return false;
        Office office = (Office) o;
        return Objects.equals(officeCode, office.officeCode) &&
                Objects.equals(addressLine1, office.addressLine1) &&
                Objects.equals(addressLine2, office.addressLine2) &&
                Objects.equals(city, office.city) &&
                Objects.equals(country, office.country) &&
                Objects.equals(phone, office.phone) &&
                Objects.equals(postalCode, office.postalCode) &&
                Objects.equals(state, office.state) &&
                Objects.equals(territory, office.territory) &&
                Objects.equals(employees, office.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeCode, addressLine1, addressLine2, city, country, phone, postalCode, state, territory, employees);
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeCode='" + officeCode + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", territory='" + territory + '\'' +
                ", employees=" + employees +
                '}';
    }

}
