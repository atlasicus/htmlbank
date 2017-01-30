package com.html.bank.user.input.data;

import com.html.bank.user.message.model.DataPacket;

public class DataNormalizer
{
    /**
     *
     * Normalizes the data of a DataPacket to be rendered as a monetary value.
     *
     * @param  packet sanitized DataPacket ready to be committed to storage (in this case a HTML document)
     *
     * @return A DataPacket normalized to represent a monetary value, and retaining ActionType data.
     */

    public DataPacket normalize(DataPacket packet)
    {
        DataPacket normalizedPacket = new DataPacket();

        String data = packet.getData();
        String[] splitData = data.split("\\.");

        if(splitData.length == 1)
            data = data + ".00";
        if(splitData.length == 2 && splitData[1].length() == 1)
        {
            data = data + "0";
        }

        if(data.startsWith("."))
            data = "0" + data;

        normalizedPacket.setData(data);
        normalizedPacket.setActionType(packet.getActionType());

        return normalizedPacket;
    }
}
