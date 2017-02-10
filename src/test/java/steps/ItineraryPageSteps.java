package steps;

/**
 * Created by saijyoth on 2/10/2017.
 */


        import pages.ItineraryPage;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.When;

public class ItineraryPageSteps {

    @And("^Guest verifies the itinerary details, accepts terms and conditions and continues booking$")
    public void guestVerifiesTheItineraryDetailsAcceptsTermsAndConditionsAndContinuesBooking() {
        // Write code here that turns the phrase above into concrete actions
        new ItineraryPage().verifyItineraryDetailsAndContinueBooking();
    }

    @When("^Guest enters email address and continues booking$")
    public void guestEntersEmailAddressAndContinuesBooking() {
        // Write code here that turns the phrase above into concrete actions
        new ItineraryPage().enterEmailAndContinueBooking();
    }

    @And("^Guest enters traveller details and continues booking$")
    public void guestEntersTravellerDetailsAndContinuesBooking(){
        // Write code here that turns the phrase above into concrete actions
        new ItineraryPage().enterTravellerDetailsAndContinueBooking();
    }
}

