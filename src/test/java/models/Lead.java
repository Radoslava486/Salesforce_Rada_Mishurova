package models;

import enums.*;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder

public class Lead {
    private String firstName;
    private String lastName;
    private String company;
    private Salutation salutation;
    private String title;
    private String email;
    private String phone;
    private LeadStatus leadStatus;
    private Rating rating;
    private String street;
    private String city;
    private String state;
    private String country;
    private String website;
    private String zipcode;
    private String numberOfEmployees;
    private String annualRevenue;
    private LeadSource leadSource;
    private Industry industry;
    private String description;
    private String fullName;


    public String getFullName() {
        String result;
        if (this.fullName != null) {
            result = this.fullName;
        } else {
            String salutation = Objects.nonNull(this.salutation) ? this.salutation.getName() : "";
            String firstName = Objects.nonNull(this.firstName) ? this.firstName : "";
            String lastName = Objects.nonNull(this.lastName) ? this.lastName : "";
            result = (salutation + " " + firstName + " " + lastName).replaceAll("\\s+", " ").trim();
        }
        System.out.println(result);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return Objects.equals(company, lead.company) && Objects.equals(title, lead.title) && Objects.equals(email, lead.email) && Objects.equals(phone, lead.phone) && leadStatus == lead.leadStatus && rating == lead.rating && Objects.equals(street, lead.street) && Objects.equals(city, lead.city) && Objects.equals(state, lead.state) && Objects.equals(country, lead.country) && Objects.equals(website, lead.website) && Objects.equals(zipcode, lead.zipcode) && Objects.equals(numberOfEmployees, lead.numberOfEmployees) && Objects.equals(annualRevenue, lead.annualRevenue) && leadSource == lead.leadSource && industry == lead.industry && Objects.equals(description, lead.description) && Objects.equals(getFullName(), lead.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, title, email, phone, leadStatus, rating, street, city, state, country, website, zipcode, numberOfEmployees, annualRevenue, leadSource, industry, description, fullName);
    }
}



