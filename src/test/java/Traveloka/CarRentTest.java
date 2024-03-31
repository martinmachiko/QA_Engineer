package Traveloka;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CarRentTest {

    WebDriver driver;

    @BeforeTest
    private void init(){

        System.setProperty("webdriver..driver", "C:/Program Files/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
// goto homepage
        driver.navigate().to("https://www.traveloka.com/");
        driver.manage().window().maximize();

    }

    @Test (priority = 0)
    private void clickHeadeRentalCar(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[6]/div")).click();
        try {
            Thread.sleep(3000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/label/div")).getText(),"Your Rental Location");
    }

    @Test (priority = 1)
    private void selectTabWithoutDriver(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[1]/div/div[1]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[1]/div/div[1]/div")).getCssValue("background-color"),"rgba(1, 148, 243, 1)");
    }




    @Test (priority = 2)
    private void selectPickUpLocation(){

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/input")).click();

       WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[2]/div/div[2]"));

        // Scroll vertically by 350 pixels using JavaScript Executor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 350);", element);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[2]/div/div[2]/div/div[2]/div[2]")).click();

        }

    @Test (priority = 3)

private void selectPickUpDate(){
    WebElement timeInput = driver.findElement(By.cssSelector("input[data-testid='rental-search-form-time-input-start']"));

    // Get the value of the input field
    String actualTimeValue = timeInput.getAttribute("value");

    // Expected time value
    String expectedTimeValue = "09:00";

    // Compare the actual value with the expected value using Assert.assertEquals()
    Assert.assertEquals(actualTimeValue, expectedTimeValue);

}

    @Test (priority = 4)

    private void selectDropOffDate(){

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[9]/div/div[1]/div[1]/input")).click();

        WebElement dropOff = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[9]/div/div[2]/div/div/div[1]/div[1]/div[2]/div"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 200);", dropOff);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[9]/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[12]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[9]/div/div[2]/div/div/div[2]/div/div")).click();

    }
    @Test (priority = 5)

    private void clickButtonSearchCar(){

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[11]/div/div/div")).click();
        try {
            Thread.sleep(7000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[4]/div/div[1]/div/div[1]/div/div[3]/div/div/h2")).getText(),"Car Rental Without Driver");

    }

    @Test (priority = 6)

    private void selectCar(){

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[3]/div")).click();

        try {
            Thread.sleep(6000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div/h2")).getText(),"Select Rental Provider");

    }

    @Test (priority = 7)

    private void selectCarProvider(){

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div/div[4]/div[2]/div[2]/div[2]/div")).click();
        try {
            Thread.sleep(5000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/h3")).getText(),"Rental Policy");

    }

    @Test (priority = 8)

    private void continueProductDetail(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1300);");
        try {
            Thread.sleep(3000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"RENTAL_PICKUP_LOCATION\"]/div/div/div[3]/div[1]/div[2]/div/div/div[2]")).click();
        try {
            Thread.sleep(2000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"RENTAL_PICKUP_LOCATION\"]/div/div/div[3]/div[2]/div/div/div[1]/div[1]/div/div[1]/div")).click();
        try {
            Thread.sleep(2000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"RENTAL_PICKUP_LOCATION\"]/div/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/div[1]/div/div[3]")).click();
        try {
            Thread.sleep(2000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"RENTAL_DROPOFF_LOCATION\"]/div/div/div[5]/div[1]/div[2]/div/div/div[2]")).click();
        try {
            Thread.sleep(2000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"RENTAL_DROPOFF_LOCATION\"]/div/div/div[5]/div[2]/div/div/div[1]/div/div[1]/input")).click();
        try {
            Thread.sleep(2000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"RENTAL_DROPOFF_LOCATION\"]/div/div/div[5]/div[2]/div/div/div[1]/div/div[2]/div/div/div/div[5]/div[1]/h3")).click();
        try {
            Thread.sleep(2000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("window.scrollBy(0, 600);");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div/div[1]/div/div[5]/div[3]/div")).click();




        }
    @Test (priority = 9, dependsOnMethods = ("continueProductDetail"))

    private void contactDetails(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/h1")).getText(),"Your Booking");

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div[1]/input")).sendKeys("Martin Machiko");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[1]/input")).sendKeys("82110944055");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/input")).sendKeys("martinmachiko55@gmail.com");



    }

    @Test (priority = 10, dependsOnMethods = ("continueProductDetail"))

    private void contactDriver(){
        driver.findElement(By.xpath("//*[@id=\"adultForm0\"]/div/div/div[2]/div[1]/div/div/select")).click();
        driver.findElement(By.xpath(" //*[@id=\"adultForm0\"]/div/div/div[2]/div[1]/div/div/select/option[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"adultForm0\"]/div/div/div[2]/div[2]/div/div[1]/div")).sendKeys("Martin Machiko");

        driver.findElement(By.xpath("//*[@id=\"adultForm0\"]/div/div/div[2]/div[3]/div[1]/input")).sendKeys("82110944055");


    }

    @Test (priority = 11, enabled = false)

    private void specialRequest(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[9]/div/div/div[3]/div[1]/textarea")).sendKeys("Request Bantal");

    }
    //*[@id="__next"]/div[2]/div[2]/div[1]/div[9]/div/div/div[3]/div[1]/textarea

    @Test (priority = 12)

    private void checkRentalReq(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[11]/div/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]")).click();

        WebElement rentalReq = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 400);", rentalReq);


        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[2]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
    }

    @Test (priority = 13, dependsOnMethods = ("checkRentalReq"))

    private void continuePayment(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[14]/div/div/div")).click();

        try {
            Thread.sleep(2000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(" /html/body/div[3]/div/div[2]/div/div[2]/div/div[3]")).click();
        try {
            Thread.sleep(10000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 14, dependsOnMethods = ("continuePayment"))

    private void selectPaymentMethod(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/h1")).getText(),"Payment");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div[3]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div[7]/div[2]/div[2]/div")).click();

        try {
            Thread.sleep(10000); // 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test (priority = 15, dependsOnMethods = ("selectPaymentMethod"))

    private void paymentInstruction(){
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div/div[2]")).getText(),"Transfer Payment Instructions");

    }

    @AfterTest

    private void closeBrowser(){

        driver.quit();

    }
}
