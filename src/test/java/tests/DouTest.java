package tests;

import enums.Tabs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CompaniesPage;
import pages.MainPage;
import pages.SalariesPage;
import pages.WorkPage;

public class DouTest extends TestBase {


    @Test
    public void pmSalaryOnDecember2011() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("Киев")
                .setJobPosition("Project manager")
                .setPeriod("декабрь 2011")
                .shouldSeeSelectedCity("Киев")
                .shouldSeeSelectedJob("Project manager")
                .shouldSeeSelectedPeriod("декабрь 2011")
                .shouldSeeMaxSalary("3000");
    }

    @Test
    public void cloudBeesCompanyLinkRedirectsToProperWebSite() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new WorkPage(), Tabs.WORK)
                .navigateByClickingOnSubheaderTab(new CompaniesPage(), Tabs.COMPANIES)
                .searchCompany("CloudBees")
                .openCompanyPage("CloudBees")
                .clickOnCompanyWebsiteAndVerifyTitle("CloudBees | Enterprise Jenkins and DevOps");

    }

    @Test
    public void javaSeniorSoftwareEngineerMaxSalaryFor3yearsExperience(){
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("вся Украина")
                .setJobPosition("Software Engineer")
                .setProgrammingLanguage("Java")
                .setPeriod("июнь-июль 2019")
                .setSliderRange(-60,0)
                .shouldSeeSelectedCity("вся Украина")
                .shouldSeeSelectedJob("Software Engineer")
                .shouldSeeSelectedLanguage("Java")
                .shouldSeeSelectedPeriod("июнь-июль 2019")
                .shouldSeeMaxSalary("3000")
                .shouldSeeThatSliderIsSetCorrectly("left: 30%; width: 70%;");
    }

    @Test
    public void javaSeniorSoftwareEngineerAverageSalaryFor2_5yearsExperience(){
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("вся Украина")
                .setJobPosition("Software Engineer")
                .setProgrammingLanguage("Java")
                .setPeriod("июнь-июль 2019")
                .setSliderRange(100,0)
                .setSliderRange(20,0)
                .setSliderRange(-20,0)
                .shouldSeeSelectedCity("вся Украина")
                .shouldSeeSelectedJob("Software Engineer")
                .shouldSeeSelectedLanguage("Java")
                .shouldSeeSelectedPeriod("июнь-июль 2019")
                .shouldSeeMedianSalary("2200")
                .shouldSeeThatSliderIsSetCorrectly("left: 20%; width: 30%;");
    }

    @BeforeMethod(alwaysRun = true)
    public void before() {
        createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        removeDriver();
    }
}
