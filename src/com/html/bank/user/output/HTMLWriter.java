package com.html.bank.user.output;

import com.html.bank.user.interfaces.message.model.Packet;
import com.html.bank.user.interfaces.output.Writer;
import com.html.bank.util.HTMLReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HTMLWriter implements Writer
{
    /**
     *
     * Appends the HTML table provided in the requirements with
     * The data from a packet containing a single numeric data number as a string
     *
     * Looks specifically for a table with a transactions id attribute
     * as well as that table containing a tbody tag.
     *
     * The DataPacket data is surrounded by td tags, then tr tags.
     *
     * @param  packet location of a HTML file to read
     *
     */

    @Override
    public void execute(Packet packet)
    {
        String htmlDocument = HTMLReader.GetFromFile("log.html");
        Document document = Jsoup.parse(htmlDocument);

        Element tableBody = document.select("table#transactions").first().select("tbody").last();

        tableBody.append("<tr><td>" + packet.getData() + "</td></tr>");

        write(document);
    }

    private void write(Document document)
    {
        Path filePath = Paths.get("log.html");

        try {
            Files.write(filePath, document.toString().getBytes());
        } catch (IOException e) {
            System.out.println("I/O Error: Unable to write to log.html");
            e.printStackTrace();
        }
    }
}
