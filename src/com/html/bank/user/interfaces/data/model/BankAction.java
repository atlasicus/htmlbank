package com.html.bank.user.interfaces.data.model;

public interface BankAction
{
    /**
     *
     * Contract for submitting or requesting bank data from a source.
     *
     * @param  type kind of action that is being taken: e.g. "withdraw", "deposit", "balance", etc
     */

    void commit(String type);
}