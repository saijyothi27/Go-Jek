package pages;

/**
 * Created by saijyoth on 2/7/2017.
 */


        import Data.Data;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import utilities.PageUtilities;

public class HomePage extends PageUtilities{

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    Data data = new Data();

    @FindBy(css = "[id=\"SearchForm\"] h1")
    public WebElement searchHeader;

    @FindBy(css = "[for=\"RoundTrip\"]")
    private WebElement roundTripRadioBtn;

    @FindBy(id = "FromTag")
    private WebElement fromInput;

    @FindBy(id = "ToTag")
    private WebElement toInput;

    @FindBy(id = "SearchBtn")
    private WebElement searchBtn;

    @FindBy(id = "DepartDate")
    private WebElement departDateInput;

    @FindBy(id = "ReturnDate")
    private WebElement returnDateInput;

    @FindBy(id = "Adults")
    private WebElement adultsDropDown;

    @FindBy(id = "Childrens")
    private WebElement childrenDropDown;

    @FindBy(id = "Infants")
    private WebElement infantsDropDown;

    private void selectDate(int date, int month, int year){
        driver.findElement(By.xpath("//*[@data-month=\""+month+"\" and @data-year=\""+year+"\"]//a[text()=\""+date+"\"]")).click();
    }

    public void selectRoundTripAndVerifyTheSelection() {
        Assert.assertTrue(searchHeader.getText().equals(data.searchFlightsText));
        roundTripRadioBtn.click();
        verifyPresenceOfElement(returnDateInput);
    }

    public void enterBookingDetails() {
        type(fromInput,data.fromStation);
        type(toInput,data.toStation);
        departDateInput.click();
        selectDate(data.departDate,data.departMonth,data.departYear);
        returnDateInput.click();
        selectDate(data.returnDate,data.returnMonth,data.returnYear);
        select(adultsDropDown,data.noOfAdults);
        select(childrenDropDown,data.noOfChildren);
        select(infantsDropDown,data.noOfInfants);
    }

    public void searchForFlights() {
        searchBtn.click();
        waitForAjaxCallToFinish();
    }
}

