package org.mytests.tests.example;

import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.enums.LoginDropDownItems;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import static org.mytests.uiobjects.example.site.RuMotorsportSite.loginPage;
import static org.mytests.uiobjects.example.site.RuMotorsportSite.mainPage;

public class SmokeTest extends SimpleTestsInit {

    @Test
    @Description("Тест о котором мы говорили с Павлом")
    public void SimpleLoginTest() {
        mainPage.open();

        mainPage.loginDropdown.waitDisplayed();
        mainPage.loginDropdown.click();
        mainPage.switchToSubWindow();

        loginPage.submitButton.waitDisplayed();
        loginPage.loginForm.loginAs(new User());

        loginPage.loginForm.userInfoEmailText.waitText("wukih@fidelium10.com");
        loginPage.loginForm.userInfoText.waitText("Konstantin Hartung");
        loginPage.loginForm.continueButton.click();

        loginPage.waitVanished();
        mainPage.switchToParentWindow();

        mainPage.loginDropdown.click();
        mainPage.loginDropdown.expand(String.valueOf(LoginDropDownItems.Panel));
        mainPage.textH1.waitText("hartung_is_cool_qa");


    }

    @Test
    @Description("Простейший кейс для теста хедера и футера")
    public void SimpleSmokeTest() {
        mainPage.open();
        mainPage.checkHeader();
        mainPage.Footer.waitDisplayed();
        mainPage.footerMessage.waitText("Мы используем cookies, чтобы сделать ваше пребывание у нас лучше.");
        mainPage.closeCookieFooterLink.click();
        mainPage.Footer.waitVanished();
    }
}
