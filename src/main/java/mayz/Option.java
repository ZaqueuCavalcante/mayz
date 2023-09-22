package mayz;

public enum Option {
    MINI("00_mini"),
    SMALL("01_small"),
    BLUE_PEN("02_blue_pen"),
    MONA_LISA("03_mona_lisa"),
    RANDOM("04_random"),
    EMPTY("05_empty");
 
    private String value;
 
    Option(String value) {
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }
}
