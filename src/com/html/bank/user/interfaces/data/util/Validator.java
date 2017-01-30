package com.html.bank.user.interfaces.data.util;

import com.html.bank.user.exceptions.EmptyDataPacketException;
import com.html.bank.user.exceptions.InvalidFormatException;
import com.html.bank.user.exceptions.NullDataPacketException;
import com.html.bank.user.interfaces.message.model.Packet;

public interface Validator
{
    void validate(Packet packet) throws EmptyDataPacketException, InvalidFormatException, NullDataPacketException;
}
