package utilities;

/**
 * Created by saijyoth on 2/10/2017.
 */


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



public class PageUtilities {


    public WebDriver driver= new DriverFactory().getDriver();


    public void select(WebElement element, String visibleText) {
        org.openqa.selenium.support.ui.Select selection = new org.openqa.selenium.support.ui.Select(element);
        selection.selectByVisibleText(visibleText);
    }

    public void type(WebElement element, String inputText){
        element.clear();
        element.sendKeys(inputText);
    }




    public boolean verifyPresenceOfElement(WebElement element) {
        try {
            if(element.isDisplayed())
                return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

        return false;
    }







    public void waitForPresenceOfElement(WebElement element){
        Wait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }





    public void waitForAjaxCallToFinish() {

        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
                int i;
                while(true){
                    Boolean ajaxIsComplete = (Boolean) (jsDriver).executeScript("return jQuery.active == 0");
                    if (ajaxIsComplete)
                        break;
                }
                Thread.sleep(1000);
            }

            else {
                System.out.println("Web driver: " + driver + " cannot execute javascript");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void waitForPageLoad(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
}
