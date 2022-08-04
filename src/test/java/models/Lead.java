package models;

import enums.*;

import java.util.Objects;

public class Lead {
    private final String firstName;
    private final String lastName;
    private final String company;
    private final Salutation salutation;
    private final String title;
    private final String email;
    private  final String phone;
    private final LeadStatus leadStatus;
    private final Rating rating;
    private final String street;
    private final String city;
    private final String state;
    private final String country;
    private final String website;
    private final String zipcode;
    private final String numberOfEmployees;
    private final String annualRevenue;
    private final LeadSource leadSource;
    private final Industry industry;
    private final String description;
    private final String fullName;




    private Lead(LeadBuilder leadBuilder){
        this.firstName = leadBuilder.firstName;
        this.lastName = leadBuilder.lastName;
        this.company = leadBuilder.company;
        this.salutation = leadBuilder.salutation;
        this.title = leadBuilder.title;
        this.email = leadBuilder.email;
        this.phone = leadBuilder.phone;
        this.leadStatus = leadBuilder.leadStatus;
        this.rating = leadBuilder.rating;
        this.street = leadBuilder.street;
        this.city = leadBuilder.city;
        this.state = leadBuilder.state;
        this.country = leadBuilder.country;
        this.website = leadBuilder.website;
        this.zipcode = leadBuilder.zipcode;
        this.numberOfEmployees = leadBuilder.numberOfEmployees;
        this.annualRevenue = leadBuilder.annualRevenue;
        this.leadSource = leadBuilder.leadSource;
        this.industry = leadBuilder.industry;
        this.description = leadBuilder.description;
        this.fullName = leadBuilder.fullName;
    }

    public String getFullName() {return fullName;}
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCompany() {
        return company;
    }

    public Salutation getSalutation() {
        return salutation;
    }
    public String getTitle() {
        return title;
    }
    public String getEmail() {
        return email;
    }
    public String getCity() {
        return city;
    }
    public String getPhone() {
        return phone;
    }
    public LeadStatus getLeadStatus() {
        return leadStatus;
    }
    public String getStreet() {
        return street;
    }
    public String getState() {
        return state;
    }
    public String getCountry() {
        return country;
    }
    public String getWebsite() {
        return website;
    }
    public String getZipcode() {
        return zipcode;
    }
    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }
    public String getAnnualRevenue() {
        return annualRevenue;
    }
    public LeadSource getLeadSource() {
        return leadSource;
    }
    public Industry getIndustry() {
        return industry;
    }
    public String getDescription() {
        return description;
    }
    public Rating getRating() {return rating;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return zipcode == lead.zipcode && numberOfEmployees == lead.numberOfEmployees && Objects.equals(company, lead.company)  && Objects.equals(title, lead.title) && Objects.equals(email, lead.email) && Objects.equals(phone, lead.phone) && leadStatus == lead.leadStatus && rating == lead.rating && Objects.equals(street, lead.street) && Objects.equals(city, lead.city) && Objects.equals(state, lead.state) && Objects.equals(country, lead.country) && Objects.equals(website, lead.website) && Objects.equals(annualRevenue, lead.annualRevenue) && leadSource == lead.leadSource && industry == lead.industry && Objects.equals(description, lead.description) && Objects.equals(fullName, lead.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, company, salutation, title, email, phone, leadStatus, rating, street, city, state, country, website, zipcode, numberOfEmployees, annualRevenue, leadSource, industry, description, fullName);
    }

    @Override
    public String toString() {
        return "Lead{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", salutation=" + salutation +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", leadStatus=" + leadStatus +
                ", rating=" + rating +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", website='" + website + '\'' +
                ", zipcode=" + zipcode +
                ", numberOfEmployees=" + numberOfEmployees +
                ", annualRevenue='" + annualRevenue + '\'' +
                ", leadSource=" + leadSource +
                ", industry=" + industry +
                ", description='" + description + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public static class LeadBuilder{
        private String firstName;
        private String lastName;
        private final String company;
        private Salutation salutation;
        private String title;
        private String email;
        private String phone;
        private final LeadStatus leadStatus;
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


        public LeadBuilder(String company, LeadStatus leadStatus ){
            this.company = company;
            this.leadStatus = leadStatus;

        }
        public LeadBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public LeadBuilder lastName (String laststName) {
            this.lastName = lastName;
            return this;
        }

        public LeadBuilder firstName (String firstName) {
            this.firstName = firstName;
            return this;
        }
        public LeadBuilder email(String email) {
            this.email = email;
            return this;
        }

        public LeadBuilder title(String title) {
            this.title = title;
            return this;
        }

        public LeadBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public LeadBuilder salutation(Salutation salutation) {
            this.salutation = salutation;
            return this;
        }
        public LeadBuilder rating(Rating rating) {
            this.rating = rating;
            return this;
        }
        public LeadBuilder street(String street) {
            this.street = street;
            return this;
        }
        public LeadBuilder city(String city) {
            this.city = city;
            return this;
        }
        public LeadBuilder state(String state) {
            this.state = state;
            return this;
        }
        public LeadBuilder country(String country) {
            this.country = country;
            return this;
        }
        public LeadBuilder website(String website) {
            this.website = website;
            return this;
        }
        public LeadBuilder annualRevenue(String annualRevenue) {
            this.annualRevenue = annualRevenue;
            return this;
        }
        public LeadBuilder numberOfEmployees(String numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
            return this;
        }
        public LeadBuilder description(String description) {
            this.description = description;
            return this;
        }

        public LeadBuilder zipcode (String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public LeadBuilder industry(Industry industry) {
            this.industry = industry;
            return this;
        }
        public LeadBuilder leadSource(LeadSource leadSource) {
            this.leadSource = leadSource;
            return this;
        }
        public String getFullName() {
            if (this.fullName != null) {
                return this.fullName;
            } else {
                return (this.salutation.getName() + " " + this.firstName + " " + this.lastName).trim();
            }
        }


        public Lead build(){
            return new Lead(this);
        }
    }
}
