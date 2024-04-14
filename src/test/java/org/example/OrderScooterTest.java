package org.example;

import org.example.pages.MainPage;
import org.example.pages.OrderPage1;
import org.example.pages.OrderPage2;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private final String name;
    private final String lastname;
    private final String address;
    private final int station;
    private final String phoneNumber;
    private final String dateOrder;
    private final String rental;
    private final String color;
    private final String comment;

    public OrderScooterTest(String name, String lastname, String address, int station, String phoneNumber, String dateOrder, String rental, String color, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.dateOrder = dateOrder;
        this.rental = rental;
        this.color = color;
        this.comment = comment;
    }
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Иван","Иванов","Москва",1,"88009998877", "20.04.2024", "сутки", "grey", "котики"},
                {"Александр","Александров","Мщсква",20,"88009997788", "25.04.2024", "шестеро суток", "black", "пёсики"}
        };
    }

    @Test
    public void OrderScooterClick(){
        WebDriver driver = driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.openPage();
        main.closeCookie();
        main.OrderButtonClick();

        OrderPage1 order = new OrderPage1(driver);
        order.loadOrderPage();
        order.inputName(name);
        order.inputLastName(lastname);
        order.inputWho(address);
        order.inputMetroStation(station);
        order.inputTelephoneNumber(phoneNumber);
        order.clickNext();

        OrderPage2 rent = new OrderPage2(driver);

        rent.loadOrderPage2();
        rent.inputDateOrder(dateOrder);
        rent.inputRentalPeriod(rental);
        rent.inputColor(color);
        rent.inputComment(comment);
        rent.clickOrderButton();
        rent.waitOrderWindow();
        rent.isOrderCreated();

        assertTrue("Заказ не оформлен", rent.isOrderCreated());
    }
    @Test
    public void OrderScooterMidlButton(){
        WebDriver driver = driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.openPage();
        main.closeCookie();
        main.MidlOrderButton();

        OrderPage1 order = new OrderPage1(driver);
        order.loadOrderPage();
        order.inputName(name);
        order.inputLastName(lastname);
        order.inputWho(address);
        order.inputMetroStation(station);
        order.inputTelephoneNumber(phoneNumber);
        order.clickNext();

        OrderPage2 rent = new OrderPage2(driver);

        rent.loadOrderPage2();
        rent.inputDateOrder(dateOrder);
        rent.inputRentalPeriod(rental);
        rent.inputColor(color);
        rent.inputComment(comment);
        rent.clickOrderButton();
        rent.waitOrderWindow();
        rent.isOrderCreated();

        assertTrue("Заказ не оформлен", rent.isOrderCreated());
    }
}
