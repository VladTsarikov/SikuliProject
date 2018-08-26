package framework.enums;

public enum FurnitureItem {

    WALLS("walls"),
    DOORS("doors"),
    WINDOWS("windows"),
    PRODUCTS("components"),
    MATERIALS("materials");

    private String category;

    FurnitureItem(String category) {
        this.category = category;
    }

    public String getFurnitureItemCategory() {
        return category;
    }
}
