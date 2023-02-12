package enums;

public enum EndPoint {
    BASEURL ("https://restful-booker.herokuapp.com");

    private final String value;

    EndPoint(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
