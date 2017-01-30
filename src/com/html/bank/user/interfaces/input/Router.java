package com.html.bank.user.interfaces.input;

import com.html.bank.user.interfaces.message.model.Packet;

public interface Router
{
    /**
     *
     * Contract for how a router should accept data
     *
     * @param  packet Packet:  packet, containing the command sent from input of any kind
     */

    void route(Packet packet);
}
