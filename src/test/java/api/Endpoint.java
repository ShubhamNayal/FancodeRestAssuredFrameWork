package api;
public enum Endpoint {
    USERS("users"),
    TODOS("todos");

    private final String value;

    Endpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}