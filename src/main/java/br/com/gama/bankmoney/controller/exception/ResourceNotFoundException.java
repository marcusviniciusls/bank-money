package br.com.gama.bankmoney.controller.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found ID " + id);
    }
}

