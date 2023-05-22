package com.mycompany.employees;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")

public class Payments {

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", staffId='" + staffId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", netSalary=" + netSalary +
                ", grossSalary=" + grossSalary +
                ", taxRate='" + taxRate + '\'' +
                ", taxId='" + taxId + '\'' +
                ", taxDue=" + taxDue +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 6, name="staff_id")
    private String staffId;

    @Column(nullable=false, length = 10, unique=true, name = "account_number")
    private String accountNumber;

    @Column(nullable=false, length = 6, name = "sort_code")
    private String sortCode;

    @Column(nullable=false, length = 45, name = "bank_name")
    private String bankName;

    @Column(nullable = false, length = 4, name="net_salary")
    private Integer netSalary;

    @Column(nullable = false, length = 4, name="gross_salary")
    private Integer grossSalary;

    @Column(nullable = false, name="tax_rate")
    private String taxRate;

    @Column(nullable = false, length = 5, name = "tax_id")
    private String taxId;

    @Column(nullable = false, length = 2, name = "tax_due")
    private Integer taxDue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getSortCode(){
        return sortCode;
    }

    public void setSortCode(String sortCode){
        this.sortCode = sortCode;
    }

    public String getBankName(){
        return bankName;
    }

    public void setBankName(String bankName){
        this.bankName = bankName;
    }

    public Integer getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Integer netSalary) {
        this.netSalary = netSalary;
    }

    public Integer getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Integer grossSalary) {
        this.grossSalary = grossSalary;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Integer getTaxDue() {
        return taxDue;
    }

    public void setTaxDue(Integer taxDue) {
        this.taxDue = taxDue;
    }
}
