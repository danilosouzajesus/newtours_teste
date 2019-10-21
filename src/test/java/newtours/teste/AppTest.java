package newtours.teste;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/Destination"}, features = "src/test/resources", tags = "@NewTours", 
glue = "newtours.teste", monochrome = true, dryRun = false)
public class AppTest {
}