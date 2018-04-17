package lesson3;

import core.ArticlePage;
import core.BaseFunc;
import core.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DelfiTest {
    private BaseFunc baseFunc = new BaseFunc();

    private static final String TITLE = "Olimpiskā uguns nodziest – Phjončhanas ziemas olimpiskās spēles ir noslēgušās";
    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv";
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv";

    private static final Logger LOGGER = LogManager.getLogger(DelfiTest.class);

    @Test
    public void getArticle() {

        LOGGER.info("We are opening www.delfi.lv ");
        // Open main page on Web version
        baseFunc.getToUrl(MAIN_PAGE_WEB_URL);

        HomePage homePage = new HomePage(baseFunc);

        List<WebElement> articleTitles = homePage.getAllTitles();

        //Check if list is not empty
        assertTrue("Title list is empty", !articleTitles.isEmpty());

        //Go to the first article page
        ArticlePage articlePage = homePage.goToFirstArticle();

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
        BaseFunc.driver.quit();


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
