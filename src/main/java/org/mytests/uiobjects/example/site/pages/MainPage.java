package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JSearch;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ByClass;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ById;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.XPath;
import com.epam.web.matcher.testng.Assert;
import org.mytests.uiobjects.example.site.enums.HeaderMenuItems;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@JPage(title = "Motorsport.com Россия: последние новости Формулы 1, Moto GP и других автогонок и мотогонок")
public class MainPage extends WebPage {
    @ByClass("ms-user-header_title")
    public Text textH1;
    @Css(".ms-main-menu>li>a")
    public Menu<HeaderMenuItems> headerMenu;
    @ByClass("ms-main-logo")
    public Image LogoMotorSport;
    @ByClass("ms-footer-message")
    public Element Footer;
    @ByClass("ms-footer-message-wrapper")
    public Text footerMessage;
    @ById("cookie_accept_button_close")
    public Link closeCookieFooterLink;
    @XPath("//*[@id=\"app_home_home-page\"]/div[1]/div[2]/div[3]")
    public Dropdown<HeaderMenuItems> loginDropdown;
    @JSearch(
            jSearchButton = @JFindBy(className = "ms-header-button"),
            jInput = @JFindBy(className = "ms-search-panel"))
    public Search mainSearch;
    public String parentWindowHandler = getDriver().getWindowHandle(); // Store your parent window
    public String subWindowHandler = null;

    public void checkHeader() {
        LogoMotorSport.waitDisplayed();
        loginDropdown.waitDisplayed();
        mainSearch.waitDisplayed();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("src\\main\\java\\org\\mytests\\uiobjects\\example\\site\\enums\\listHeader"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.areEquals(headerMenu.getValues().toString().trim(), lines.toString().trim());
    }

    public void switchToSubWindow() {

        Set<String> handles = getDriver().getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        getDriver().switchTo().window(subWindowHandler);
    }

    public void switchToParentWindow() {

        getDriver().switchTo().window(parentWindowHandler);

    }
}

