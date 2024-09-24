package rossCorpSite.tests;

import rossCorpSite.utils.RetryAnalyzer;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class CorpRoss extends BaseTest{

    @Severity(SeverityLevel.CRITICAL)
    @Step("Corp Ross")
    @Test(testName = "Corp Ross HomePage",retryAnalyzer = RetryAnalyzer.class)
    public void testCorpRoss() throws InterruptedException {
        homePage
                .closeCookie()
                //.verifyHomePageRossAltLinkText()
                .verifyHomePageTexts()
                .footerLinksList()
                .navMenuList()
                .verifySocialResponsibilityPage()
                .verifySocialResponsibilityPageNavMenuLinks()
                .clickFooterRossLinksAndVerifyUrlAndTittle()
                .clickFooterDDsLinksAndVerifyUrlAndTittle()
                .clickFooterPrivacyLinksAndVerifyUrlAndTittle()
                .clickFooterEqualEmployLinksAndVerifyUrlAndTittle()
                .clickFooterAccessibilityLinksAndVerifyUrlAndTittle()
                .clickFooterContactUsLinksAndVerifyUrlAndTittle()
                .clickFooterSiteMapLinksAndVerifyUrlAndTittle()
                .clickFooterDoNotCookieAndVerify()
                .goToCareersPageViaCompany();

        careersPage
                .clickFooterLinksAndVerifyUrlAndTittles()
                .goToInvestorPageViaCompany();

        investorPage
                .verifyInvestorPageUrlAndTittle();


    }
}
