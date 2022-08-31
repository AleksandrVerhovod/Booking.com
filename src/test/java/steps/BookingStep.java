package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BookingStep {
    @Before
    public void setUp() {
        Configuration.timeout = 6000;
        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
    }
    @Given("Main Booking page opened")
    public void mainBookingPageOpened() {
        open("https://www.booking.com/searchresults.en-gb.html");
    }

    @When("User type name hotel {string}")
    public void userTypeNameHotel(String nameHotel) {
        String inputNameXPath = "//div[@id=\"left_col_wrapper\"]//input[@placeholder=\"Where are you going?\"]";
        $(By.xpath(inputNameXPath)).hover().sendKeys(nameHotel);
    }

    @And("Find hotel by {string}")
    public void findHotelBy(String search) {
        String searchButton = String.format("//div[@id='left_col_wrapper']//button[@type='submit']//span[text()='%s']", search);
        $(By.xpath(searchButton)).shouldBe(Condition.visible).click();
    }

    @Then("Check hotel name {string} and rating {string} respond")
    public void checkNameAndRatingRespond(String nameHotel, String ratingHotel) {
        String nameHotelXPath = String.format("//div[@id='search_results_table']//div[contains(text(),'%s')]", nameHotel);
        String ratingHotelXPath = String.format("//div[text()='%s']",ratingHotel);
        String actualNameHotel = $(By.xpath(nameHotelXPath)).getText();
        String actualRatingHotel = $(By.xpath(ratingHotelXPath)).getText();
        Assert.assertEquals(actualNameHotel,nameHotel, "Hotel isn't displayed");
        Assert.assertEquals(actualRatingHotel,ratingHotel, "Rating of hotel incorrect");
    }

}
