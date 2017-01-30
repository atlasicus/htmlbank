package com.html.bank.user.message.model;

import com.html.bank.user.interfaces.message.model.Packet;

public class DataPacket implements Packet
{

    private String data;
    private String actionType;

    public DataPacket()
    {
        data = "";
    }

    @Override
    public void setData(String input)
    {
        data = input;
    }

    @Override
    public String getData()
    {
        return data;
    }

    /**
     *
     * @return returns the boolean value of if the numeric data store is an empty string or not
     *
     */

    @Override
    public boolean isEmpty()
    {
        return data.isEmpty();
    }

    /**
     *
     * Sets the associated ActionType to the data
     * I.E. is this data being withdrawn or deposited?
     *
     * @param type Normalized input: "withdraw", "deposit"
     */

    public void setActionType(String type) { actionType = type; }

    /**
     *
     * Gets the associated ActionType to the data
     * I.E. is this data being withdrawn or deposited?
     *
     * @return Normalized action string data: "withdraw", "deposit"
     */

    public String getActionType() { return actionType; }
}
