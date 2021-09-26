package Pages2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BingPage {
    static WebDriver driver;
    private By RedmondWashington = By.xpath("//span[@class=\"sa_tm_text\"][1]");


    public BingPage (WebDriver driver){
        this.driver = driver;
    }

    public String getTextRedmondWashington (){
        return  driver.findElement(RedmondWashington).getText();
    }

    public BingSourcePage clickOnField(){
        driver.findElement(RedmondWashington).click();
        return new BingSourcePage(driver);
    }
}
