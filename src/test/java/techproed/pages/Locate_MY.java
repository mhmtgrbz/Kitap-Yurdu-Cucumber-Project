package techproed.pages;

import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class Locate_MY {

    public Locate_MY() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
