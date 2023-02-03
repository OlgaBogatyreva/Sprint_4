package pages.scooter.rent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //поля анкеты
    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By surInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее
    private final By nextBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //станции метро
    private final By metroCherkizovskaya = By.xpath(".//div[text()='Черкизовская']");

    public void sendOrderInfoPar(String name, String surname, String address, String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(nameInput));
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(surInput).sendKeys(surname);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroInput).click();
        driver.findElement(metroCherkizovskaya).click();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(nextBtn).click();
    }
}
