package tests.scooter.rent;

import pages.scooter.rent.HomePage;
import pages.scooter.rent.OrderPage;
import pages.scooter.rent.OrderPageAboutRent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ScooterOrderTestParametrized {
    private WebDriver driver;
    private final String nameInput; // поле Имя и дальше соответственно:
    private final String surnameInput;
    private final String addressInput;
    private final String phoneInput;
    private final boolean isDisplayed;

    public ScooterOrderTestParametrized(String nameInput, String surnameInput, String addressInput, String phoneInput, boolean isDisplayed) {
        this.nameInput = nameInput;
        this.surnameInput = surnameInput;
        this.addressInput = addressInput;
        this.phoneInput = phoneInput;
        this.isDisplayed = isDisplayed;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getCities() {
        return new Object[][]{
                {"Вениамин", "Вениаминович", "Ереванская 24", "89000000000", true},
                {"Емельян", "Емельянович", "упс 12", "98322323232", true},
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup(); // в firefox тесты проходят успешно
        //driver = new FirefoxDriver();
    }

    //оформление заказа по клину на верхнюю кнопку
    @Test
    public void createOrderByHeaderBtn() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);

        objHomePage.clickOrderBtnHeader();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.sendOrderInfoPar(this.nameInput, this.surnameInput, this.addressInput, this.phoneInput);

        OrderPageAboutRent objOrderPageAboutRent = new OrderPageAboutRent(driver);
        Boolean result = objOrderPageAboutRent.sendOrderAboutRentInfoPar();
        Assert.assertEquals(isDisplayed, result);
    }

    //оформление заказа по клину на кнопку в середине страницы
    @Test
    public void createOrderByMiddleBtn() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);

        objHomePage.clickOrderBtnMiddle();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.sendOrderInfoPar(this.nameInput, this.surnameInput, this.addressInput, this.phoneInput);

        OrderPageAboutRent objOrderPageAboutRent = new OrderPageAboutRent(driver);
        Boolean result = objOrderPageAboutRent.sendOrderAboutRentInfoPar();
        Assert.assertEquals(isDisplayed, result);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
