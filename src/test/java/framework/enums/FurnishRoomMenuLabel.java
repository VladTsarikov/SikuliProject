package framework.enums;

public enum FurnishRoomMenuLabel {

    BEDROOM("Bedroom"),
    CHRISTMAS("Christmas"),
    DINING_ROOM("Dining room");

    private String category;

    FurnishRoomMenuLabel(String category) {
        this.category = category;
    }

    public String getMenuLabelCategory() {
        return category;
    }
}
