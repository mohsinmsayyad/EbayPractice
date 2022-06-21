package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EbayMainPage {
    WebDriver driver;

    //POM model
    By searchField = By.id("gh-ac");
    By searchButton = By.id("gh-btn");

    public EbayMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void findProduct(String productName)
    {
        driver.findElement(searchField).sendKeys(productName);
    }

    public void clickSearchButton()
    {
        driver.findElement(searchButton).click();
    }

}
