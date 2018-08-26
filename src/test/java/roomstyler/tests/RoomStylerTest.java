package roomstyler.tests;

import framework.enums.*;
import org.sikuli.script.Region;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import roomstyler.pages.*;
import roomstyler.pages.forms.WelcomeWindowForm;
import webdriver.BaseTest;
import static framework.enums.FurnishRoomMenuLabel.*;
import static framework.enums.MainLeftMenuLabel.*;
import static org.testng.Assert.*;

public class RoomStylerTest extends BaseTest {

    private Region workPlaceRegion = new Region(500,450,200,200);
    private SoftAssert softAssert = new SoftAssert();
    private final static int ZERO = 0;
    private String furnitureName;
    private String mainViewElementImage;
    private String mainViewElementName;
    private String compareViewElementImage;
    private String compareViewElementName;
    private String deleteButtonElementImage;
    private String deleteButtonElementName;

    @Parameters({"furnitureName","mainViewElementImage", "mainViewElementName","compareViewElementImage",
            "compareViewElementName", "deleteButtonElementImage","deleteButtonElementName"})
    @BeforeClass
    public void initParams(String furnitureName, String mainViewElementImage, String mainViewElementName,
                           String compareViewElementImage, String compareViewElementName,
                           String deleteButtonElementImage, String deleteButtonElementName){
        this.furnitureName = furnitureName;
        this.mainViewElementImage = mainViewElementImage;
        this.mainViewElementName = mainViewElementName;
        this.compareViewElementImage = compareViewElementImage;
        this.compareViewElementName = compareViewElementName;
        this.deleteButtonElementImage = deleteButtonElementImage;
        this.deleteButtonElementName = deleteButtonElementName;
    }

    @Override
    public void runTest() {
        logStep(1,"OPENING roomstyler.com...");
        WelcomeWindowForm welcomeWindowForm = new WelcomeWindowForm();

        logStep(2,"CLOSE WELCOME FORM AND SELECT FURNISH ROOM LABEL...");
        welcomeWindowForm.clickCloseWindowButton();

        logStep(3,"SELECT FURNISH ROOM LABEL...");
        MainPage mainPage = new MainPage();
        mainPage.getLeftMainMenu().clickMenuLabel(FURNISH_ROOM,mainPage.getLeftMainMenu().getMenuLabel());

        logStep(4,"SELECT DINING ROOM LABEL...");
        mainPage.getLeftFurnishRoomMenu().clickMenuLabel(DINING_ROOM,mainPage.getLeftFurnishRoomMenu().getMenuLabel());

        logStep(5,"DRAG FURNITURE ELEMENT ON THE WORK PLACE...");
        mainPage.dragFurnitureElementToWorkPlace(workPlaceRegion,mainViewElementImage,mainViewElementName);

        logStep(6,"VERIFY IF FURNITURE DRAG ON THE WORK PLACE...");
        assertTrue(mainPage.isFurnitureElementExistsOnWorkPlace(compareViewElementImage,compareViewElementName),
                "Furniture has not found on work place");

        logStep(7,"CLICK ON FURNITURE ELEMENT AND VERIFY FURNITURE NAME AND DIMENSIONS...");
        mainPage.clickOnWorkPlaceElement(compareViewElementImage,compareViewElementName);
        assertEquals("Equals error: " + furnitureName + " not found",furnitureName, mainPage.getFurnitureName());
        softAssert.assertNotEquals(mainPage.getFurnitureDimension(RegularExpression.FURNITURE_ITEM_DIMENSION,DimensionName.HEIGHT),
                ZERO,getAssertErrorMessage(AssertErrorMessage.ZERO_FURNITURE_DIMENSION,"Height"));
        softAssert.assertNotEquals(mainPage.getFurnitureDimension(RegularExpression.FURNITURE_ITEM_DIMENSION,DimensionName.WIDTH),
                ZERO,getAssertErrorMessage(AssertErrorMessage.ZERO_FURNITURE_DIMENSION,"Width"));
        softAssert.assertNotEquals(mainPage.getFurnitureDimension(RegularExpression.FURNITURE_ITEM_DIMENSION,DimensionName.DEPTH),
                ZERO,getAssertErrorMessage(AssertErrorMessage.ZERO_FURNITURE_DIMENSION,"Depth"));

        logStep(8,"DELETE FURNITURE FROM WORK PLACE AND VERIFY FURNITURE ITEMS VALUE FOR ZERO...");
        mainPage.deleteElementFromWorkPlace(workPlaceRegion,deleteButtonElementImage,deleteButtonElementName);
        assertFalse(mainPage.isFurnitureElementExistsOnWorkPlace(compareViewElementImage,compareViewElementName),
                "Furniture has not deleted from work place");
        softAssert.assertEquals(mainPage.getFurnitureItemsCount(FurnitureItem.WALLS),
                ZERO,getAssertErrorMessage(AssertErrorMessage.NOT_ZERO_FURNITURE_ITEM,"Walls"));
        softAssert.assertEquals(mainPage.getFurnitureItemsCount(FurnitureItem.DOORS),
                ZERO,getAssertErrorMessage(AssertErrorMessage.NOT_ZERO_FURNITURE_ITEM,"Doors"));
        softAssert.assertEquals(mainPage.getFurnitureItemsCount(FurnitureItem.WINDOWS),
                ZERO,getAssertErrorMessage(AssertErrorMessage.NOT_ZERO_FURNITURE_ITEM,"Windows"));
        softAssert.assertEquals(mainPage.getFurnitureItemsCount(FurnitureItem.PRODUCTS),
                ZERO,getAssertErrorMessage(AssertErrorMessage.NOT_ZERO_FURNITURE_ITEM,"Products"));
        softAssert.assertEquals(mainPage.getFurnitureItemsCount(FurnitureItem.MATERIALS),
                ZERO,getAssertErrorMessage(AssertErrorMessage.NOT_ZERO_FURNITURE_ITEM,"Materials"));
    }

    private String getAssertErrorMessage(AssertErrorMessage assertErrorMessage, String subject){
       return String.format(assertErrorMessage.getErrorMessage(),subject);
    }
}