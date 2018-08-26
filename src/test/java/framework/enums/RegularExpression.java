package framework.enums;

public enum RegularExpression {

    FURNITURE_ITEM_DIMENSION("%s(\\d*\\.\\d*)");

    private String regExp;

    RegularExpression(String regExp) {
        this.regExp = regExp;
    }

    public String getRegExp() {
        return regExp;
    }
}