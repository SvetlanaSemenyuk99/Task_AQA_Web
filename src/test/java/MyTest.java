import Pages2.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyTest {
    private WebDriver driver;
    private iFramePage iframePage;

    @Test
    public void iFrameTest() {
        System.out.println("Start iFrameTest ");
        System.out.println(" ");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ololo\\IdeaProjects\\Task\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        iFramePage iframePage = new iFramePage(driver);
        BingPage bingPage = new BingPage(driver);
        BingSourcePage bingSourcePage = new BingSourcePage(driver);
        System.out.println("1. Open in browser 'https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe'");
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        System.out.println("2. In the iframe, replace the source with 'https://www.bing.com'");
        iframePage.changeLink();
        System.out.println("3. Click on Run");
        iframePage.runCode();
        System.out.println("4. Enter “Redmond” in the search field, wait for the drop-down list with the recommended queries");
        iframePage.inputRedmond("Redmond");
        System.out.println("5. Check that the drop-down list contains the line \"Redmond Washington\"");
        String text = bingPage.getTextRedmondWashington();
        Assert.assertEquals("redmond washington", text);
        System.out.println("6. Click on 'redmond washington'");
        bingPage.clickOnField();
        System.out.println("7. Check that the first link in the search results is https://www.bing.com/travelguide?q=Redmond");
        String URL = bingSourcePage.getUrl();
        Assert.assertEquals("https://www.bing.com/travelguide?q=Redmond", URL);
    }

    @Test
    public void APITest() throws IOException, InterruptedException {
        System.out.println(" ");
        System.out.println("Start APITest ");
        System.out.println(" ");
        Api api = new Api();
        String imageJPEG = api.convertJPEGImage();
        String imageAPI = api.convertAPIImage();
        System.out.println("Check that the image matches example.jpeg in the base64 standard");
        Assert.assertEquals(imageJPEG, imageAPI);
        System.out.println("Example.jpeg image is base64 compliant");
    }

    @Test
    public void DBTest(){
        System.out.println(" ");
        System.out.println("Start DBTest ");
        System.out.println(" ");
        SelectRecords selectRecords = new SelectRecords();
        List resSql = selectRecords.selectAll();
        Integer convertedToInt = Integer.valueOf((Integer) resSql.get(0));
        Float convertedToFloat = Float.valueOf((Float) resSql.get(1));
        System.out.println("1. Verify the population density is below 50 people / sq. km. only in the USA. Density = Population / Area.");
        Assert.assertTrue(convertedToFloat < 50.0);
        System.out.println("The United States has a population density below 50 people / sq. km.");
        System.out.println("2.Verify the sum of the population of all 4 countries is less than 2 billion people");
        Assert.assertTrue(convertedToInt < 2000000000);
        System.out.println("The sum of the population of all 4 countries is less than 2 billion people");
        }


//    @After
//    public void quit() {
//        driver.quit();
//    }

}
