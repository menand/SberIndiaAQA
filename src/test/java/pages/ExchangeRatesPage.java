package pages;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class ExchangeRatesPage {
    public ExchangeRatesPage checkExchangeRatesCalculatorTest() {
        String strExchangeRate = $("div[class^='ExchangeCalculator_info']").getText();
        double exchangeRate =
                Double.parseDouble(strExchangeRate.split("=")[1].trim().split(" ")[0]);
        $("input[id='buy']").setValue("5000000");
        double result = 5_000_000 * exchangeRate;

        DecimalFormat formatter = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        formatter.setGroupingUsed(true);
        formatter.setMaximumFractionDigits(0);

        String formattedValue = formatter.format(result);
        $("input[id='sell']").shouldHave(value(formattedValue));

        return this;
    }
}
