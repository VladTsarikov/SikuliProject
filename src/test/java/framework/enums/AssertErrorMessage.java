package framework.enums;

public enum AssertErrorMessage {

    NOT_ZERO_FURNITURE_ITEM("Furniture Item %s not zero"),
    ZERO_FURNITURE_DIMENSION("Dimension %s has zero");

    private String message;

    AssertErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
