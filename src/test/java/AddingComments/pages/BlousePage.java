package AddingComments.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlousePage {
    private final WebDriver driver;

    public BlousePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='open-comment-form']")
    WebElement writeReviewButton;
    @FindBy(id = "comment_title")
    WebElement commentTitleField;
    @FindBy(id = "content")
    WebElement contentField;
    @FindBy(id = "submitNewMessage")
    WebElement sendButton;
    @FindBy(xpath = "/html/body/div[2]/div/div/div/p[2]/button/span")
    WebElement okButton;
    @FindBy(css = "a[title='Women']")
    WebElement womenButton;


    public WomenPage writeAReview(String titleText, String commentText) {
        writeReviewButton.click();
        commentTitleField.sendKeys(titleText);
        contentField.sendKeys(commentText);
        sendButton.click();
        okButton.click();
        womenButton.click();
        return new WomenPage(driver);
    }
}
