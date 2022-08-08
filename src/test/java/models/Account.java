package models;

import enums.*;

import java.util.Objects;

public class Account {
    private final String accountName;
    private final String phone;
    private final String parentAccount;
    private final String fax;
    private final String website;
    private final AccountType type;
    private final Industry industry;
    private final String employees;
    private final String annualRevenue;
    private final String billingStreet;
    private final String shippingStreet;
    private final String billingCity;
    private final String shippingCity;
    private final String billingStateProvince;
    private final String shippingStateProvince;
    private final String billingZipPostalCode;
    private final String shippingZipPostalCode;
    private final String billingCountry;
    private final String shippingCountry;
    private final String description;
    private final String shippingAddress;
    private final String billingAddress;



    private Account(AccountBuilder accountBuilder) {
        this.accountName = accountBuilder.accountName;
        this.phone = accountBuilder.phone;
        this.parentAccount = accountBuilder.parentAccount;
        this.fax = accountBuilder.fax;
        this.website = accountBuilder.website;
        this.type = accountBuilder.type;
        this.industry = accountBuilder.industry;
        this.employees = accountBuilder.employees;
        this.annualRevenue = accountBuilder.annualRevenue;
        this.billingStreet = accountBuilder.billingStreet;
        this.shippingStreet = accountBuilder.shippingStreet;
        this.billingCity = accountBuilder.billingCity;
        this.shippingCity = accountBuilder.shippingCity;
        this.billingStateProvince = accountBuilder.billingStateProvince;
        this.shippingStateProvince = accountBuilder.shippingStateProvince;
        this.billingZipPostalCode = accountBuilder.billingZipPostalCode;
        this.shippingZipPostalCode = accountBuilder.shippingZipPostalCode;
        this.billingCountry = accountBuilder.billingCountry;
        this.shippingCountry = accountBuilder.shippingCountry;
        this.description = accountBuilder.description;
        this.shippingAddress = accountBuilder.shippingAddress;
        this.billingAddress = accountBuilder.billingAddress;
    }

    public String getWebsite() {
        return website;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public String getFax() {
        return fax;
    }

    public String getEmployees() {
        return employees;
    }

    public Industry getIndustry() {
        return industry;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public String getBillingStateProvince() {
        return billingStateProvince;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getShippingStateProvince() {
        return shippingStateProvince;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getBillingZipPostalCode() {
        return billingZipPostalCode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public String getDescription() {
        return description;
    }

    public String getShippingZipPostalCode() {
        return shippingZipPostalCode;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public AccountType getType() {
        return type;
    }

    public String getAccountName() {
        return accountName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountName, account.accountName) && Objects.equals(phone, account.phone) && Objects.equals(parentAccount, account.parentAccount) && Objects.equals(fax, account.fax) && Objects.equals(website, account.website) && type == account.type && industry == account.industry && Objects.equals(employees, account.employees) && Objects.equals(annualRevenue, account.annualRevenue) && Objects.equals(billingStreet, account.billingStreet) && Objects.equals(shippingStreet, account.shippingStreet) && Objects.equals(billingCity, account.billingCity) && Objects.equals(shippingCity, account.shippingCity) && Objects.equals(billingStateProvince, account.billingStateProvince) && Objects.equals(shippingStateProvince, account.shippingStateProvince) && Objects.equals(billingZipPostalCode, account.billingZipPostalCode) && Objects.equals(shippingZipPostalCode, account.shippingZipPostalCode) && Objects.equals(billingCountry, account.billingCountry) && Objects.equals(shippingCountry, account.shippingCountry) && Objects.equals(description, account.description) && Objects.equals(shippingAddress, account.shippingAddress) && Objects.equals(billingAddress, account.billingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, phone, parentAccount, fax, website, type, industry, employees, annualRevenue, billingStreet, shippingStreet, billingCity, shippingCity, billingStateProvince, shippingStateProvince, billingZipPostalCode, shippingZipPostalCode, billingCountry, shippingCountry, description, shippingAddress, billingAddress);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", phone='" + phone + '\'' +
                ", parentAccount='" + parentAccount + '\'' +
                ", fax='" + fax + '\'' +
                ", website='" + website + '\'' +
                ", type=" + type +
                ", industry=" + industry +
                ", employees='" + employees + '\'' +
                ", annualRevenue='" + annualRevenue + '\'' +
                ", billingStreet='" + billingStreet + '\'' +
                ", shippingStreet='" + shippingStreet + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                ", billingStateProvince='" + billingStateProvince + '\'' +
                ", shippingStateProvince='" + shippingStateProvince + '\'' +
                ", billingZipPostalCode='" + billingZipPostalCode + '\'' +
                ", shippingZipPostalCode='" + shippingZipPostalCode + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", shippingCountry='" + shippingCountry + '\'' +
                ", description='" + description + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                '}';
    }









    public static class AccountBuilder{
        private final String accountName;
        private String phone;
        private String parentAccount;
        private String fax;
        private String website;
        private AccountType type;
        private Industry industry;
        private String employees;
        private String annualRevenue;
        private String billingStreet;
        private String shippingStreet;
        private String billingCity;
        private String shippingCity;
        private String billingStateProvince;
        private String shippingStateProvince;
        private String billingZipPostalCode;
        private String shippingZipPostalCode;
        private String billingCountry;
        private String shippingCountry;
        private String description;
        private String shippingAddress;
        private String billingAddress;




        public AccountBuilder(String accountName){
            this.accountName = accountName;
        }


        public AccountBuilder parentAccount(String parentAccount) {
            this.parentAccount = parentAccount;
            return this;
        }

        public AccountBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }


        public AccountBuilder fax(String fax) {
            this.fax = fax;
            return this;
        }
        public AccountBuilder website(String website) {
            this.website = website;
            return this;
        }
        public AccountBuilder accountType(AccountType type) {
            this.type = type;
            return this;
        }
        public AccountBuilder industry(Industry industry) {
            this.industry = industry;
            return this;
        }
        public AccountBuilder employees(String employees) {
            this.employees = employees;
            return this;
        }
        public AccountBuilder annualRevenue(String annualRevenue) {
            this.annualRevenue = annualRevenue;
            return this;
        }
        public AccountBuilder billingStreet(String billingStreet) {
            this.billingStreet = billingStreet;
            return this;
        }
        public AccountBuilder shippingStreet(String shippingStreet) {
            this.shippingStreet = shippingStreet;
            return this;
        }
        public AccountBuilder billingCity(String billingCity) {
            this.billingCity = billingCity;
            return this;
        }
        public AccountBuilder shippingCity(String shippingCity) {
            this.shippingCity = shippingCity;
            return this;
        }
        public AccountBuilder billingStateProvince(String billingStateProvince) {
            this.billingStateProvince = billingStateProvince;
            return this;
        }
        public AccountBuilder shippingStateProvince(String shippingStateProvince) {
            this.shippingStateProvince = shippingStateProvince;
            return this;
        }
        public AccountBuilder billingZipPostalCode(String billingZipPostalCode) {
            this.billingZipPostalCode = billingZipPostalCode;
            return this;
        }
        public AccountBuilder shippingZipPostalCode(String shippingZipPostalCode) {
            this.shippingZipPostalCode = shippingZipPostalCode;
            return this;
        }
        public AccountBuilder billingCountry(String billingCountry) {
            this.billingCountry = billingCountry;
            return this;
        }
        public AccountBuilder shippingCountry(String shippingCountry) {
            this.shippingCountry = shippingCountry;
            return this;
        }
        public AccountBuilder shippingAddress (String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }
        public AccountBuilder billingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }
        public AccountBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }
}

