package org.example.pages;

import org.example.EnvConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
public class MainPage {
    private final WebDriver driver;

    //Поле с выпадающим текстом
    private final String searchElement = "#accordion__heading-";
    //Текст из поля с выпадающим текстом
    private final String searchText = "accordion__panel-";
    //Кнопка куки
    private final String cookieButton = "App_CookieButton__3cvqF";
    //Кнопка Заказать вверху главной страницы
    private final String ButtonForOrder = ".//button[@class='Button_Button__ra12g']";
    //Кнопка Заказать внизу страницы
    private final By midlButtonForOrder = By.cssSelector(".Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //Получени текста из элемента и сравнение его с ожидаемым результатом
    public void compareDropText(String expectedText, int elementID) {
        WebElement panel = driver.findElement(By.id(searchText + elementID));
        String actualText = panel.getText();
        assertEquals(expectedText, actualText);
    }
    //Поиск строки с выпадающим текстом и ожидание после нажатия
    public void clickElement(int elementID) {
        driver.findElement(By.cssSelector(searchElement + elementID)).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(searchText + elementID)));
    }
    //Поиск элемента и скрол до него
    public void scrollAndSearchElement(int elementID) {
        WebElement element = driver.findElement(By.cssSelector(searchElement + elementID));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Закрытие окна Куки
    public void closeCookie() {
        driver.findElement(By.className(cookieButton)).click();
    }
    //Открытие главной страницы Яндекс.Самоката
    public void openPage() {
        driver.get(EnvConfig.BASE_URL);

    }
    //Клик по кнопке Заказать в верху страницы
    public void OrderButtonClick() {
        driver.findElement(By.xpath(ButtonForOrder)).click();
    }
    //Скрол до кнопки Заказать и клик по ней
    public void MidlOrderButton(){
        WebElement element = driver.findElement(midlButtonForOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(midlButtonForOrder).click();
    }
}
