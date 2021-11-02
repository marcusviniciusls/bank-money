package br.com.gama.bankmoney.controller.exception;

public class BankWithoutMoneyException extends RuntimeException{

    public BankWithoutMoneyException(String message) {
        super("BANK WITHOUT MONEY " + message);
    }
}
