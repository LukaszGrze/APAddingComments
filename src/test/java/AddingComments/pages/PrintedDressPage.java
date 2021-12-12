package AddingComments.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintedDressPage {
    private final WebDriver driver;

    public PrintedDressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "color_24")
    WebElement pinkColor;
    @FindBy(id = "wishlist_button")
    WebElement addToWishList;
    @FindBy(xpath = "/html/body/div[2]/div/div/a")
    WebElement firstCloseButton;
    @FindBy(css = ".account")
    WebElement accountButton;
    @FindBy(id = "send_friend_button")
    WebElement sendFriendButton;
    @FindBy(id = "friend_name")
    WebElement friendNameField;
    @FindBy(id = "friend_email")
    WebElement friendEmailField;
    @FindBy(id = "sendEmail")
    WebElement sendEmailButton;
    @FindBy(xpath = "//input[@value='OK']")
    WebElement okButton;
    @FindBy(id = "bigpic")
    WebElement bigPic;
    @FindBy(xpath = "//a[@title='Close']")
    WebElement secondCloseButton;

    public void checkBigPic() {
        bigPic.click();
        secondCloseButton.click();
    }

    public void sendEmail(String nameOfFriend, String emailOfFriend) {
        sendFriendButton.click();
        friendNameField.sendKeys(nameOfFriend);
        friendEmailField.sendKeys(emailOfFriend);
        sendEmailButton.click();
        okButton.click();
    }

    public MyAccountPage addToWishlist() {
        pinkColor.click();
        addToWishList.click();
        firstCloseButton.click();
        accountButton.click();
        return new MyAccountPage(driver);
    }

}
