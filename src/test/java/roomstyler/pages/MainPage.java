package roomstyler.pages;

import framework.RegularExpFinder;
import org.sikuli.script.Region;
import sikuli.SikuliElement;
import framework.enums.*;
import org.openqa.selenium.By;
import roomstyler.pages.menu.*;
import webdriver.BaseForm;
import webdriver.elements.*;

public class MainPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@id,'view-render')]";
    private final static String FURNITURE_ITEM_PATH = "//div[contains(@class,'scene')]//b[contains(@class,'%sCount')]";
    private LeftMainMenu LeftMainMenu = new LeftMainMenu();
    private LeftFurnishRoomMenu leftFurnishRoomMenu = new LeftFurnishRoomMenu();
    private final Label lblFurnitureDimensions = new Label(By.xpath("//p[contains(@class,'dimensions')]"), "Product Dimensions Label");
    private final Label lblFurnitureName = new Label(By.xpath("//div[contains(@class,'component-data')]//p[contains(@class,'name')]"), "Furniture Name Label");

    public MainPage() {
        super(By.xpath(MAIN_LOCATOR), "RoomStyler Main Page");
    }

    public void dragFurnitureElementToWorkPlace(Region region, String elementImageName, String elementName){
        new SikuliElement(elementImageName,elementName).dragAndDrop(region);
    }

    public boolean isFurnitureElementExistsOnWorkPlace(String elementImageName, String elementName){
       return new SikuliElement(elementImageName,elementName).isElementExists();
    }

    public void clickOnWorkPlaceElement(String elementImageName, String elementName){
        new SikuliElement(elementImageName,elementName).clickOnElement();
    }

    public void deleteElementFromWorkPlace(Region region, String elementImageName, String elementName){
        new SikuliElement(elementImageName,elementName).clickOnRegionElement(region);
    }

    public double getFurnitureDimension(RegularExpression regularExpression, DimensionName dimensionName){
        return Double.parseDouble(RegularExpFinder.findByRegularExp(lblFurnitureDimensions.getText(),
                String.format(regularExpression.getRegExp(),dimensionName.getDimensionFirstChar())));
    }

    public String getFurnitureName(){ return lblFurnitureName.getText(); }

    public int getFurnitureItemsCount(FurnitureItem furnitureItem){
        return Integer.parseInt(new Label(By.xpath(String.format(FURNITURE_ITEM_PATH,furnitureItem.getFurnitureItemCategory())),
                    "Furniture "+ furnitureItem.getFurnitureItemCategory() +" count label").getText());
    }

    public roomstyler.pages.menu.LeftMainMenu getLeftMainMenu() { return LeftMainMenu; }

    public LeftFurnishRoomMenu getLeftFurnishRoomMenu() { return leftFurnishRoomMenu; }
}