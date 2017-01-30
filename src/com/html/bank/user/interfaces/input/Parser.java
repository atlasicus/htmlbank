package com.html.bank.user.interfaces.input;

import com.html.bank.user.interfaces.message.model.Packet;

public interface Parser
{
    /**
     *
     * Contract for generating a packet from raw data for use in a router
     *
     * @param  input :  normalized input data
     * @return a standard packet prepared from input data
     */

    Packet parse(String input);
}
