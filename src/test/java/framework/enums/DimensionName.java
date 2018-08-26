package framework.enums;

public enum DimensionName {

    HEIGHT("H"),
    WIDTH("W"),
    DEPTH("D");

    private String dimensionFirstLetter;

    DimensionName(String dimensionFirstLetter) {
        this.dimensionFirstLetter = dimensionFirstLetter;
    }

    public String getDimensionFirstChar() {
        return dimensionFirstLetter;
    }
}
