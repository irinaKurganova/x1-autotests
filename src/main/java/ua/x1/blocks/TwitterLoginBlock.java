package ua.x1.blocks;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Twitter login block")
@FindBy(xpath = "//div[@id='bd']")
public class TwitterLoginBlock extends HtmlElement {

    @Name("Email textField")
    @FindBy(xpath = ".//input[@id='username_or_email']")
    private TextInput emailTextfield;

    @Name("Password textfield")
    @FindBy(xpath = ".//input[@id='password']")
    private TextInput passwordTextfield;

    @Name("Login button")
    @FindBy(xpath = ".//input[@name='commit']")
    private Button loginButton;

    public TextInput getEmailTextfield() {
        return emailTextfield;
    }

    public TextInput getPasswordTextfield() {
        return passwordTextfield;
    }

    public Button getLoginButton() {
        return loginButton;
   }

}
