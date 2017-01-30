package com.html.bank.user.interfaces.message.model;

public interface Packet
{
    void setData(String input);
    String getData();
    boolean isEmpty();
}
