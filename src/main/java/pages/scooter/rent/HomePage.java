package pages.scooter.rent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class HomePage {

    private final WebDriver driver;
    //первая кнопка со стрелочкой аккордеона
    private final By accordeonHead = By.id("accordion__heading-0");
    //вторая кнопка со стрелочкой аккордеона
    private final By accordeonHead2 = By.id("accordion__heading-1");
    //третья кнопка со стрелочкой аккордеона
    private final By accordeonHead3 = By.id("accordion__heading-2");
    //четвертая кнопка со стрелочкой аккордеона
    private final By accordeonHead4 = By.id("accordion__heading-3");
    //пятая кнопка со стрелочкой аккордеона
    private final By accordeonHead5 = By.id("accordion__heading-4");
    //шестая кнопка со стрелочкой аккордеона
    private final By accordeonHead6 = By.id("accordion__heading-5");
    //седьмая кнопка со стрелочкой аккордеона
    private final By accordeonHead7 = By.id("accordion__heading-6");
    //восьмая кнопка со стрелочкой аккордеона
    private final By accordeonHead8 = By.id("accordion__heading-7");

    //текст первой раскрывашки аккордеона
    private final By accordeonText = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and @id='accordion__panel-0'][not(@hidden)]");
    //  private final By accordeonText = By.xpath("//div[@class='accordion__panel'][not(@hidden)]");
    //текст второй раскрывашки аккордеона
    private final By accordeonText2 = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and @id='accordion__panel-1'][not(@hidden)]");
    //текст третьей раскрывашки аккордеона
    private final By accordeonText3 = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and @id='accordion__panel-2'][not(@hidden)]");
    //текст четвертой раскрывашки аккордеона
    private final By accordeonText4 = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and @id='accordion__panel-3'][not(@hidden)]");
    //текст пятой раскрывашки аккордеона
    private final By accordeonText5 = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and @id='accordion__panel-4'][not(@hidden)]");
    //текст шестой раскрывашки аккордеона
    private final By accordeonText6 = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and @id='accordion__panel-5'][not(@hidden)]");
    //текст седьмой раскрывашки аккордеона
    private final By accordeonText7 = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and @id='accordion__panel-6'][not(@hidden)]");
    //текст второй раскрывашки аккордеона
    private final By accordeonText8 = By.xpath(".//div[@data-accordion-component='AccordionItemPanel' and @id='accordion__panel-7'][not(@hidden)]");

    //кнопка Заказать в хедере
    private final By orderBtnHeader = By.xpath(".//button[@class='Button_Button__ra12g']");
    //кнопка Заказать в середине страницы
    private final By orderBtnMiddle = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccordeonItem(By accHead, By accText, String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(accHead));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(accHead));
        driver.findElement(accHead).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accText));
        Assert.assertEquals(driver.findElement(accText).getText(), text);
    }

    public void assertAccordeonText1(String text) {
        clickAccordeonItem(accordeonHead, accordeonText, text);
    }

    public void assertAccordeonText2(String text) {
        clickAccordeonItem(accordeonHead2, accordeonText2, text);
    }

    public void assertAccordeonText3(String text) {
        clickAccordeonItem(accordeonHead3, accordeonText3, text);
    }

    public void assertAccordeonText4(String text) {
        clickAccordeonItem(accordeonHead4, accordeonText4, text);
    }

    public void assertAccordeonText5(String text) {
        clickAccordeonItem(accordeonHead5, accordeonText5, text);
    }

    public void assertAccordeonText6(String text) {
        clickAccordeonItem(accordeonHead6, accordeonText6, text);
    }

    public void assertAccordeonText7(String text) {
        clickAccordeonItem(accordeonHead7, accordeonText7, text);
    }

    public void assertAccordeonText8(String text) {
        clickAccordeonItem(accordeonHead8, accordeonText8, text);
    }

    //Клик по кнопке заказать в хедере
    public void clickOrderBtnHeader() {
        driver.findElement(orderBtnHeader).click();
    }

    //Клик по кнопке Заказать в середине страницы
    public void clickOrderBtnMiddle() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderBtnMiddle));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(orderBtnMiddle));
        driver.findElement(orderBtnMiddle).click();
    }
}
