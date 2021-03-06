package com.magier.mybank.domain.cucumber;

import com.magier.mybank.domain.reporting.PdfSimpleReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Dan on 25/06/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/cucumber",
        glue = {"com.magier.mybank.domain"},
        format = {"json:target/cucumber/wikipedia.json", "html:target/cucumber/wikipedia.html", "pretty",
                "tzatziki.analysis.exec.gson.JsonEmitterReport:target/"+ PdfSimpleReport.MY_BANK}
        //, tags = {"@wip"}
)
public class BDDRunnerTest {
}
