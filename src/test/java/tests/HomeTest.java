package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {

    @Test
    public void verifyGoogleHomePage() {
        HomePage home = new HomePage(driver);
        home.open("https://www.google.com");
        Assert.assertTrue(home.getTitle().contains("Google"), "Title mismatch!");
    }
}
