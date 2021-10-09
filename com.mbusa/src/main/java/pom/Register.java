package pom;

import base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class Register extends BaseClass {

    public Register() {
        PageFactory.initElements(driver, this);
    }
}
