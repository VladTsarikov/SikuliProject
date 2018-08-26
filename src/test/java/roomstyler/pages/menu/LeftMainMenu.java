package roomstyler.pages.menu;

import framework.enums.*;
import org.openqa.selenium.By;
import webdriver.BaseMenu;
import webdriver.elements.*;

public class LeftMainMenu {

    private String menuLabel = "//li[contains(@class,'tab %s')]";

    public void clickLeftMainMenuLabel(MainLeftMenuLabel mainLeftMenuLabel) {
        new Label(By.xpath(String.format(menuLabel, mainLeftMenuLabel.getMenuLabelCategory())),
                mainLeftMenuLabel.getMenuLabelCategory() + " Label").clickAndWait();
    }

    public String getMenuLabel() {
        return menuLabel;
    }
}
