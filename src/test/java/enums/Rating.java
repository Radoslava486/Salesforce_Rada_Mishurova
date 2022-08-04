package enums;

public enum Rating {
    HOT("Hot"), WARM("Warm"), COLD("Cold");

    private final String name;

    Rating(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Rating fromString(String value) {
        for (Rating contactRating : Rating.values()) {
            if (contactRating.getName().equals(value)) {
                return contactRating;
            }
        }
        return null;
    }
}


