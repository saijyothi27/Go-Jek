package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import pages.HomePage;
import utilities.DriverFactory;

/**
 * Created by saijyoth on 2/10/2017.
 */
public class HomePageSteps {
    @Given("^Guest opens clearTrip website homepage$")
    public void guestOpensClearTripWebsiteHomepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new DriverFactory().getDriver();
    }
    @When("^Guest selects round trip$")
    public void guestSelectsRoundTrip() {
        // Write code here that turns the phrase above into concrete actions
        new HomePage().selectRoundTripAndVerifyTheSelection();
    }

    @And("^Guest gives booking details of the trip$")
    public void guestGivesBookingDetailsOfTheTrip() {
        // Write code here that turns the phrase above into concrete actions
        new HomePage().enterBookingDetails();
    }

    @And("^Guest searches for the available flights$")
    public void guestSearchesForTheAvailableFlights() {
        // Write code here that turns the phrase above into concrete actions
        new HomePage().searchForFlights ();
    }
}
