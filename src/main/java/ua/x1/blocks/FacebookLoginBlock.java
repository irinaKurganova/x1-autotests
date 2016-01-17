package ua.x1.blocks;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Facebook login block")
@FindBy(xpath = "//div[@id='loginform']")
public class FacebookLoginBlock extends HtmlElement {

    @Name("Email textField")
    @FindBy(xpath = ".//input[@id='email']")
    private TextInput emailTextfield;

    @Name("Password textfield")
    @FindBy(xpath = ".//input[@id='pass']")
    private TextInput passwordTextfield;

    public TextInput getEmailTextfield() {
        return emailTextfield;
    }

    public TextInput getPasswordTextfield() {
        return passwordTextfield;
    }

}
