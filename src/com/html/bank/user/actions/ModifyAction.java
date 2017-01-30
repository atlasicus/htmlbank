package com.html.bank.user.actions;

import com.html.bank.user.exceptions.EmptyDataPacketException;
import com.html.bank.user.exceptions.InvalidFormatException;
import com.html.bank.user.exceptions.NullDataPacketException;
import com.html.bank.user.input.data.DataNormalizer;
import com.html.bank.user.input.data.DataParser;
import com.html.bank.user.input.data.DataValidator;
import com.html.bank.user.interfaces.data.model.BankAction;
import com.html.bank.user.interfaces.data.util.Validator;
import com.html.bank.user.message.model.DataPacket;
import com.html.bank.user.output.HTMLWriter;

import java.util.Scanner;

public class ModifyAction implements BankAction
{

    /**
     *
     * A BankAction for modifying a data source (in this case, a HTML table).
     *
     * @param  type kind of action that is being taken: e.g. "withdraw", "deposit", "balance", etc
     */

    @Override
    public void commit(String type)
    {
        String userData;

        DataPacket dataPacket = new DataPacket();
        DataParser dataParser = new DataParser();
        Validator dataValidator = new DataValidator();

        HTMLWriter writer = new HTMLWriter();

        while(dataPacket.isEmpty())
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter an amount to " + type + ": ");

            userData = scanner.nextLine();
            dataPacket = dataParser.parse(userData);

            try
            {
                dataValidator.validate(dataPacket);
            }
            catch(EmptyDataPacketException | InvalidFormatException | NullDataPacketException e)
            {
                System.out.println(e.getMessage());
                dataPacket = new DataPacket();
            }
        }

        dataPacket.setActionType(type);
        dataPacket = normalize(dataPacket);
        writer.execute(dataPacket);

        System.out.println("Transaction completed successfully");
    }

    private DataPacket normalize(DataPacket packet)
    {
        DataPacket normalizedPacket = new DataNormalizer().normalize(packet);

        if(normalizedPacket.getActionType().equals("withdraw"))
            normalizedPacket.setData("-" + normalizedPacket.getData());

        return normalizedPacket;
    }
}
