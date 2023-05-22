package StepDefinitions;

import Pages.ShoppingElements;
import Utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static Utilities.BaseDriver.driver;

public class ShoppingSteps {

    ShoppingElements se = new ShoppingElements();

    @When("Search for product")
    public void searchForProduct() {
        se.sendKeysFunction(se.getWebElement("searchInput"), "laptop");
        se.clickFunction(se.getWebElement("searchButton"));
    }

    @And("Apply filter for product")
    public void applyFilterForProduct() {
        se.scrollToElement(se.getWebElement("brand"));
        List<WebElement> bosluk = driver.findElements(By.cssSelector("[class='overlay']"));
        if (bosluk.size() > 0) {
            bosluk.get(0).click();
        }
//        driver.navigate().refresh();
        BaseDriver.waitDriver(5);
        se.clickFunction(se.getWebElement("brand"));
        se.clickFunction(se.getWebElement("ramButton"));
        se.clickFunction(se.getWebElement("ram"));

    }

    @And("Click on the product and add to cart")
    public void clickOnTheProductAndAddToCart() {
        String text = se.getWebElement("laptop1").getText();
        se.waitUntilTextToBe(By.xpath("(//span[text()='13\" Macbook Air M1 Işlemci 8 Çekirdek 16 Gb Ram 512 Gb Ssd Hdd Altın Rengi'])[1]"), text);
        BaseDriver.waitDriver(5);
        se.clickFunction(se.getWebElement("laptop"));
        String anaPencere = driver.getWindowHandle();
        Set<String> pencereTanitimcilar = driver.getWindowHandles();
        for (String pencereTanitimci : pencereTanitimcilar) {
            if (!pencereTanitimci.equals(anaPencere)) {
                driver.switchTo().window(pencereTanitimci);
                se.waitUntilTextToBe(By.xpath("//div[text()='Sepete Ekle']"), "Sepete Ekle");
                se.clickFunction(se.getWebElement("basketButton"));
            }
        }
    }

    @And("Delete product from cart and add to favorites")
    public void deleteProductFromCartAndAddToFavorites() {

        se.clickFunction(se.getWebElement("basket"));
        List<WebElement> bosluk = driver.findElements(By.cssSelector("[class='onboarding-overlay']"));
        if (bosluk.size() > 0) {
            bosluk.get(0).click();
        }
        se.clickFunction(se.getWebElement("deleteProduct"));
        se.clickFunction(se.getWebElement("favorite"));
    }

    @And("Add product back to cart and pay")
    public void addProductBackToCartAndPay() {
        se.clickFunction(se.getWebElement("myFavorite"));
        se.clickFunction(se.getWebElement("addBasket"));
        se.clickFunction(se.getWebElement("basket"));
        se.clickFunction(se.getWebElement("confirmCart"));
        se.clickFunction(se.getWebElement("save"));
        se.sendKeysFunction(se.getWebElement("cartNumber"), "5526080000000006");
        se.sendKeysFunction(se.getWebElement("month"), "month");
    }
}
