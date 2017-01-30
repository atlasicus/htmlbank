package com.html.bank.user.input.command;

import com.html.bank.user.interfaces.input.Parser;
import com.html.bank.user.interfaces.message.model.Packet;
import com.html.bank.user.message.model.DataPacket;

public class CommandParser implements Parser
{

    /**
     *
     * Returns a prepared packet from normalized user input for use in a router.
     *
     * @param  input normalized CommandNormalizer data
     */

    @Override
     public Packet parse(String input)
    {
         DataPacket packet = new DataPacket();
         packet.setData(input);

         return packet;
     }
}
