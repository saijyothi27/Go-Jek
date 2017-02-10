package steps;

/**
 * Created by saijyoth on 2/7/2017.
 */


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;
import utilities.DriverFactory;

public class HomePageSteps {

    @Given("^Guest opens clearTrip website homepage$")
    public void guestOpensClearTripWebsiteHomepage() {
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
