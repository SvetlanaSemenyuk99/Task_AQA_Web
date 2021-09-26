package Pages2;

import org.openqa.selenium.*;

import java.util.Collections;
import java.util.List;

public class iFramePage {
    static WebDriver driver;

    public iFramePage (WebDriver driver){
        this.driver = driver;
    }

    private By changeSrc =  By.xpath("//span[contains(text(),\"The iframe element\")]");
    private By buttonRun = By.xpath("//button[@id=\"runbtn\"]");
    private By inputWord = By.xpath("//input [@id=\"sb_form_q\"]");
    private By allText = By.xpath("//div[@id=\"textarea\"]");
    private By codeMirror = By.className("CodeMirror");
    private By codeMirrorLine = By.xpath("//*[@class=' CodeMirror-line ']//*[@class='cm-m-xml'][3]");



    public iFramePage changeLink () {
        WebElement textArea = driver.findElement(codeMirror).findElement(By.cssSelector("textarea"));
        driver.findElement(codeMirrorLine).click();
        for(int i = 0; i < 17; i++) {
            textArea.sendKeys(Keys.BACK_SPACE);
        }
        textArea.sendKeys("www.bing.com\"");
        return this;
    }

    public iFramePage runCode (){
        driver.findElement(buttonRun).click();
        return this;
    }

    public iFramePage inputRedmond (String sendkeys){
        driver.get("https://www.bing.com");
        driver.findElement(inputWord).click();
        driver.findElement(inputWord).sendKeys(sendkeys);
        return this;
    }



}

