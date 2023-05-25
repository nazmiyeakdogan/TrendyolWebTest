package stepDefinitions;

import pages.ContentElements;
import utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static utilities.BaseDriver.driver;

public class ShoppingSteps {

    ContentElements ce = new ContentElements();

    @When("Search for product")
    public void searchForProduct() {
        ce.pressEsc();
        ce.sendKeysFunction(ce.getWebElement("searchInput"), "laptop");
        ce.clickFunction(ce.getWebElement("searchButton"));
    }

    @And("Apply filter for product")
    public void applyFilterForProduct() {

//        ce.clickFunction(ce.getWebElement("brand"));
//        driver.navigate().refresh();
//        ce.clickFunction(ce.blank);
//        ce.waitUntilTextToBe(By.xpath("//div[text()='Ram (Sistem Belleği)']"), "Ram (Sistem Belleği)");
//        ce.clickFunction(ce.ramButton);
//        ce.clickFunction(ce.ram);

        ce.pressEsc();
        ce.scrollToElement(ce.getWebElement("brand"));
        List<WebElement> bosluk = driver.findElements(By.cssSelector("[class='overlay']"));
        if (bosluk.size() > 0) {
            bosluk.get(0).click();
        }
//        ce.pressEsc();
        ce.clickFunction(ce.blank);  // boşluğa tıkla

        ce.clickFunction(ce.getWebElement("brand"));
//        ce.waitUntilTextToBe(By.xpath("//div[text()='Ram (Sistem Belleği)']"), "Ram (Sistem Belleği)");
        ce.clickFunction(ce.getWebElement("ramButton"));
        ce.clickFunction(ce.getWebElement("ram"));
    }

    @And("Click on the product and add to cart")
    public void clickOnTheProductAndAddToCart() {
        String text = ce.getWebElement("laptop1").getText();
        ce.waitUntilTextToBe(By.xpath("(//span[text()='13\" Macbook Air M1 Işlemci 8 Çekirdek 16 Gb Ram 512 Gb Ssd Hdd Altın Rengi'])[1]"), text);
//        BaseDriver.waitDriver(5);
        ce.clickFunction(ce.getWebElement("laptop"));
        String anaPencere = driver.getWindowHandle();
        Set<String> pencereTanitimcilar = driver.getWindowHandles();
        for (String pencereTanitimci : pencereTanitimcilar) {
            if (!pencereTanitimci.equals(anaPencere)) {
                driver.switchTo().window(pencereTanitimci);
                ce.waitUntilTextToBe(By.xpath("//div[text()='Sepete Ekle']"), "Sepete Ekle");
                ce.clickFunction(ce.getWebElement("basketButton"));
            }
        }
    }

    @And("Delete product from cart and add to favorites")
    public void deleteProductFromCartAndAddToFavorites() {

        ce.clickFunction(ce.getWebElement("basket"));
        List<WebElement> bosluk = driver.findElements(By.cssSelector("[class='onboarding-overlay']"));
        if (bosluk.size() > 0) {
            bosluk.get(0).click();
        }
        ce.clickFunction(ce.getWebElement("deleteProduct"));
        ce.clickFunction(ce.getWebElement("favorite"));
    }

    @And("Add product back to cart and pay")
    public void addProductBackToCartAndPay() {
        ce.clickFunction(ce.getWebElement("myFavorite"));
        ce.clickFunction(ce.getWebElement("addBasket"));
        ce.clickFunction(ce.getWebElement("basket"));
        ce.clickFunction(ce.getWebElement("confirmCart"));
        ce.clickFunction(ce.getWebElement("save"));
        ce.sendKeysFunction(ce.getWebElement("cartNumber"), "5526080000000006");
        ce.sendKeysFunction(ce.getWebElement("month"), "month");
    }


}
