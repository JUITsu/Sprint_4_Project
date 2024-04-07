package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class OrderPage2 {
    private final WebDriver driver;
    //Заголовок страницы Про Аренду
    private final By headerAboutRent = By.className("Order_Header__BZXOb");
    //Поле календарь
    private final By calendar = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Поле Срок аренды
    private final By rentDays = By.className("Dropdown-placeholder");
    //Поле Комментарий для курьера
    private final By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка Заказать на странице Про аренду
    private final By buttonForOrder = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Локатор окна подтверждения заказа
    private final By windowConfirmOrder = By.className("Order_Modal__YZ-d3");
    //Кнопка Да в окне подтверждения заказа
    private final By buttonYes = By.xpath(".//*[text() = 'Да']");
    //Локатор заголовка Заказ оформлен
    private final By orderComplite = By.xpath(".//*[text() = 'Заказ оформлен']");

    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }
    //Ожидание загрузки страницы и появления заголока Про аренду
    public void loadOrderPage2() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> (driver.findElement(headerAboutRent).getText() != null && !driver.findElement(By.className("Order_Header__BZXOb")).getText().isEmpty()));
    }
    //Ввод даты доставки самоката и подтверждение ввода
    public void inputDateOrder(String dateOrder) {
        driver.findElement(calendar).sendKeys(dateOrder);
        driver.findElement(calendar).sendKeys(Keys.ENTER);
    }
    //Выбор срока аренды
    public void inputRentalPeriod(String rental) {
        driver.findElement(rentDays).click();
        driver.findElement(By.xpath("//*[text() = '"+ rental + "']")).click();
    }
    //Выбор цвета
    public void inputColor(String color) {
        driver.findElement(By.id(color)).click();
    }
    //Комментарий для заказа
    public void inputComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    //Клик по кнопке Заказать
    public void clickOrderButton() {
        driver.findElement(buttonForOrder).click();
    }
    //Ожидание появления окна подтверждение заказа и клик по кнопке ДА
    public void waitOrderWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(windowConfirmOrder));
        driver.findElement(buttonYes).click();
    }
    //Проверка появления на экране заголовка Заказ оформлен
    public boolean isOrderCreated() {
        return driver.findElement(orderComplite).isDisplayed();
    }
}
