package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.AboutPage;
import pages.ExchangeRatesPage;
import pages.MainSberIndiaPage;
import pages.ServicesPage;

@Execution(ExecutionMode.CONCURRENT)
public class SberIndiaTests extends TestBase {

    private ExchangeRatesPage exchangeRatesPage = new ExchangeRatesPage();
    private ServicesPage servicesPage = new ServicesPage();
    private AboutPage aboutPage = new AboutPage();

    @Test
    @Tag("smoke")
    @DisplayName("Проверяем footer главной страницы")
    void mainPageFooterTest() {
        MainSberIndiaPage.openPage()
                .footerTest();
    }

    @Test
    @DisplayName("Открываем страницу Services и видим кнопку Apply Now")
    void servicesPageTest() {
        MainSberIndiaPage.openPage()
                .servicesClick();
        servicesPage.checkApplyButtonTest("Apply Now");
    }

    @Test
    @DisplayName("Открываем страницу Exchange Rates и проверяем калькулятор")
    void exchangeRatesTest() {
        MainSberIndiaPage.openPage()
                .exchangeRatesClick();
        exchangeRatesPage.checkExchangeRatesCalculatorTest();
    }

    @Test
    @DisplayName("Смотрим что если навести мышку на Trends то покажутся новости")
    void productsPageTest() {
        MainSberIndiaPage.openPage()
                .trendsTest();
    }

    @Test
    @DisplayName("Открываем страницу About Sber и проверяем заголовок")
    void aboutPageTest() {
        MainSberIndiaPage.openPage()
                .aboutSberClick();
        aboutPage.checkAboutPageTitleTest("Sberbank Branch in India | Your trusted partner for Indian-Russian business");
    }

}
