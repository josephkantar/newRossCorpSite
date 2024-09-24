package rossCorpSite.pages;

import rossCorpSite.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

import static rossCorpSite.constants.FrameworkConstants.getUrl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class CareersPage extends BasePage{

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@id='menu-item-48']") private WebElement investorPageLink;

    @FindBy(xpath = "//div[@id='onetrust-close-btn-container']//button[@aria-label='Close']") private WebElement closeCookieButton;


    @FindBy(xpath = "//select[@id='filter-by-location']") private WebElement dropDownLocation;
    @FindBy(id = "jobs-list") private WebElement jobsList;
    @FindBy(xpath = "//a[@href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']") private WebElement viewRole;
    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary']") private List<WebElement> qualityAssuranceList;
    @FindBy(xpath = "//div[@class='position-location text-large']") private List<WebElement> istanbulTurkeyList;

    public CareersPage clickFooterLinksAndVerifyUrlAndTittles(){

        Allure.step("The user navigate to careers page and verify Url and Tittle");

        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),"https://jobs.rossstores.com/");
        assertThat(DriverManager.getDriver().getTitle(),containsString("Careers"));
        navigateTo_URL(getUrl());


        return this;
    }

    public InvestorPage goToInvestorPageViaCompany(){

        Allure.step("The user navigates to the investor page via homepage");

        click(investorPageLink);

        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }

        }

        return new InvestorPage(driver);
    }

}