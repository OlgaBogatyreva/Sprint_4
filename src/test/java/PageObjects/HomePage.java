package PageObjects;

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

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAccordeonItem(By accHead, By accText, String text){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(accHead));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(accHead));
        driver.findElement(accHead).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accText));
        assertEquals(driver.findElement(accText).getText(), text);
    }

    public void assertAccordeonText1(){
        clickAccordeonItem(accordeonHead, accordeonText, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }

    public void assertAccordeonText2(){
        clickAccordeonItem(accordeonHead2, accordeonText2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }

    public void assertAccordeonText3(){
        clickAccordeonItem(accordeonHead3, accordeonText3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }

    public void assertAccordeonText4(){
        clickAccordeonItem(accordeonHead4, accordeonText4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    public void assertAccordeonText5(){
        clickAccordeonItem(accordeonHead5, accordeonText5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }

    public void assertAccordeonText6(){
        clickAccordeonItem(accordeonHead6, accordeonText6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    public void assertAccordeonText7(){
        clickAccordeonItem(accordeonHead7, accordeonText7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    public void assertAccordeonText8(){
        clickAccordeonItem(accordeonHead8, accordeonText8, "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    //Клик по кнопке заказать в хедере
    public void clickOrderBtnHeader(){
        driver.findElement(orderBtnHeader).click();
    }

    //Клик по кнопке Заказать в середине страницы
    public void clickOrderBtnMiddle(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderBtnMiddle));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(orderBtnMiddle));
        driver.findElement(orderBtnMiddle).click();
    }
}
