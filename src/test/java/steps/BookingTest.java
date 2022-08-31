package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\HP ProBook\\IdeaProjects\\Booking.com\\src\\test\\resources\\feature\\booking.feature"},
        glue = "steps",
        plugin = { "pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class BookingTest extends AbstractTestNGCucumberTests {

}
