import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exercise {

    private static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


    }

    @Test
    public void testExercise() throws InterruptedException {
        driver.navigate().to("https://antycaptcha.amberteam.pl/exercises/exercise1");
        String firstTxt = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]/code")).getText();
        if (firstTxt.equals("B1")){
            driver.findElement(By.id("btnButton1")).click();
        }else{
            driver.findElement(By.id("btnButton2")).click();
        }
        String secondTxt = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]/code")).getText();
        if (secondTxt.equals("B1")){
            driver.findElement(By.id("btnButton1")).click();
        }else{
            driver.findElement(By.id("btnButton2")).click();
        }
        String thirdTxt = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[2]/code")).getText();
        if (thirdTxt.equals("B1")){
            driver.findElement(By.id("btnButton1")).click();
        }else{
            driver.findElement(By.id("btnButton2")).click();
        }
        Thread.sleep(1000);

        driver.findElement(By.id("solution")).click();
        boolean wait = new WebDriverWait(driver,Duration.ofSeconds(2)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("wrap")),"OK. Good answer"));
        //Thread.sleep(5500);
        String result = driver.findElement(By.className("wrap")).getText();
        Assert.assertEquals("OK. Good answer",result);
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }


}
