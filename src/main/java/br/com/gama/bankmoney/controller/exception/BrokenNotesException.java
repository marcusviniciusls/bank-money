package br.com.gama.bankmoney.controller.exception;

public class BrokenNotesException extends RuntimeException{

    public BrokenNotesException(String message) {
        super("Withdrawal Unavailable Broken Amounts " + message);
    }
}
