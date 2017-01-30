package com.html.bank.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class HTMLReader
{
    /**
     *
     * Reads HTML from a file and returns it in string format.
     * Should be used as a relative location to working directory.
     *
     * @param  path location of a HTML file to read
     *
     * @return HTML data read from file stored as a string.
     */

    public static String GetFromFile(String path)
    {
        Path filePath = Paths.get(path);
        String markupStringFromFile;

        try
        {
            markupStringFromFile = Files.lines(filePath).collect(Collectors.joining());
        }
        catch (IOException e)
        {
            System.out.println("Invalid HTML file location, this should be located in root of the working directory");
            e.printStackTrace();
            markupStringFromFile = "";
        }

        return markupStringFromFile;
    }
}
