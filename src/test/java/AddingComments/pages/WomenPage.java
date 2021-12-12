package AddingComments.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {
    private final WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[normalize-space()='Blouse']")
    WebElement blouse;
    @FindBy(xpath = "//a[@title='Printed Chiffon Dress'][normalize-space()='Printed Chiffon Dress']")
    WebElement printedChiffonDress;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[4]/div/div[2]/h5/a")
    WebElement printedDress;


    public BlousePage goToBlousePage() {
        blouse.click();
        return new BlousePage(driver);
    }

    public PrintedChiffonDressPage goToPrintedChiffonDress() {
        printedChiffonDress.click();
        return new PrintedChiffonDressPage(driver);
    }

    public PrintedDressPage goToPrintedDress() {
        printedDress.click();
        return new PrintedDressPage(driver);
    }
}
