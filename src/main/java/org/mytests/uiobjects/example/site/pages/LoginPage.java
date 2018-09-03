package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.Popup;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ByClass;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ById;
import org.mytests.uiobjects.example.site.sections.LoginForm;

@JPage(url = "https://accounts.motorsportnetwork.com")
public class LoginPage extends Popup {
    public LoginForm loginForm;

    @ById("logo")
    public Image logoImage;

    @ById("restore_password")
    public Link restorePassword;

    @ByClass("remember-me")
    public CheckBox remeberMeCheckBox;

    @ById("submitbutton")
    public Button submitButton;
}
