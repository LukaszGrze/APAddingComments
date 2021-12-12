package AddingComments.pages;

import com.mifmif.common.regex.Generex;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyWishlistsPage {
    private final WebDriver driver;

    public MyWishlistsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]")
    WebElement wishListButton;
    @FindBy(id = "priority_4_43")
    WebElement pdPrioritySelect;
    @FindBy(xpath = "//li[1]//div[1]//div[2]//div[1]//div[2]//a[1]//span[1]")
    WebElement pdSaveButton;
    @FindBy(id = "priority_7_38")
    WebElement pcdPrioritySelect;
    @FindBy(xpath = "//li[2]//div[1]//div[2]//div[1]//div[2]//a[1]//span[1]")
    WebElement pcdSaveButton;
    @FindBy(id = "newsletter-input")
    WebElement newsletterField;
    @FindBy(name = "submitNewsletter")
    WebElement submitButton;

    public void goToMyWishList() {
        wishListButton.click();
    }

    public void selectPriority(String pdPriority, String pcdPriority) {
        new Select(pdPrioritySelect).selectByValue(pdPriority);
        pdSaveButton.click();
        new Select(pcdPrioritySelect).selectByValue(pcdPriority);
        pcdSaveButton.click();
    }

    public MainPage newsletterSubscribe(String email) {
        newsletterField.sendKeys(new Generex(email).random());
        submitButton.click();
        return new MainPage(driver);
    }
}
