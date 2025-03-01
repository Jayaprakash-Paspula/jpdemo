import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Add this import
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Automatically download and set up ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU for headless mode
        options.addArguments("--window-size=1920,1080"); // Set window size
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleHomepage() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google", "Page title is not Google");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
