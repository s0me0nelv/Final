package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private static final By ARTICLE_TITLE = By.xpath("//a[@class='top2012-title']");
    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> getAllTitles() {


        //Find all titles and add them to a list!
        return baseFunc.getElements(ARTICLE_TITLE);
    }

    public ArticlePage goToFirstArticle() {
        Assert.assertTrue("There is no articles", !getAllTitles().isEmpty());
        WebElement firstArcicle = getAllTitles().get(0);
        firstArcicle.click();
        return new ArticlePage(baseFunc);


    }

}



