package models;

import enums.AccountType;
import enums.Industry;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder


public class Account {
    private String accountName;
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


    private String fullBillingAddress;
    private String fullShippingAddress;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountName, account.accountName) && Objects.equals(phone, account.phone) && Objects.equals(parentAccount, account.parentAccount) && Objects.equals(fax, account.fax) && Objects.equals(website, account.website) && type == account.type && industry == account.industry && Objects.equals(employees, account.employees) && Objects.equals(annualRevenue, account.annualRevenue) && Objects.equals(getFullBillingAddress(), account.getFullBillingAddress()) && Objects.equals(getFullShippingAddress(), account.getFullShippingAddress()) && Objects.equals(description, account.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, phone, parentAccount, fax, website, type, industry, employees, annualRevenue, billingStreet, shippingStreet, billingCity, shippingCity, billingStateProvince, shippingStateProvince, billingZipPostalCode, shippingZipPostalCode, billingCountry, shippingCountry, description, shippingAddress, billingAddress);
    }

    public String getFullBillingAddress(String billingStreet, String billingCity, String billingCountry,
                                   String billingStateProvince, String billingZipPostalCode) {
        StringBuilder fullBillingAddress = new StringBuilder();

        if (!(billingStreet == null)) {
            fullBillingAddress.append("\n").append(billingStreet);
        }
        if (!(billingCity == null)) {
            fullBillingAddress.append(billingCity);
        }
        if (!(billingStateProvince == null)) {
            fullBillingAddress.append(", ").append(billingStateProvince);
        }
        if (!(billingZipPostalCode == null)) {
            fullBillingAddress.append(" ").append(billingZipPostalCode);
        }
        if (!(billingCountry == null)) {
            fullBillingAddress.append("\n").append(billingCountry);
        }
        return fullBillingAddress.toString().trim();
    }

    public String getFullShippingAddress(String shippingStreet, String shippingCity, String shippingCountry,
                                        String shippingStateProvince, String shippingZipPostalCode) {
        StringBuilder fullShippingAddress = new StringBuilder();

        if (!(shippingStreet == null)) {
            fullShippingAddress.append("\n").append(shippingStreet);
        }
        if (!(shippingCity == null)) {
            fullShippingAddress.append(shippingCity);
        }
        if (!(shippingStateProvince == null)) {
            fullShippingAddress.append(", ").append(shippingStateProvince);
        }
        if (!(shippingZipPostalCode == null)) {
            fullShippingAddress.append(" ").append(shippingZipPostalCode);
        }
        if (!(shippingCountry == null)) {
            fullShippingAddress.append("\n").append(shippingCountry);
        }
        return fullShippingAddress.toString().trim();
    }
}
