package pl.najavie;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by krzysztof on 1/4/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/",plugin = {"pretty","html:out"})
public class CucumberTest {

}
