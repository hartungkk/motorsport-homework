package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.mytests.uiobjects.example.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(id = "email")
    public TextField name;
    @FindBy(id = "password")
    public TextField password;

    @FindBy(id = "submitbutton")
    public Button login;

    @FindBy(id = "user_info_name")
    public Label userInfoText;

    @FindBy(id = "user_info_email")
    public Label userInfoEmailText;

    @FindBy(id = "continue_with_this_account")
    public Button continueButton;

}
