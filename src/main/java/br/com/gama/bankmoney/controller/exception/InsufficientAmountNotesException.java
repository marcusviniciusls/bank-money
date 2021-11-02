package br.com.gama.bankmoney.controller.exception;

public class InsufficientAmountNotesException extends RuntimeException{
    public InsufficientAmountNotesException(String message) {
        super("Insufficient Amount of Notes" + message);
    }
}
