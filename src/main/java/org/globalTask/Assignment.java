package org.globalTask;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

  public class Assignment {
  public static void main(String[]args) throws InterruptedException{
	// System.setProperty("webdriver.chrome.driver",chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     driver.get("https://www.saucedemo.com/");
     
     driver.findElement(By.id("user-name")).sendKeys("standard_user");
     driver.findElement(By.id("password")).sendKeys("secret_sauce");
     driver.findElement(By.id("login-button")).click();
     driver.findElement(By.className("select_container")).click();
     
        Select product = new Select(driver.findElement(By.className("product_sort_container")));
        product.selectByValue("hilo");
        
        java.util.List<WebElement> item = driver.findElements(By.className("inventory_item_price"));
        java.util.List<WebElement> AddToCart=driver.findElements(By.xpath("//button[text()='Add to cart']"));
        int total_no_of_items = item.size();
        int total_no_of_AddToCart = AddToCart.size();
        
        System.out.println("Second Costlier Item "+ item.get(1).getText());   
        System.out.println("Cheapest Item " + item.get(total_no_of_items-1).getText());

     AddToCart.get(1).click();
     AddToCart.get(total_no_of_AddToCart-1).click();
     
     driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
     driver.findElement(By.xpath("//button[text()='Checkout']")).click();
     
     //Enter Details on Checkout screen
     
     driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Sneha");
     driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Javalkar");
     driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("567890");
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     driver.findElement(By.xpath("//button[text()='Finish']")).click();
     
     WebElement Text = driver.findElement(By.xpath("//div[@class='complete-text']"));
     String SuccessMsg=Text.getText();
     System.out.println(SuccessMsg);
    
     

driver.close();
driver.quit();


}
}
