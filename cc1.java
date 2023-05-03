package com.selenium.softwaretesting.test1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
public class cc1{
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions co=new ChromeOptions();
    	co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(co);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
		Thread.sleep(3000);
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addButton.click();
        Thread.sleep(3000);
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals("1", cartIcon.getText());
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart_item']"));
        String actualProName = cartItem.findElement(By.className("inventory_item_name")).getText();
        String expectedProName = "Sauce Labs Backpack";
        Assert.assertEquals(expectedProName, actualProName);
        String actualProPrice = cartItem.findElement(By.className("inventory_item_price")).getText();
        String expectedProPrice = "$29.99";
        Assert.assertEquals(expectedProPrice, actualProPrice);
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("madhumitha");
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("r");
        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        postalCodeField.sendKeys("620062");
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        Thread.sleep(3000);
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(expectedTitle, driver.getTitle());
        WebElement productOverviewTitle = driver.findElement(By.className("title"));
        Assert.assertEquals("Checkout: Overview", productOverviewTitle.getText());
        WebElement productTitle = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals(expectedProName, productTitle.getText());
        WebElement productPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        Assert.assertEquals(expectedProPrice, productPrice.getText());
        System.out.println(expectedProName);
        System.out.println(expectedProPrice);
        Assert.assertEquals(expectedTitle, driver.getTitle());
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        driver.quit();
    }
}


