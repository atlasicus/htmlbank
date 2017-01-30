package com.html.bank.user.input.data;

import com.html.bank.user.interfaces.input.Parser;
import com.html.bank.user.message.model.DataPacket;

public class DataParser implements Parser
{
    /**
     *
     * Creates a Datapacket for use with a BankAction
     *
     * @param  input normalized user input, not sanitized yet
     *
     * @return packet 
     */

    @Override
    public DataPacket parse(String input)
    {
        DataPacket packet = new DataPacket();
        packet.setData(input);

        return packet;
    }
}
