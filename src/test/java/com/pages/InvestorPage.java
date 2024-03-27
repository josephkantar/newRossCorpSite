package com.pages;

import com.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class InvestorPage extends BasePage {

    public InvestorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Social Responsibility") private WebElement socialResponsibilityPageLink;

    public InvestorPage verifyInvestorPageUrlAndTittle(){

        Allure.step("the user is on the Investor Page and verify url and tittle");

        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),"https://investors.rossstores.com/");
        assertThat(DriverManager.getDriver().getTitle(),containsString("overview"));

        return this;
    }

}
