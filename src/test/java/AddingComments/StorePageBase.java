package AddingComments;

import AddingComments.pages.*;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StorePageBase {
    MainPage mainPage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    WomenPage womenPage;
    BlousePage blousePage;
    PrintedChiffonDressPage printedChiffonDressPage;
    PrintedDressPage printedDressPage;
    MyWishlistsPage myWishlistsPage;

    WebDriver driver;

    String URL = "http://automationpractice.com/";
    String login = "testmail2000@gmail.pl";
    String email = "\\w{10}\\@gmail\\.com";
    String password = "testpassword";
    String userName = "Luke Skywalker";
    String pcdExpectedDiscount = "-20%";
    String pcdQuantity = "4";
    String pcdSize = "M";
    String expectedSignInButtonText = "Sign in";
    String titleText = "Random title";
    String commentText = "Another random text";
    String nameOfFriend = "Chris";
    String emailOfFriend = "chris@gmail.com";
    String pdPriority = "2";
    String pcdPriority = "0";
    String expectedMessage = "Newsletter : You have successfully subscribed to this newsletter.";


    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        mainPage = new MainPage(driver);
    }

    @After
    public void driverQuit() {
        driver.quit();
    }

}
