package TestCases;

import Library.SelectBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EbayMainPage;
import pages.IndividualProductPage;
import pages.SearchResultPage;

import java.time.Duration;
public class EbayAddProductToCartTest {

    WebDriver driver;
    EbayMainPage ebayMainPage;
    SearchResultPage searchResultPage;
    IndividualProductPage individualProductPage;

    @BeforeTest
    public void launchBrowser()
    {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://ebay.com");
    }

    @Test(priority = 1)
    public void search_product_ebay_test()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ebayMainPage = new EbayMainPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        ebayMainPage.findProduct("MacBook Pro");
        ebayMainPage.clickSearchButton();

        String expectedSearchResult = "macbook pro:";
        String [] tempArray = driver.getTitle().split(" ");
        String actualSearchResult = tempArray[0] + " " + tempArray[1];
        Assert.assertEquals(actualSearchResult, expectedSearchResult);

    }

    @Test(priority = 2)
    public void click_on_latest_product_test()
    {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickOnCheckButton();
    }

    @Test(priority = 3)
    public void click_on_individual_product_test()
    {
        searchResultPage.clickOnIndividualProduct();
        individualProductPage = new IndividualProductPage(driver);
        individualProductPage.clickOnButton();
    }

}