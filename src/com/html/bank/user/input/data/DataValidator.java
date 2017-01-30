package com.html.bank.user.input.data;

import com.html.bank.user.exceptions.EmptyDataPacketException;
import com.html.bank.user.exceptions.InvalidFormatException;
import com.html.bank.user.exceptions.NullDataPacketException;
import com.html.bank.user.interfaces.data.util.Validator;
import com.html.bank.user.interfaces.message.model.Packet;

public class DataValidator implements Validator
{

    /**
     *
     * A validator for ensuring data sanity.
     * Used specifically for validating DataPackets during the commit of a BankAction
     * Used to generate error messages for user feedback
     *
     * @param packet Packet, should at least contain number data as a string.
     *
     */

    @Override
    public void validate(Packet packet) throws EmptyDataPacketException, InvalidFormatException, NullDataPacketException
    {
        String data = packet.getData();
        int maxDigitsPastDecimal = 2;

        if(data == null)
            throw new NullDataPacketException("Validation failed: data packet null");

        if(data.isEmpty())
            throw new EmptyDataPacketException("Please enter a valid number: numeric values only");

        if(!data.matches("^\\.?[0-9]\\d*(\\.\\d+)?$"))
            throw new InvalidFormatException("Please enter a valid number: only enter a positive number with one or no decimal point");

        String[] decimalSplit = data.split("\\.");

        if(decimalSplit.length > 1 && decimalSplit[1].length() > maxDigitsPastDecimal)
            throw new InvalidFormatException("Please enter a valid number: Too many digits after decimal point");
    }
}
