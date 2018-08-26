package sikuli;

import org.sikuli.script.*;
import webdriver.PropertiesResourceManager;

public class SikuliUtils {

    private final static float SIMILAR_SHARE = (float) 0.85;
    private static PropertiesResourceManager prop = new PropertiesResourceManager("images_element.properties");

    public static Pattern getPattern(String pictureName){
        return new Pattern(String.format(prop.getProperty("mainPageImagesPath"),pictureName)).similar(SIMILAR_SHARE);
    }

    public static Screen getScreen(){
        return new Screen();
    }

    public static Screen getScreenRegion(Region region){
        return (Screen) region.getScreen();
    }
}
