package com.html.bank.user.interfaces.output;

import com.html.bank.user.interfaces.message.model.Packet;

public interface Writer
{


    void execute(Packet packet);
}
