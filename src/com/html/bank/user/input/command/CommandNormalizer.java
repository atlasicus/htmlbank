package com.html.bank.user.input.command;

import com.html.bank.user.interfaces.input.Normalizer;

public class CommandNormalizer implements Normalizer
{
    /**
     *
     * Returns normalized input, for use in a parser, from a user via the command line.
     *
     * @param  input raw command line data
     */

    @Override
    public String normalize(String input)
    {
       return input.replaceAll("\\s","").toLowerCase();
    }
}
