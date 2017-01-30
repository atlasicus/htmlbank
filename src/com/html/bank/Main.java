package com.html.bank;

import com.html.bank.user.input.command.CommandNormalizer;
import com.html.bank.user.input.command.CommandParser;
import com.html.bank.user.input.command.CommandRouter;
import com.html.bank.user.interfaces.input.Normalizer;
import com.html.bank.user.interfaces.input.Parser;
import com.html.bank.user.interfaces.input.Router;
import com.html.bank.user.interfaces.message.model.Packet;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Router router = new CommandRouter();
        Normalizer normalizer = new CommandNormalizer();
        Parser commandParser = new CommandParser();

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Please enter in a command (Deposit, Withdraw, Balance, Exit) :");
            String input = scanner.nextLine();

            String normalizedInput = normalizer.normalize(input);
            Packet commandPacket = commandParser.parse(normalizedInput);
            router.route(commandPacket);
        }
    }
}
