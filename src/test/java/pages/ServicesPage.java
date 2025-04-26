package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ServicesPage {
    public ServicesPage checkApplyButtonTest(String value) {
        $("button[data-testid='banner__consult']").shouldHave(text(value));
        return this;
    }
}
