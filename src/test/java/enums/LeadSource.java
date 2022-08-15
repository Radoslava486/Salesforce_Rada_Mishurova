package enums;

public enum LeadSource {
    ADVERTISEMENT("Advertisement"),
    EMPLOYEEREFERRAL("Employee Referral"),
    EXTERNALREFERRAL("External Referral"),
    INSTORE("In - Store"),
    ONSITE("On Site"),
    OTHER("Other"),
    SOCIAL("Social"),
    TRADESHOW("Trade Show"),
    WEB("Web"),
    WORDOFMOUTH("Word of mouth");

    private final String name;

    LeadSource(String name) {
        this.name = name;
    }

    public static LeadSource fromString(String value) {
        for (LeadSource contactLeadSource : LeadSource.values()) {
            if (contactLeadSource.getName().equals(value)) {
                return contactLeadSource;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}
