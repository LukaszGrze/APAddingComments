package AddingComments;

import org.junit.Assert;
import org.junit.Test;

public class StorePageTests extends StorePageBase{

    @Test
    public void addingComments() throws InterruptedException {
        authenticationPage = mainPage.signIn();
        myAccountPage = authenticationPage.logIn(login, password);
        Assert.assertEquals(userName, myAccountPage.checkUser());
        mainPage = myAccountPage.goToMainPage();
        womenPage = mainPage.goToWomenPage();
        blousePage = womenPage.goToBlousePage();
        womenPage = blousePage.writeAReview(titleText, commentText);
        printedChiffonDressPage = womenPage.goToPrintedChiffonDress();
        Assert.assertEquals(pcdExpectedDiscount, printedChiffonDressPage.checkDiscount());
        Assert.assertNotEquals(printedChiffonDressPage.checkCurrent(), printedChiffonDressPage.checkRegular());
        printedChiffonDressPage.selectQuantitySizeColor(pcdQuantity, pcdSize);
        womenPage = printedChiffonDressPage.addToWishlist();
        printedDressPage = womenPage.goToPrintedDress();
        printedDressPage.checkBigPic();
        printedDressPage.sendEmail(nameOfFriend, emailOfFriend);
        myAccountPage = printedDressPage.addToWishlist();
        myWishlistsPage = myAccountPage.goToMyWishlist();
        myWishlistsPage.goToMyWishList();
        myWishlistsPage.selectPriority(pdPriority, pcdPriority);
        mainPage = myWishlistsPage.newsletterSubscribe(email);
        Assert.assertEquals(expectedMessage, mainPage.checkSubscription());
        Thread.sleep(1000);
        mainPage.logout();
        Assert.assertEquals(expectedSignInButtonText, mainPage.checkIfSignOut());
    }
}
