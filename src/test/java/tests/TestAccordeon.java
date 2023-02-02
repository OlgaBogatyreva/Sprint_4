package tests;

import PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestAccordeon {
    private WebDriver driver;

    @Test
    public void openAccordeonItemWillBeOk() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);

        objHomePage.assertAccordeonText1();
        objHomePage.assertAccordeonText2();
        objHomePage.assertAccordeonText3();
        objHomePage.assertAccordeonText4();
        objHomePage.assertAccordeonText5();
        objHomePage.assertAccordeonText6();
        objHomePage.assertAccordeonText7();
        objHomePage.assertAccordeonText8();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
