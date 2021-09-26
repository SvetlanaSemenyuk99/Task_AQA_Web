package Pages2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BingSourcePage {
    static WebDriver driver;
    private By verifyURL = By.xpath("//div[@class=\"b_attribution\"]/cite");

    public BingSourcePage (WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.findElement(verifyURL).getText();
    }
}
