package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainSberIndiaPage {
    private final SelenideElement
            services = $("header a[href='/services']"),
            exchangeRates = $("header a[href='/exchange-rates']"),
            aboutSber = $x("//header//li[contains(text(), 'About Sber')]");

    public static MainSberIndiaPage openPage() {
        open("/");
        return new MainSberIndiaPage();
    }

    public void servicesClick() {
        this.services.click();
    }

    public void exchangeRatesClick() {
        this.exchangeRates.click();
    }

    public void trendsTest() {
        $x("//header//li[contains(text(), 'Trends')]").hover();
        $("ul[class^='Items_subItemsNews']")
                .$$("a").shouldHave(sizeGreaterThan(1));
    }

    public void aboutSberClick() {
        this.aboutSber.click();
    }

    public void footerTest() {
        executeJavaScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' })");
        $("div[data-testid='footer__bottom']").shouldHave(text("© 2025 Sberbank Branch in India"));
    }


}
