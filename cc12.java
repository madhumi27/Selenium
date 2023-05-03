package com.selenium.softwaretesting.test1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;

	public class cc12 {

	    public static void main(String[] args) throws Exception {
	    	WebDriverManager.chromedriver().setup();
	    	ChromeOptions co=new ChromeOptions();
	    	co.addArguments("--remote-allow-origins=*");
			WebDriver driver=new ChromeDriver(co);
			driver.get("https://www.saucedemo.com/");
	        WebElement username = driver.findElement(By.id("user-name"));
	        WebElement password = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("login-button"));
	        username.sendKeys("standard_user");
	        password.sendKeys("secret_sauce");
	        loginButton.click();
            Thread.sleep(3000);
	        WebElement sortSelect = driver.findElement(By.className("product_sort_container"));
	        Select sortDropdown = new Select(sortSelect);
	        sortDropdown.selectByIndex(0);
	        Thread.sleep(3000);
	        WebElement firstProductName = driver.findElement(By.className("inventory_item_name"));
	        Assert.assertEquals(firstProductName.getText(), "Sauce Labs Backpack");
	        System.out.println("First product name (A-Z): " + firstProductName.getText());
	        Thread.sleep(3000);
	        WebElement sortSelect1= driver.findElement(By.className("product_sort_container"));
	        Select sortDropdown1 = new Select(sortSelect1);
	        sortDropdown1.selectByIndex(1);
	        firstProductName = driver.findElement(By.className("inventory_item_name"));
	        Assert.assertEquals(firstProductName.getText(), "Test.allTheThings() T-Shirt (Red)");
	        System.out.println("First product name (Z-A): " + firstProductName.getText());
	        Thread.sleep(3000);
	   
	        WebElement sortSelect2 = driver.findElement(By.className("product_sort_container"));
	        Select sortDropdown2 = new Select(sortSelect2);
	        sortDropdown2.selectByIndex(2);

	        WebElement firstProductPrice = driver.findElement(By.className("inventory_item_price"));
	        Assert.assertEquals(firstProductPrice.getText(), "$7.99");
	        System.out.println("First product price (low to high): " + firstProductPrice.getText());
	        Thread.sleep(3000);
	        WebElement sortSelect3 = driver.findElement(By.className("product_sort_container"));
	        Select sortDropdown3 = new Select(sortSelect3);
	        sortDropdown3.selectByIndex(3);

	        firstProductPrice = driver.findElement(By.className("inventory_item_price"));
	        Assert.assertEquals(firstProductPrice.getText(), "$49.99");
	        System.out.println("First product price (high to low): " + firstProductPrice.getText());

	        driver.quit();
	    }

	}