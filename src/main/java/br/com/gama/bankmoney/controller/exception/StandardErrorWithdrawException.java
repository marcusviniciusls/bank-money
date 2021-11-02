package br.com.gama.bankmoney.controller.exception;

public class StandardErrorWithdrawException extends RuntimeException{

    public StandardErrorWithdrawException(String message) {
        super("Negative Value Not Supported " + message);
    }
}
