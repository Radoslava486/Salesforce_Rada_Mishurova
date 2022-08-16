package models;

import enums.LeadSource;
import enums.Salutation;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Data
@Builder
@Log4j2


public class Contact {

        private String firstName;
        private String lastName;
        private Salutation salutation;
        private String fullName;
        private String accountName;
        private String phone;
        private String mobile;
        private String email;
        private String title;
        private String reportsTo;
        private String mailingStreet;
        private String mailingCity;
        private String mailingState;
        private String mailingZip;
        private String mailingCountry;
        private String otherStreet;
        private String otherCity;
        private String otherState;
        private String otherZip;
        private String otherCountry;
        private String fax;
        private String homePhone;
        private String otherPhone;
        private String asstPhone;
        private String assistant;
        private String department;
        private LeadSource leadSource;
        private String birthdate;
        private String description;
        private String mailingAddress;
        private String otherAddress;

        private String fullMailingAddress;
        private String fullOtherAddress;


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
                return result;
        }

        public String getFullMailingAddress(String mailingStreet, String mailingCity, String mailingCountry,
                                            String mailingState, String mailingZip) {
                StringBuilder fullMailingAddress = new StringBuilder();

                if (!(mailingStreet == null)) {
                        fullMailingAddress.append("\n").append(mailingStreet);
                }
                if (!(mailingCity == null)) {
                        fullMailingAddress.append(mailingCity);
                }
                if (!(mailingState == null)) {
                        fullMailingAddress.append(", ").append(mailingState);
                }
                if (!(mailingZip == null)) {
                        fullMailingAddress.append(" ").append(mailingZip);
                }
                if (!(mailingCountry == null)) {
                        fullMailingAddress.append("\n").append(mailingCountry);
                }
                return fullMailingAddress.toString().trim();
        }

        public String getFullOtherAddress(String otherStreet, String otherCity, String otherCountry,
                                             String otherState, String otherZip) {
                StringBuilder fullOtherAddress = new StringBuilder();

                if (!(otherStreet == null)) {
                        fullOtherAddress.append("\n").append(otherStreet);
                }
                if (!(otherCity == null)) {
                        fullOtherAddress.append(otherCity);
                }
                if (!(otherState == null)) {
                        fullOtherAddress.append(", ").append(otherState);
                }
                if (!(otherZip == null)) {
                        fullOtherAddress.append(" ").append(otherZip);
                }
                if (!(otherCountry == null)) {
                        fullOtherAddress.append("\n").append(otherCountry);
                }
                return fullOtherAddress.toString().trim();

        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Contact contact = (Contact) o;
                return Objects.equals(getFullName(), contact.getFullName()) && Objects.equals(accountName, contact.accountName) && Objects.equals(phone, contact.phone) && Objects.equals(mobile, contact.mobile) && Objects.equals(email, contact.email) && Objects.equals(title, contact.title) && Objects.equals(reportsTo, contact.reportsTo) && Objects.equals(fax, contact.fax) && Objects.equals(homePhone, contact.homePhone) && Objects.equals(otherPhone, contact.otherPhone) && Objects.equals(asstPhone, contact.asstPhone) && Objects.equals(assistant, contact.assistant) && Objects.equals(department, contact.department) && leadSource == contact.leadSource && Objects.equals(birthdate, contact.birthdate) && Objects.equals(description, contact.description) && Objects.equals(getFullMailingAddress(), contact.getFullMailingAddress()) && Objects.equals(getFullOtherAddress(), contact.getFullOtherAddress());
        }

        @Override
        public int hashCode() {
                return Objects.hash(fullName, accountName, phone, mobile, email, title, reportsTo, fax, homePhone, otherPhone, asstPhone, assistant, department, leadSource, birthdate, description, mailingAddress, otherAddress);
        }
}




