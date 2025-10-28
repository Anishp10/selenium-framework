package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By searchBox = By.name("q");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void search(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchBox).submit();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
