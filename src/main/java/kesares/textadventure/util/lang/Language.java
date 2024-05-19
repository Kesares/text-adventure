package kesares.textadventure.util.lang;

public enum Language {

    EN_US("en_us"),
    DE_DE("de_de");

    private final String abbreviation;

    Language(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
