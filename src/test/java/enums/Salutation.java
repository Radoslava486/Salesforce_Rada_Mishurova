package enums;


    public enum Salutation {
        MR("Mr."),
        MS("Ms."),
        MRS("Mrs."),
        DR("Dr."),
        PROF("Prof.");

        private final String name;

        Salutation(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static Salutation fromString(String value) {
            for (Salutation contactSalutation : Salutation.values()) {
                if (contactSalutation.getName().equals(value)) {
                    return contactSalutation;
                }
            }
            return null;
        }
    }

