package aaa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class aaa {
    private static final String TITLE = "Ликвидация ABLV: в субботу вкладчикам выплачено 5,9 млн евро";
    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv";
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv";
    private static final By ARTICLE_TITLE = By.xpath("//a[@class='top2012-title']");
    private static final By RUS = By.xpath(".//*[@itemprop = 'name' and text()=\"РУС\"]");


    @Test
    public void getArticle() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open main page on Web version
        driver.get(MAIN_PAGE_WEB_URL);
        driver.findElement(RUS).click();

    }
}

