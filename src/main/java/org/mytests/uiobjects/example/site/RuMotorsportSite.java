package org.mytests.uiobjects.example.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.mytests.uiobjects.example.site.pages.LoginPage;
import org.mytests.uiobjects.example.site.pages.MainPage;


@JSite(value = "https://ru.motorsport.com/")
public class RuMotorsportSite extends WebSite {
    public static MainPage mainPage;
    public static LoginPage loginPage;
}
