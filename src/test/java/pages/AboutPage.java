package pages;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutPage {
    public AboutPage checkAboutPageTitleTest(String strValue) {
        assertEquals(strValue, title());
        return this;
    }
}
