package AddingComments.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PrintedChiffonDressPage {
    private final WebDriver driver;

    public PrintedChiffonDressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "old_price_display")
    WebElement oldPrice;
    @FindBy(id = "our_price_display")
    WebElement newPrice;
    @FindBy(id = "reduction_percent_display")
    WebElement discount;
    @FindBy (id = "color_15")
    WebElement greenColor;
    @FindBy(id = "quantity_wanted")
    WebElement quantityField;
    @FindBy(id = "group_1")
    WebElement selectSizeButton;
    @FindBy(id = "wishlist_button")
    WebElement addToWishList;
    @FindBy(xpath = "/html/body/div[2]/div/div/a")
    WebElement closeButton;
    @FindBy(css = "a[title='Women']")
    WebElement womenButton;

    public String checkDiscount() {
        return discount.getText();
    }

    public void selectQuantitySizeColor(String quantity, String size) {
        quantityField.clear();
        quantityField.sendKeys(quantity);
        new Select(selectSizeButton).selectByVisibleText(size);
        greenColor.click();
    }
    public String checkRegular(){
        return oldPrice.getText();
    }
    public String checkCurrent(){
        return newPrice.getText();
    }

    public WomenPage addToWishlist(){
        addToWishList.click();
        closeButton.click();
        womenButton.click();
        return new WomenPage(driver);
    }
}
