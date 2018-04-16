package lesson3;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DelfiTest {
    private static final String TITLE = "Olimpiskā uguns nodziest – Phjončhanas ziemas olimpiskās spēles ir noslēgušās";
    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv";
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv";
    private static final By ARTICLE_TITLE = By.xpath("//a[@class='top2012-title']");
    private static final Logger LOGGER = LogManager.getLogger(DelfiTest.class);

    @Test
    public void getArticle() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LOGGER.info("We are staring our test");
        // Open main page on Web version
        driver.get(MAIN_PAGE_WEB_URL);

        //Find all titles and add them to a list !
        List<WebElement> articleTitles = driver.findElements(ARTICLE_TITLE);

        //Check if list is not empty
        assertTrue("Title iist is empty", !articleTitles.isEmpty());
        //Go through a list and get text from web element
        boolean isTitlePresent = false;
        for (WebElement articleTitle : articleTitles) {

            //Compare every string element in TITLE variable
            if (articleTitle.getText().equals(TITLE)) {
                isTitlePresent = true;
                break;
            }
            //Exit loop in case if TITLE present

        }
        //If we don't find matches for TITLE variable create message "Element not found"
        assertTrue("No article found", isTitlePresent);
        //Close browser window
        driver.quit();


        // Open main page on Mobile version
        driver.get(MAIN_PAGE_MOBILE_URL);
        // Find all titles and add them to a list
        List<WebElement> articleTitlesMob = driver.findElements(ARTICLE_TITLE);
        //Check if list is not empty
        assertTrue("Title iist is empty", !articleTitlesMob.isEmpty());
        //Go through a list and get text from web element
        //Compare every string element in TITLE variable
        ////Exit loop in case if TITLE present
        //If we don't find matches for TITLE variable create message "Element not found"
        //Close browser window
        driver.quit();
    }
}
