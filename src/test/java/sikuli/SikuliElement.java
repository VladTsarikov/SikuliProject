package sikuli;

import org.sikuli.script.*;
import static jxl.biff.FormatRecord.logger;

public class SikuliElement {

    private Pattern pattern;
    private String name;

    public SikuliElement(String pictureName, String name) {
        pattern = SikuliUtils.getPattern(pictureName);
        this.name = name;
    }

    public void dragAndDrop(Region region){
        try {
            SikuliUtils.getScreen().dragDrop(pattern, region);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public boolean isElementExists(){
        try {
            SikuliUtils.getScreen().find(pattern);
            return true;
        } catch (FindFailed e) {
            logger.info("Element has not found");
            return false;
        }
    }

    public void clickOnElement(){
        try {
            SikuliUtils.getScreen().click(pattern);
        } catch (FindFailed findFailed) {
            logger.info("Element has not found");
        }
    }

    public void clickOnRegionElement(Region region){
        try {
            SikuliUtils.getScreenRegion(region).click(pattern);
        } catch (FindFailed findFailed) {
            logger.info("Element has not found");
        }
    }

    public String getName() {
        return name;
    }
}
