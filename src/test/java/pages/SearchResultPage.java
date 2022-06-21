package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
//page factory
WebDriver driver;

    //Page Factory
    //$x("//li[@class='x-refine__main__list--value'][1]/div/a/div/span/input")
    @FindBy(xpath ="//li[@class='x-refine__main__list--value'][1]/div/a/div/span/input")
    List<WebElement> checkButtonList;

    //$x("//div[@class='s-item__info clearfix']/a")
    //$x("//div[@class='s-item__image-wrapper']/img")
    //$x("//div[@class='s-item__image-wrapper']/img/ancestor::a")
    //$x("//a[@class='s-item__link']")

    @FindBy(xpath = "//a[@class='s-item__link']")
    List<WebElement> linkOfProduct;


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckButton()
    {
        WebElement webElement = checkButtonList.get(0);
        webElement.click();
    }

    public void clickOnIndividualProduct()
    {
        WebElement webElement = linkOfProduct.get(1);
        String link = webElement.getAttribute("href");
        driver.navigate().to(link);
    }

}