package AddingComments.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='Log in to your customer account']")
    WebElement signInButton;
    @FindBy(css = "a[title='Women']")
    WebElement womenButton;
    @FindBy(css = ".alert-success")
    WebElement successMessage;
    @FindBy(css = "a[title='Log me out']")
    WebElement logoutButton;


    public WomenPage goToWomenPage() {
        womenButton.click();
        return new WomenPage(driver);
    }

    public AuthenticationPage signIn() {
        signInButton.click();
        return new AuthenticationPage(driver);
    }

    public String checkSubscription() {
        return successMessage.getText();
    }

    public String checkIfSignOut() {
        return signInButton.getText();
    }

    public void logout() {
        logoutButton.click();
    }

}
