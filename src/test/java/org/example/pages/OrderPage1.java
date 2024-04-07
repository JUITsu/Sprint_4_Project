package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class OrderPage1 {
    private final WebDriver driver;
    //Заголовок страницы "Для кого самокат"
    private final By headerPage = By.className("Order_Header__BZXOb");
    //Поле ввода имени
    private final By fieldName = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле ввода фамилии
    private final By fieldLastName = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле ввода адреса
    private final By adressOrder = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле станция метро
    private final By metroStation = By.xpath(".//input[@placeholder = '* Станция метро']");
    //Локатор для выбора станции метро
    private final By dropListMetroStation = By.className("select-search__select");
    //Поле номер телефона
    private final By fieldPhoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Локатор кнопки Далее
    private final By buttonNext = By.cssSelector(".Button_Middle__1CSJM");

    public OrderPage1(WebDriver driver) {
        this.driver = driver;
    }


    //Метод ожидающий загрузку страницы
    public void loadOrderPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> (driver.findElement(headerPage).getText() != null && !driver.findElement(By.className("Order_Header__BZXOb")).getText().isEmpty()));
    }

    //Метод для поиска поля Имя по локатору и вводящий значение
    public void inputName(String name){
        driver.findElement(fieldName).sendKeys(name);
    }

    //Метод для поиска поля Фамилия по локатору и вводящий значение
    public void inputLastName(String lastname) {
        driver.findElement(fieldLastName).sendKeys(lastname);
    }

    //Метод для поиска поля Адрес по локатору и вводящий значение
    public void inputWho(String address) {
        driver.findElement(adressOrder).sendKeys(address);
    }

    //Метод для поиска поля Станция метро и выбирающий значение из выпадающего списка
    public void inputMetroStation(int station) {
        driver.findElement(metroStation).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(dropListMetroStation));

        WebElement element = driver.findElement(By.xpath("//button[@value = '"+station+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath("//button[@value = '"+station+"']")).click();
    }

    //Метод поиска и ввода значения в поле Номер телефона
    public void inputTelephoneNumber(String phoneNumber) {
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }

    //Метор поиска и нажатия на кнопку Далее
    public void clickNext() {
        driver.findElement(buttonNext).click();
    }
}
