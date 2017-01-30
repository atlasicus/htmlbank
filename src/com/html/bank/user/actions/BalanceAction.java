package com.html.bank.user.actions;

import com.html.bank.user.interfaces.data.model.BankAction;
import com.html.bank.util.HTMLReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;

public class BalanceAction implements BankAction
{

    /**
     *
     * A BankAction for querying a data source (in this case, a HTML table).
     *
     * @param type kind of action that is being taken: e.g. "withdraw", "deposit", "balance", etc
     */

    @Override
    public void commit(String type)
    {
        String htmlString = HTMLReader.GetFromFile("log.html");

        Document document = Jsoup.parse(htmlString);

        Elements transactionList = document.select("table#transactions").first().select("tbody").last().children();
        double transactionBalance = 0.00;

        for (Element element: transactionList)
        {
            String text = element.select("td").text();
            transactionBalance += Double.valueOf(text);
        }

        DecimalFormat format = new DecimalFormat("#.00");

        System.out.println("The current balance is: $" + format.format(transactionBalance));
    }
}
