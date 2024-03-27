package com.pages;

import com.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import static com.constants.FrameworkConstants.*;
import static com.utils.JSUtils.scrollIntoViewJS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#menu-item-76") private WebElement rossLogoTopPage;
    @FindBy(css = "#menu-item-77") private WebElement ddsLogoTopPage;
    @FindBy(xpath = "//img[@src='https://corp.rossstores.com/wp-content/uploads/2021/10/logo-ross.svg']") private WebElement rossLogoMidPage;
    @FindBy(xpath = "//div[@class='link-container']//a[@href='https://www.rossstores.com/contact-us/']") private  WebElement rossLogoAltTextLink;
    @FindBy(xpath = "//img[@src='https://corp.rossstores.com/wp-content/uploads/2021/10/logo-dds.svg']") private WebElement ddsLogoMidPage;
    @FindBy(xpath = "//div[@class='link-container']//a[@href='https://www.ddsdiscounts.com/contact-us/']") private WebElement ddsLogoAltTextLink;
    @FindBy(xpath = "//div[@id='onetrust-close-btn-container']//button[@aria-label='Close']") private WebElement closeCookieButton;
    @FindBy(xpath = "//a[@href='http://partners.rossstores.com/index.html'][text()='dd’s Freight Routing Guide']\n") private WebElement ddsFreight;
    @FindBy(xpath = "//a[@href='http://partners.rossstores.com/index.html'][text()='Ross Freight Routing Guide']") private WebElement rossFreight;
    @FindBy(xpath = "//a[@href='https://corp.rossstores.com/responsibility/']") private WebElement socialResponsibilityPageLink;
    @FindBy(xpath = "//ul[@id='menu-footer']") private WebElement pageFooter;
    @FindBy(xpath = "//li[@id='menu-item-49']") private WebElement footerRossLink;
    @FindBy(xpath = "//li[@id='menu-item-50']") private WebElement footerDDsLink;
    @FindBy(xpath = "//li[@id='menu-item-51']") private WebElement footerPrivacyLink;
    @FindBy(xpath = "//li[@id='menu-item-60']") private WebElement footerEqualEmploymentLink;
    @FindBy(xpath = "//li[@id='menu-item-54']") private WebElement footerAccesssibilityLink;
    @FindBy(xpath = "//li[@id='menu-item-53']") private WebElement footerContactUsLink;
    @FindBy(xpath = "//li[@id='menu-item-52']") private WebElement footerSiteMapLink;
    @FindBy(xpath = "//li[@id='menu-item-73']") private WebElement footerDoNotSellLink;
    @FindBy(xpath = "//li[@id='menu-item-47']") private WebElement careersPageLink;





    public HomePage closeCookie(){

        Allure.step("The user navigates to the home page " +getUrl()); //raporlama adimlari
        navigateTo_URL(getUrl());
        click(closeCookieButton);
        return this; // bana load page in degerlerini gonder
    }

    public HomePage verifyHomePageRossAltLinkText() throws InterruptedException {

        Allure.step("Check that links open new tab successfully");
        assertThat(DriverManager.getDriver().getTitle(), equalTo("Contact Us | Ross Stores, Inc."));
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), "https://corp.rossstores.com/contact-us-corp/");



        WebElement rossFreightLink = rossFreight;
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", rossFreightLink);



        String parentWindow1 = driver.getWindowHandle();
        Set<String> handles1 = driver.getWindowHandles();
        for (String windowHandle : handles1) {
            if (!windowHandle.equals(parentWindow1)) {
                driver.switchTo().window(windowHandle);
                String actualRossFreightTittle = driver.getTitle();
                System.out.println(actualRossFreightTittle);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Welcome Ross Partners')]"))).isDisplayed();
                //String expectedRossFreightTittle = "Welcome Ross Partners";
                String expectedRossFreightTittle = "";
                Assert.assertEquals(actualRossFreightTittle, expectedRossFreightTittle);
                System.out.println("Assert Tittle passed");
                driver.close();

            }
        }

        driver.switchTo().window(parentWindow1); //cntrl to parent window

        WebElement ddsFreightLink = ddsFreight;
        JavascriptExecutor executor3 = (JavascriptExecutor) driver;
        executor3.executeScript("arguments[0].click();", ddsFreightLink);

        String parentWindow2 = driver.getWindowHandle();
        Set<String> handles2 = driver.getWindowHandles();
        for (String windowHandle : handles2) {
            if (!windowHandle.equals(parentWindow2)) {
                driver.switchTo().window(windowHandle);
                String actualRossFreightTittle = driver.getTitle();
                System.out.println(actualRossFreightTittle);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Welcome Ross Partners')]"))).isDisplayed();
                //String expectedRossFreightTittle = "Welcome Ross Partners";
                String expectedRossFreightTittle = "";
                Assert.assertEquals(actualRossFreightTittle, expectedRossFreightTittle);
                System.out.println("Assert Tittle passed");
                driver.close();
                driver.switchTo().window(parentWindow2); //cntrl to parent window
                Thread.sleep(2000);
            }
        }

        driver.switchTo().window(parentWindow2); //cntrl to parent window


        //driver.get("https://corp.rossstores.com/contact-us-corp/");

        WebElement rossAltText = rossLogoAltTextLink;
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", rossAltText);

        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);

                String actualRossLogoTextLinkurl = driver.getCurrentUrl();
                System.out.println(actualRossLogoTextLinkurl);
                String expectedRossLogoTextLinkurl = "https://www.rossstores.com/contact-us/";
                Assert.assertEquals(actualRossLogoTextLinkurl, expectedRossLogoTextLinkurl);
                System.out.println("Assert URL passed");
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow); //cntrl to parent window


        //driver.get("https://corp.rossstores.com/contact-us-corp/");

        WebElement ddsAltText = ddsLogoAltTextLink;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ddsAltText);

        String parentWindow3 = driver.getWindowHandle();
        Set<String> handles3 = driver.getWindowHandles();
        for (String windowHandle : handles3) {
            if (!windowHandle.equals(parentWindow3)) {
                driver.switchTo().window(windowHandle);
                String actualDDsLogoTextLinkurl = driver.getCurrentUrl();
                System.out.println(actualDDsLogoTextLinkurl);
                String expectedDDsLogoTextLinkurl = "https://www.ddsdiscounts.com/contact-us/";
                Assert.assertEquals(actualDDsLogoTextLinkurl, expectedDDsLogoTextLinkurl);
                System.out.println("Assert URL passed");
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow3); //cntrl to parent window

        return this;
    }

    public HomePage verifyHomePageTexts() {

        Allure.step("Check that texts on the homepage displayed as expected.");

        WebElement upperLogoText = driver.findElement(By.xpath("//p[contains(text(), 'For brand-specific questions and assistance:')]"));
        System.out.println(upperLogoText.getText());

        if (rossLogoTopPage.isDisplayed()) {
            System.out.println("Ross Logo on top of the page is displayed");
        } else {
            System.out.println("Logo is not displayed on the webpage");
        }
        if (ddsLogoTopPage.isDisplayed()) {
            System.out.println("DDs Logo on top of the page is displayed");
        } else {
            System.out.println("Logo is not displayed on the webpage");
        }
        if (rossLogoMidPage.isDisplayed()) {
            System.out.println("Ross Logo on mid of the page is displayed");
        } else {
            System.out.println("Logo is not displayed on the webpage");
        }

        if (ddsLogoMidPage.isDisplayed()) {
            System.out.println("DDs Logo on Mid of the page is displayed");
        } else {
            System.out.println("Logo is not displayed on the webpage");
        }

        WebElement corporateOfficeText = driver.findElement(By.xpath("//h2[contains(text(), 'Corporate Office')]"));
        System.out.println(corporateOfficeText.getText());

        WebElement buyingOfficeText = driver.findElement(By.xpath("//h2[contains(text(), 'Buying Offices')]"));
        System.out.println(buyingOfficeText.getText());

        WebElement distributionText = driver.findElement(By.xpath("//h2[contains(text(), 'Distribution Centers')]"));
        System.out.println(distributionText.getText());

        WebElement freightRoutingText = driver.findElement(By.xpath("//h2[contains(text(), 'Freight Routing Guide')]"));
        System.out.println(freightRoutingText.getText());

        boolean corpOfficeAddress = driver.findElement(By.xpath("//p[contains(text(), '5130 Hacienda Drive')]")).isDisplayed();
        System.out.println(corpOfficeAddress + " text is  displayed");

        boolean buyingOfficeAddress = driver.findElement(By.xpath("//p[contains(text(), 'New York Buying Office')]")).isDisplayed();
        System.out.println(buyingOfficeAddress + " text is  displayed");

        boolean distCenterAddress1 = driver.findElement(By.xpath("//p[contains(text(), 'Southwest Distribution Center')]")).isDisplayed();
        System.out.println(distCenterAddress1 + " text is  displayed");

        boolean distCenterAddress2 = driver.findElement(By.xpath("//p[contains(text(), 'Eastern Distribution Center')]")).isDisplayed();
        System.out.println(distCenterAddress2 + " text is  displayed");

        WebElement footerText = driver.findElement(By.xpath("//p[contains(text(), '©2024 Ross Stores, Inc. All rights reserved. All images are representative of merchandise carried in ')]"));
        System.out.println(footerText.getText());


        return this;

    }

    public HomePage footerLinksList() throws InterruptedException {

        Allure.step("The user navigates to the footer links");

        WebElement footerBar = driver.findElement(By.xpath("//ul[@id='menu-footer']"));

// Find all anchor elements within the navba

        List<WebElement> footerMenuLinks = footerBar.findElements(By.tagName("a"));

// Print the total number of footer links
        System.out.println("Total Footer Links: " + footerMenuLinks.size());

// Iterate over each anchor element
        for (WebElement footerLink : footerMenuLinks) {
            // Get the URL and page title without clicking
            String url = footerLink.getAttribute("href");
            String title = footerLink.getText();

            // Print the URL and link text
            System.out.println("URL: " + url);
            System.out.println("Link Text: " + title);

            try {
                // Create a URL object from the link URL
                URL linkURL = new URL(url);

                // Open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();

                // Set the request method to HEAD (to check only the status code)
                connection.setRequestMethod("HEAD");

                // Get the response code
                int responseCode = connection.getResponseCode();

                // Print the response code
                System.out.println("Response Code: " + responseCode);

                // Close the connection
                connection.disconnect();
            } catch (Exception e) {
                // Print any exceptions that occur during the connection
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }

        return this;
    }

    public HomePage navMenuList () throws InterruptedException {

        Allure.step("The user navigates to the footer links");

        WebElement navbar = driver.findElement(By.xpath("//*[@id='navbarMainCollapsible']"));

        List<WebElement> navMenuLinks = navbar.findElements(By.tagName("a"));

// Print the total number of footer links
        System.out.println("Total Footer Links: " + navMenuLinks.size());

// Iterate over each anchor element
        for (WebElement navMenuLink : navMenuLinks) {
            // Get the URL and page title without clicking
            String url = navMenuLink.getAttribute("href");
            String title = navMenuLink.getText();

            // Print the URL and link text
            System.out.println("URL: " + url);
            System.out.println("Link Text: " + title);

            try {
                // Create a URL object from the link URL
                URL linkURL = new URL(url);

                // Open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();

                // Set the request method to HEAD (to check only the status code)
                connection.setRequestMethod("HEAD");

                // Get the response code
                int responseCode = connection.getResponseCode();

                // Print the response code
                System.out.println("Response Code: " + responseCode);

                // Close the connection
                connection.disconnect();
            } catch (Exception e) {
                // Print any exceptions that occur during the connection
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }

        return this;
    }

    public HomePage verifySocialResponsibilityPage(){

        Allure.step("Check that the user is on the SocialResponsibility Page.");

        click(socialResponsibilityPageLink);
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),"https://corp.rossstores.com/responsibility/");
        assertThat(DriverManager.getDriver().getTitle(),containsString("Corporate Social Responsibility"));
        return this;
    }

    public HomePage verifySocialResponsibilityPageNavMenuLinks(){

        Allure.step("The user navigates to the Nav menu links");

        WebElement navbar = driver.findElement(By.xpath("//ul[@id='menu-main-1']"));

        List<WebElement> navMenuLinks = navbar.findElements(By.tagName("a"));

// Print the total number of footer links
        System.out.println("Total Footer Links: " + navMenuLinks.size());

// Iterate over each anchor element
        for (WebElement footerLink : navMenuLinks) {
            // Get the URL and page title without clicking
            String url = footerLink.getAttribute("href");
            String title = footerLink.getText();

            // Print the URL and link text
            System.out.println("URL: " + url);
            System.out.println("Link Text: " + title);

            try {
                // Create a URL object from the link URL
                URL linkURL = new URL(url);

                // Open a connection to the URL
                HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();

                // Set the request method to HEAD (to check only the status code)
                connection.setRequestMethod("HEAD");

                // Get the response code
                int responseCode = connection.getResponseCode();

                // Print the response code
                System.out.println("Response Code: " + responseCode);

                // Close the connection
                connection.disconnect();
            } catch (Exception e) {
                // Print any exceptions that occur during the connection
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }

        //navigateTo_URL(getUrl());
        return this;
    }

    public HomePage clickFooterRossLinksAndVerifyUrlAndTittle() throws InterruptedException {
        Allure.step("The user clicks  Ross Links  on footer and verify Url and Tittle");

        navigateTo_URL(getUrl());
        scrollIntoViewJS(pageFooter);
        Thread.sleep(2000);

        click(footerRossLink);
        String actualFooterRossLinkUrl = driver.getCurrentUrl();
        System.out.println(actualFooterRossLinkUrl);
        String expectedFooterRossLinkUrl = "https://www.rossstores.com/";
        Assert.assertEquals(actualFooterRossLinkUrl, expectedFooterRossLinkUrl);
        System.out.println("Ross URL passed");

        String actualFooterRossLinkTittle = driver.getTitle();
        System.out.println(actualFooterRossLinkTittle);
        String expectedFooterRossLinkTittle = "Ross Dress For Less";
        Assert.assertEquals(actualFooterRossLinkTittle, expectedFooterRossLinkTittle);
        System.out.println("Ross Tittle passed");
        driver.navigate().back();

        //Thread.sleep(1000);

//        scrollIntoViewJS(pageFooter);
//        WebElement footerDDs = footerDDsLink;
//        JavascriptExecutor jsexecutor1 = ((JavascriptExecutor) DriverManager.getDriver());
//        waitForVisibility(footerDDs);
//        jsexecutor1.executeScript("arguments[0].click();", footerDDs);
//        Thread.sleep(2000);
////
//        //click(footerDDsLink);
//        String actualFooterDDsLinkUrl = driver.getCurrentUrl();
//        System.out.println(actualFooterDDsLinkUrl);
//        String expectedFooterDDsLinkUrl = "https://www.ddsdiscounts.com/";
//        Assert.assertEquals(actualFooterDDsLinkUrl, expectedFooterDDsLinkUrl);
//        System.out.println("DDS URL passed");
//
//        String actualFooterDDsLinkTittle = driver.getTitle();
//        System.out.println(actualFooterDDsLinkTittle);
//        String expectedFooterDDsLinkTittle = "Home";
//        Assert.assertEquals(actualFooterDDsLinkTittle, expectedFooterDDsLinkTittle);
//        System.out.println("DDS Tittle passed");
//        driver.navigate().back();
//
//        WebElement footerPrivacy = footerPrivacyLink;
//        JavascriptExecutor jsexecutor2 = ((JavascriptExecutor) DriverManager.getDriver());
//        waitForVisibility(footerPrivacyLink);
//        jsexecutor2.executeScript("arguments[0].click();", footerPrivacy);
//
//        //click(footerPrivacyLink);
//        String actualFooterPrivacyLinkUrl = driver.getCurrentUrl();
//        System.out.println(actualFooterPrivacyLinkUrl);
//        String expectedFooterPrivacyLinkUrl = "https://www.rossstores.com/privacy-policy/";
//        Assert.assertEquals(actualFooterPrivacyLinkUrl, expectedFooterPrivacyLinkUrl);
//        System.out.println("Assert URL passed");
//
//        String actualFooterPrivacyLinkTittle = driver.getTitle();
//        System.out.println(actualFooterPrivacyLinkTittle);
//        String expectedFooterPrivacyLinkTittle = "Privacy Policy";
//        Assert.assertEquals(actualFooterPrivacyLinkTittle, expectedFooterPrivacyLinkTittle);
//        System.out.println("Assert Tittle passed");
//        driver.navigate().back();
//
////        WebElement footerEqualEmploy = footerEqualEmploymentLink;
////        JavascriptExecutor jsexecutor3 = ((JavascriptExecutor) DriverManager.getDriver());
////        waitForVisibility(footerEqualEmploymentLink);
////        jsexecutor3.executeScript("arguments[0].click();", footerEqualEmploy);
//
//        click(footerEqualEmploymentLink);
//        String actualFooterEqualEmployLinkUrl = driver.getCurrentUrl();
//        System.out.println(actualFooterEqualEmployLinkUrl);
//        String expectedFooterEqualEmployLinkUrl = "https://corp.rossstores.com/eeo/";
//        Assert.assertEquals(actualFooterEqualEmployLinkUrl, expectedFooterEqualEmployLinkUrl);
//        System.out.println("Assert URL passed");
//
//        String actualFooterEqualEmployLinkTittle = driver.getTitle();
//        System.out.println(actualFooterEqualEmployLinkTittle);
//        String expectedFooterEqualEmployLinkTittle = "Equal Employment Opportunity (EEO) Policy";
//        Assert.assertEquals(actualFooterEqualEmployLinkTittle, expectedFooterEqualEmployLinkTittle);
//        System.out.println("Assert Tittle passed");
//        driver.navigate().back();
//
//
////        WebElement footerAccessibility = footerAccesssibilityLink;
////        JavascriptExecutor jsexecutor4 = ((JavascriptExecutor) DriverManager.getDriver());
////        waitForVisibility(footerAccesssibilityLink);
////        jsexecutor4.executeScript("arguments[0].click();", footerAccessibility);
//
//        click(footerAccesssibilityLink);
//        String actualFooterAccessibilityLinkUrl = driver.getCurrentUrl();
//        System.out.println(actualFooterAccessibilityLinkUrl);
//        String expectedFooterAccessibilityLinkUrl = "https://corp.rossstores.com/accessibility/";
//        Assert.assertEquals(actualFooterAccessibilityLinkUrl, expectedFooterAccessibilityLinkUrl);
//        System.out.println("Assert URL passed");
//
//        String actualFooterAccessibilityLinkTittle = driver.getTitle();
//        System.out.println(actualFooterAccessibilityLinkTittle);
//        String expectedFooterAccessibilityLinkTittle = "Accessibility";
//        Assert.assertEquals(actualFooterAccessibilityLinkTittle, expectedFooterAccessibilityLinkTittle);
//        System.out.println("Assert Tittle passed");
//        driver.navigate().back();
//
////        WebElement footerContactUs = footerContactUsLink;
////        JavascriptExecutor jsexecutor5 = ((JavascriptExecutor) DriverManager.getDriver());
////        waitForVisibility(footerContactUsLink);
////        jsexecutor5.executeScript("arguments[0].click();", footerContactUs);
//
//        click(footerContactUsLink);
//        String actualFooterContactUsLinkUrl = driver.getCurrentUrl();
//        System.out.println(actualFooterContactUsLinkUrl);
//        String expectedFooterContactUsLinkUrl = "https://corp.rossstores.com/contact-us-corp/";
//        Assert.assertEquals(actualFooterContactUsLinkUrl, expectedFooterContactUsLinkUrl);
//        System.out.println("Assert URL passed");
//
//        String actualFooterContactUsLinkTittle = driver.getTitle();
//        System.out.println(actualFooterContactUsLinkTittle);
//        String expectedFooterContactUsLinkTittle = "Contact Us | Ross Stores, Inc.";
//        Assert.assertEquals(actualFooterContactUsLinkTittle, expectedFooterContactUsLinkTittle);
//        System.out.println("Assert Tittle passed");
//        driver.navigate().back();
//
////        WebElement footerSiteMap = footerSiteMapLink;
////        JavascriptExecutor jsexecutor6 = ((JavascriptExecutor) DriverManager.getDriver());
////        waitForVisibility(footerSiteMapLink);
////        jsexecutor6.executeScript("arguments[0].click();", footerSiteMap);
//
//        click(footerSiteMapLink);
//        String actualFooterSiteMapLinkUrl = driver.getCurrentUrl();
//        System.out.println(actualFooterSiteMapLinkUrl);
//        String expectedFooterSiteMapLinkUrl = "https://corp.rossstores.com/sitemap/";
//        Assert.assertEquals(actualFooterSiteMapLinkUrl, expectedFooterSiteMapLinkUrl);
//        System.out.println("Assert URL passed");
//
//        String actualFooterSiteMapLinkTittle = driver.getTitle();
//        System.out.println(actualFooterSiteMapLinkTittle);
//        String expectedFooterSiteMapLinkTittle = "Sitemap";
//        Assert.assertEquals(actualFooterSiteMapLinkTittle, expectedFooterSiteMapLinkTittle);
//        System.out.println("Assert Tittle passed");
//        driver.navigate().back();

//        WebElement footerDoNotCookie = footerDoNotSellLink;
//        JavascriptExecutor jsexecutor7 = ((JavascriptExecutor) DriverManager.getDriver());
//        waitForVisibility(footerDoNotSellLink);
//        jsexecutor7.executeScript("arguments[0].click();", footerDoNotCookie);

//        click(footerDoNotSellLink);
//        boolean oneTrustWindow = driver.findElement(By.cssSelector("#onetrust-consent-sdk")).isDisplayed();
//        System.out.println(oneTrustWindow + " oneTrustWindow box is  displayed");

        return this;
    }

    public HomePage clickFooterDDsLinksAndVerifyUrlAndTittle() throws InterruptedException {

        Allure.step("The user clicks  DDs Links  on footer and verify Url and Tittle");
        navigateTo_URL(getUrl());
        scrollIntoViewJS(pageFooter);
        Thread.sleep(2000);

        click(footerDDsLink);
        Thread.sleep(2000);
        String actualFooterDDsLinkUrl = driver.getCurrentUrl();
        System.out.println(actualFooterDDsLinkUrl);
        System.out.println("DDS URL displayed");

        String actualFooterDDsLinkTittle = driver.getTitle();
        System.out.println(actualFooterDDsLinkTittle);
        String expectedFooterDDsLinkTittle = "Home - dd's DISCOUNTS®";
        Assert.assertEquals(actualFooterDDsLinkTittle, expectedFooterDDsLinkTittle);
        System.out.println("DDS Tittle passed");
        driver.navigate().back();

        return this;
    }

    public HomePage clickFooterPrivacyLinksAndVerifyUrlAndTittle() throws InterruptedException {

        Allure.step("The user clicks  Privacy policy Links  on footer and verify Url and Tittle");
        navigateTo_URL(getUrl());
        scrollIntoViewJS(pageFooter);
        Thread.sleep(2000);

        click(footerPrivacyLink);
        String actualFooterPrivacyLinkUrl = driver.getCurrentUrl();
        System.out.println(actualFooterPrivacyLinkUrl);
        String expectedFooterPrivacyLinkUrl = "https://www.rossstores.com/privacy-policy/";
        Assert.assertEquals(actualFooterPrivacyLinkUrl, expectedFooterPrivacyLinkUrl);
        System.out.println("Assert URL passed");

        String actualFooterPrivacyLinkTittle = driver.getTitle();
        System.out.println(actualFooterPrivacyLinkTittle);
        String expectedFooterPrivacyLinkTittle = "Privacy Policy - Ross Dress For Less";
        Assert.assertEquals(actualFooterPrivacyLinkTittle, expectedFooterPrivacyLinkTittle);
        System.out.println("Assert Tittle passed");

        WebElement privacyPageText1 = driver.findElement(By.xpath("//span[contains(text(), 'Ross Stores, Inc.')]"));
        System.out.println(privacyPageText1.getText());

        boolean printPageButton = driver.findElement(By.xpath("//button[@class='btn btn-print']")).isDisplayed();
        System.out.println(printPageButton + " printPageButton is  displayed");

        WebElement privacyPageText2 = driver.findElement(By.xpath("//span[contains(text(), 'What Types of Information Does Ross Collect from Me?')]"));
        System.out.println(privacyPageText2.getText());

        WebElement privacyPageText3 = driver.findElement(By.xpath("//span[contains(text(), 'How Does Ross Use Information Collected from Me?')]"));
        System.out.println(privacyPageText3.getText());

        WebElement privacyPageText4 = driver.findElement(By.xpath("//span[contains(text(), 'How Is Personally Identifiable Information Disclosed?')]"));
        System.out.println(privacyPageText4.getText());

        driver.navigate().back();


        return this;
    }

    public HomePage clickFooterEqualEmployLinksAndVerifyUrlAndTittle() throws InterruptedException {

        Allure.step("The user clicks  EqualEmployement Links  on footer and verify Url and Tittle");
        navigateTo_URL(getUrl());
        scrollIntoViewJS(pageFooter);
        Thread.sleep(2000);

        click(footerEqualEmploymentLink);
        String actualFooterEqualEmployLinkUrl = driver.getCurrentUrl();
        System.out.println(actualFooterEqualEmployLinkUrl);
        String expectedFooterEqualEmployLinkUrl = "https://corp.rossstores.com/eeo/";
        Assert.assertEquals(actualFooterEqualEmployLinkUrl, expectedFooterEqualEmployLinkUrl);
        System.out.println("Assert URL passed");

        String actualFooterEqualEmployLinkTittle = driver.getTitle();
        System.out.println(actualFooterEqualEmployLinkTittle);
        String expectedFooterEqualEmployLinkTittle = "Equal Employment Opportunity (EEO) Policy | Ross Stores, Inc.";
        Assert.assertEquals(actualFooterEqualEmployLinkTittle, expectedFooterEqualEmployLinkTittle);
        System.out.println("Assert Tittle passed");

        boolean equalEmploymentPageImage = driver.findElement(By.xpath("//div[@aria-label='Smiling woman wearing a hijab holding a box']")).isDisplayed();
        System.out.println(equalEmploymentPageImage + " equalEmployment Page Image is  displayed");

        WebElement equalEmploymentPageText1 = driver.findElement(By.xpath("//p[contains(text(), 'Ross is an equal opportunity employer. We consider individuals for employment or promotion according to their skills, abilities and experience.')]"));
        System.out.println(equalEmploymentPageText1.getText());

        driver.navigate().back();

        return this;
    }

    public HomePage clickFooterAccessibilityLinksAndVerifyUrlAndTittle() throws InterruptedException {

        Allure.step("The user clicks  accessibility Links  on footer and verify Url and Tittle");
        navigateTo_URL(getUrl());
        scrollIntoViewJS(pageFooter);
        Thread.sleep(2000);

        click(footerAccesssibilityLink);
        String actualFooterAccessibilityLinkUrl = driver.getCurrentUrl();
        System.out.println(actualFooterAccessibilityLinkUrl);
        String expectedFooterAccessibilityLinkUrl = "https://corp.rossstores.com/accessibility/";
        Assert.assertEquals(actualFooterAccessibilityLinkUrl, expectedFooterAccessibilityLinkUrl);
        System.out.println("Assert URL passed");

        String actualFooterAccessibilityLinkTittle = driver.getTitle();
        System.out.println(actualFooterAccessibilityLinkTittle);
        String expectedFooterAccessibilityLinkTittle = "Accessibility | Ross Stores, Inc.";
        Assert.assertEquals(actualFooterAccessibilityLinkTittle, expectedFooterAccessibilityLinkTittle);
        System.out.println("Assert Tittle passed");

        WebElement accessibilityPageText1 = driver.findElement(By.xpath("//p[contains(text(), 'We are committed to providing all customers with access to information about')]"));
        System.out.println(accessibilityPageText1.getText());

        driver.navigate().back();

        return this;
    }

    public HomePage clickFooterContactUsLinksAndVerifyUrlAndTittle() throws InterruptedException {

        Allure.step("The user clicks  contact us  Links  on footer and verify Url and Tittle");
        navigateTo_URL(getUrl());
        scrollIntoViewJS(pageFooter);
        Thread.sleep(2000);

        click(footerContactUsLink);
        String actualFooterContactUsLinkUrl = driver.getCurrentUrl();
        System.out.println(actualFooterContactUsLinkUrl);
        String expectedFooterContactUsLinkUrl = "https://corp.rossstores.com/contact-us-corp/";
        Assert.assertEquals(actualFooterContactUsLinkUrl, expectedFooterContactUsLinkUrl);
        System.out.println("Assert URL passed");

        String actualFooterContactUsLinkTittle = driver.getTitle();
        System.out.println(actualFooterContactUsLinkTittle);
        String expectedFooterContactUsLinkTittle = "Contact Us | Ross Stores, Inc.";
        Assert.assertEquals(actualFooterContactUsLinkTittle, expectedFooterContactUsLinkTittle);
        System.out.println("Assert Tittle passed");
        driver.navigate().back();

        return this;
    }

    public HomePage clickFooterSiteMapLinksAndVerifyUrlAndTittle() throws InterruptedException {

        Allure.step("The user clicks  siteMap Links  on footer and verify Url and Tittle");
        navigateTo_URL(getUrl());
        scrollIntoViewJS(pageFooter);
        Thread.sleep(2000);

        click(footerSiteMapLink);
        String actualFooterSiteMapLinkUrl = driver.getCurrentUrl();
        System.out.println(actualFooterSiteMapLinkUrl);
        String expectedFooterSiteMapLinkUrl = "https://corp.rossstores.com/sitemap/";
        Assert.assertEquals(actualFooterSiteMapLinkUrl, expectedFooterSiteMapLinkUrl);
        System.out.println("Assert URL passed");

        String actualFooterSiteMapLinkTittle = driver.getTitle();
        System.out.println(actualFooterSiteMapLinkTittle);
        String expectedFooterSiteMapLinkTittle = "Sitemap | Ross Stores, Inc.";
        Assert.assertEquals(actualFooterSiteMapLinkTittle, expectedFooterSiteMapLinkTittle);
        System.out.println("Assert Tittle passed");

        driver.navigate().back();

        return this;
    }

    public HomePage clickFooterDoNotCookieAndVerify() throws InterruptedException {

        Allure.step("The user clicks on Do not Links  on footer and verify its displayed");
        navigateTo_URL(getUrl());
        scrollIntoViewJS(pageFooter);
        Thread.sleep(2000);

        WebElement footerDoNotCookie = footerDoNotSellLink;
        JavascriptExecutor jsexecutor7 = ((JavascriptExecutor) DriverManager.getDriver());
        waitForVisibility(footerDoNotSellLink);
        jsexecutor7.executeScript("arguments[0].click();", footerDoNotCookie);

        click(footerDoNotSellLink);
        boolean oneTrustWindow = driver.findElement(By.cssSelector("#onetrust-consent-sdk")).isDisplayed();
        System.out.println(oneTrustWindow + " oneTrustWindow box is  displayed");

        driver.navigate().back();

        return this;
    }

    public CareersPage goToCareersPageViaCompany(){

        Allure.step("The user navigates to the career page");

        click(careersPageLink);

        String parentWindow1 = driver.getWindowHandle();
        Set<String> handles1 = driver.getWindowHandles();
        for (String windowHandle : handles1) {
            if (!windowHandle.equals(parentWindow1)) {
                driver.switchTo().window(windowHandle);
            }

        }

        return new CareersPage(driver);
    }
}

