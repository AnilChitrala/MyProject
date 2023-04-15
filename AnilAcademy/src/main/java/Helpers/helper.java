package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class helper {
    Properties prop = new Properties();
    private WebDriver driver;
    private Logger log;

    public helper(WebDriver driver){
        this.driver=driver;
    }

    public WebDriver getWebDriver() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/ObjectRepository/File.properties");
            prop.load(fis);
            String browserName = prop.getProperty("browser");
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars", "--test-type", "--disable-extensions", "--disable-notifications", "enable-automation",
                        "--disable-popup-blocking", "start-maximized");
                driver = new ChromeDriver(options);
            }else if(browserName.equalsIgnoreCase("edge")){
                System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            String implicitWaitTime = prop.getProperty("implicitWait");
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitWaitTime), TimeUnit.SECONDS);
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
        return driver;
    }

    public void afterScenario() {
        driver.close();
        driver.quit();
    }

    public void launchBrowser() {
        driver.get(prop.getProperty("url"));
    }

    public void clickWebElement(WebDriver driver, String keyValue) {
        driver.findElement(By.xpath(keyValue)).click();
    }
}