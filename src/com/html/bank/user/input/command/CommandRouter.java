package com.html.bank.user.input.command;

import com.html.bank.user.actions.ModifyAction;
import com.html.bank.user.actions.BalanceAction;
import com.html.bank.user.interfaces.data.model.BankAction;
import com.html.bank.user.interfaces.message.model.Packet;
import com.html.bank.user.interfaces.input.Router;

public class CommandRouter implements Router
{
    /**
     *
     * Primary router for command input.  Accepts packets and expects normalized inputs
     *
     * @param  input Packet: a command packet, containing the command sent by the user
     */

    @Override
    public void route(Packet input)
    {
        BankAction action;

        switch (input.getData())
        {
            case "deposit":
            case "withdraw":
                action = new ModifyAction();
                action.commit(input.getData());
                break;
            case "balance":
                action = new BalanceAction();
                action.commit(input.getData());
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, please try again");
                break;
        }
    }
}
