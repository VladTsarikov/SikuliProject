package roomstyler.pages.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.*;

public class WelcomeWindowForm extends BaseForm {

    private final static String MAIN_LOCATOR = "//li[contains(@class,'tutorial')]";
    private final Button btnCloseWelcomeWindow = new Button(By.xpath("//a[contains(@class,'popin-close')]"), "Close Welcome Window Button");

    public WelcomeWindowForm() {
        super(By.xpath(MAIN_LOCATOR),"Welcome Window Form" );
    }

    public void clickCloseWindowButton(){
        btnCloseWelcomeWindow.clickAndWait();
    }
}
