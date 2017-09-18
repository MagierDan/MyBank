package com.magier.mybank.domain;

import com.magier.mybank.domain.cucumber.BDDRunnerTest;
import com.magier.mybank.domain.reporting.PdfSimpleReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BDDRunnerTest.class})
public class RunAllFeatureAndGenerateReportTest {

    @AfterClass
    public static void generateExecutionReport() throws Exception {
        new PdfSimpleReport().generate();
    }
}
