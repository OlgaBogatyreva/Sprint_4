package pages.scooter.rent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageAboutRent {
    private final WebDriver driver;

    public OrderPageAboutRent(WebDriver driver) {
        this.driver = driver;
    }

    //поля анкеты
    private final By whenInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentPeriodInput = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private final By colorOfSkooterBlack = By.id("black");
    private final By colorOfSkooterGrey = By.id("grey");
    private final By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //кнопка Далее
    private final By nextBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка согласия с оформлением заказа на попапе
    private final By approveOfferBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //текст на итоговом попапе с подтверждением заказа
    private final By finalPopup = By.xpath(".//div[text()='Заказ оформлен']");
    private final By finalBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    public boolean sendOrderAboutRentInfoPar() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(whenInput));
        driver.findElement(whenInput).click();
        driver.findElement(By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--008']")).click();
        driver.findElement(rentPeriodInput).click();
        driver.findElement(By.xpath(".//div[text()='сутки']")).click();
        driver.findElement(colorOfSkooterGrey).click();
        driver.findElement(commentForCourier).sendKeys("no comments");
        driver.findElement(nextBtn).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(approveOfferBtn));
        driver.findElement(approveOfferBtn).click();
        return driver.findElement(finalBtn).isDisplayed();
    }
}
