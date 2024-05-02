package com.crypto.portfolio.subscriber;

import com.crypto.portfolio.model.Portfolio;
import com.crypto.portfolio.model.PortfolioElement;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.crypto.portfolio.constants.UtilityConstant.STRING_PADDING;

@Component
public class ConsoleSubscriber {

    @JmsListener(destination = "portfolio")
    public void onMessage(Portfolio portfolio) {
        consolePrettyPrint(portfolio);
    }

    private static void consolePrettyPrint(Portfolio portfolio) {
        System.out.println("_________________________________________________________________________________________________________________________________________________"+System.lineSeparator());
        System.out.println("    TIME                "+ ZonedDateTime.now() + System.lineSeparator());
        String headerLine = "    Positions           "+String.format(STRING_PADDING,"Symbol" )+ "        "+String.format(STRING_PADDING,"Price")+"       "+String.format(STRING_PADDING,"Quantity")+"        "+String.format(STRING_PADDING,"Value") + System.lineSeparator();
        System.out.println(headerLine);

        for (PortfolioElement pe : portfolio.getStockElements().values()){
            System.out.println("                        "+pe.toString());
        }

        for (PortfolioElement pe : portfolio.getOptionsElements().values().stream().flatMap(Collection::stream).collect(Collectors.toSet())){
            System.out.println("                        "+pe.toString());
        }
        System.out.println(System.lineSeparator()+"    Net Asset Value     "+ portfolio.getNav());
        System.out.println("_________________________________________________________________________________________________________________________________________________"+System.lineSeparator());
    }
}
