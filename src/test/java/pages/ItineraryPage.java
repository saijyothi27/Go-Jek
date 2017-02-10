package pages;

/**
 * Created by saijyoth on 2/10/2017.
 */


        import Data.Data;
        import org.junit.Assert;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import utilities.PageUtilities;

public class ItineraryPage extends PageUtilities {

    public ItineraryPage(){
        PageFactory.initElements(driver, this);
    }
    Data data = new Data();

    @FindBy(css = ".onwBlock")
    private WebElement itineraryOnwardDetails;

    @FindBy(css = ".retBlock")
    private WebElement itineraryReturnDetails;

    @FindBy(id = "itineraryBtn")
    private WebElement continueBookingBtn;

    @FindBy(id = "username")
    private WebElement emailInput;

    @FindBy(id = "LoginContinueBtn_1")
    private WebElement emailSectionContinueBtn;

    @FindBy(id = "AdultTitle1")
    private WebElement titleDropDown;

    @FindBy(id = "AdultFname1")
    private WebElement firstNameInput;

    @FindBy(id = "AdultLname1")
    private WebElement lastNameInput;

    @FindBy(id = "mobileNumber")
    private WebElement mobileNumberInput;

    @FindBy(id = "travellerBtn")
    private WebElement travelersSectionContinueBtn;


    public void verifyItineraryDetailsAndContinueBooking() {
        waitForPageLoad();
        String onwardItineraryText=itineraryOnwardDetails.getText();
        String returnItineraryText=itineraryReturnDetails.getText();
        Assert.assertTrue(onwardItineraryText.contains(data.fromStation.split(",")[0]+" â†’ "+data.toStation.split(",")[0]));
        Assert.assertTrue(returnItineraryText.contains(data.toStation.split(",")[0]+" â†’ "+data.fromStation.split(",")[0]));
        Assert.assertTrue(onwardItineraryText.contains(String.valueOf(data.departDate)));
        Assert.assertTrue(returnItineraryText.contains(String.valueOf(data.returnDate)));
        continueBookingBtn.click();
        waitForAjaxCallToFinish();
    }

    public void enterEmailAndContinueBooking() {
        type(emailInput,data.emailId);
        emailSectionContinueBtn.click();
        waitForAjaxCallToFinish();

    }

    public void enterTravellerDetailsAndContinueBooking() {
        select(titleDropDown,data.travellerTitle);
        type(firstNameInput,data.travellerFirstName);
        type(lastNameInput,data.travellerLastName);
        type(mobileNumberInput,data.travellerMobileNumber);
        travelersSectionContinueBtn.click();
    }
}
