package framework.enums;

public enum MainLeftMenuLabel {

    BUILD_LAYOUT("build"),
    FURNISH_ROOM("furnish"),
    DECORATE_ROOM("decorate");

    private String category;

    MainLeftMenuLabel(String category) {
        this.category = category;
    }

    public String getMenuLabelCategory() {
        return category;
    }
}
