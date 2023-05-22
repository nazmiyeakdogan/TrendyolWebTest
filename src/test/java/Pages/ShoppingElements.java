package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingElements extends Parent {

    public ShoppingElements() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(className = "V8wbcUhU")
    public WebElement searchInput;
    @FindBy(className = "cyrzo7gC")
    public WebElement searchButton;
    @FindBy(xpath = "//div[text()='Apple']")
    public WebElement brand;
    @FindBy(xpath = "//div[text()='Ram (Sistem Belleği)']")
    public WebElement ramButton;
    @FindBy(xpath = "//div[text()='16 GB']")
    public WebElement ram;
    @FindBy(xpath = "(//span[text()='13\" Macbook Air M1 Işlemci 8 Çekirdek 16 Gb Ram 512 Gb Ssd Hdd Altın Rengi'])[1]")
    public WebElement laptop;
    @FindBy(xpath = "//div[text()='Sepete Ekle']")
    public WebElement basketButton;
    @FindBy(xpath = "(//p[text()='Sepetim'])[1]")
    public WebElement basket;
    @FindBy(css = "[class='i-trash']:nth-child(1)")
    public WebElement deleteProduct;
    @FindBy(xpath = "(//i[@class='i-heart'])[1]")
    public WebElement favorite;
    @FindBy(xpath = "//p[text()='Favorilerim']")
    public WebElement myFavorite;

    @FindBy(xpath = "//span[text()='Sepete Ekle']")
    public WebElement addBasket;

    @FindBy(xpath = "(//span[text()='Sepeti Onayla'])[1]")
    public WebElement confirmCart;
    @FindBy(className = "ty-primary-btn ty-btn-large")
    public WebElement save;
    @FindBy(id = "card-number")
    public WebElement cartNumber;
    @FindBy(id = "card-date-month")
    public WebElement month;

    public WebElement getWebElement(String str){

        switch (str){
            case "searchInput" : return searchInput;
            case "searchButton" : return searchButton;
            case "brand" : return brand;
            case "ramButton" : return ramButton;
            case "ram" : return ram;
            case "laptop1" : return laptop;
            case "basketButton" : return basketButton;
            case "basket" : return basket;
            case "deleteProduct" : return deleteProduct;
            case "favorite" : return favorite;
            case "myFavorite" : return myFavorite;
            case "addBasket" : return addBasket;
            case "confirmCart" : return confirmCart;
            case "save" : return save;
            case "cartNumber" : return cartNumber;
            case "month" : return month;

        }

        return null;

    }

}
