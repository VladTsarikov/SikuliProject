package webdriver;

import framework.enums.MainLeftMenuLabel;
import org.openqa.selenium.By;
import webdriver.elements.Label;

public abstract class BaseMenu {

    public abstract void clickMenuLabel(Enum mainLeftMenuLabel, String menuLabel);
}
