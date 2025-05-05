package mayz;

public enum Option {
    MINI("00_mini"),
    SMALL("01_small"),
    BLUE_PEN("02_blue_pen"),
    MONA_LISA("03_mona_lisa"),
    RANDOM("04_random"),
    EMPTY("05_empty"),
    PAC_MAN("06_pac_man"),
    RANDOM100x100("07_random_100x100"),
    RANDOM500x500("08_random_500x500"),
    RANDOM1000x1000("09_random_1000x1000");

    private String value;

    Option(String value) {
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }
}
