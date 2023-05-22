package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {

    public LoginElements() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }


}
