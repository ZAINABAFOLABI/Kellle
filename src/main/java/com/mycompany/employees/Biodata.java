package com.mycompany.employees;

import jakarta.persistence.*;

@Entity
@Table(name= "employees")

public class Biodata  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length=6, unique = true, name = "tax_id")
    private String taxId;

    @Column(nullable = false, length=10, name = "first_name")
    private String firstName;

    @Column(nullable = false, length=10, name = "last_name")
    private String lastName;

    @Column(nullable = false, length = 5, name = "level")
    private String level;

    @Column(nullable = false, length=45, unique = true, name = "email")
    private String email;

    @Column(length=45, nullable = false, name = "address")
    private String address;

    @Column(length = 11, nullable = false, unique = true, name = "phone_number")
    private String phoneNumber;

    @Column(length = 15, nullable = false, name = "password")
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Biodata{" +
                "id=" + id +
                ", taxId='" + taxId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
