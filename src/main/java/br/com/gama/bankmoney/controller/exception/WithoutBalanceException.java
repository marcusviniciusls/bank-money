package br.com.gama.bankmoney.controller.exception;

public class WithoutBalanceException extends RuntimeException{
    public WithoutBalanceException(String message) {
        super("Account without Sufficient Balance for Withdrawal" +message);
    }
}
