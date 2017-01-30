package com.html.bank.user.interfaces.input;

public interface Normalizer
{
    /**
     *
     * Contract for how a normalizer should accept data
     *
     * @param  input a string containing raw data to normalize
     * @return a string normalized for use in a packet
     */
    String normalize(String input);
}
