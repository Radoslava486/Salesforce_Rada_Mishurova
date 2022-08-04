package enums;

public enum LeadStatus {
    NEW("New"), CONTACTED("Contacted"), WORKING("Working"),
    QUALIFIED("Qualified"), UNQUALIFIED("Unqualified");

    private final String name;

    LeadStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static LeadStatus fromString(String value) {
        for (LeadStatus contactLeadStatus : LeadStatus.values()) {
            if (contactLeadStatus.getName().equals(value)) {
                return contactLeadStatus;
            }
        }
        return null;
    }
}


