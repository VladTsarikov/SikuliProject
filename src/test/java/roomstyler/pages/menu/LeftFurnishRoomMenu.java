package roomstyler.pages.menu;

import framework.enums.FurnishRoomMenuLabel;
import org.openqa.selenium.By;
import webdriver.BaseMenu;
import webdriver.elements.Label;

public class LeftFurnishRoomMenu {

    private String menuLabel = "//li//a[contains(text(),'%s')]";

    public void clickLeftFurnishRoomMenuLabel(FurnishRoomMenuLabel furnishRoomMenuLabel) {
        new Label(By.xpath(String.format(menuLabel, furnishRoomMenuLabel.getMenuLabelCategory())),
                furnishRoomMenuLabel.getMenuLabelCategory() + " Label").clickAndWait();
    }

    public String getMenuLabel() {
        return menuLabel;
    }
}
