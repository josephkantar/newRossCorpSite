package rossCorpSite.tests;

import rossCorpSite.driver.DriverManager;
import rossCorpSite.pages.CareersPage;
import rossCorpSite.pages.HomePage;
import rossCorpSite.pages.InvestorPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static rossCorpSite.driver.Driver.initDriver;
import static rossCorpSite.driver.Driver.quitDriver;

public class BaseTest {

   HomePage homePage;
   InvestorPage investorPage;
   CareersPage careersPage;

    @BeforeMethod

    public void setUp() {

        initDriver();
        homePage=new HomePage(DriverManager.getDriver());
        investorPage =new InvestorPage(DriverManager.getDriver());
        careersPage =new CareersPage(DriverManager.getDriver());
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}

// For ALLURE report we should navigate to this URL
// https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.19.0/
// then click on " allure-commandline-2.19.0.zip
// copy path of bin and paste to
