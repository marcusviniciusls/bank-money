package br.com.gama.bankmoney.exception;

import br.com.gama.bankmoney.controller.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest){
        String error = "Resource Not Found Exception";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, resourceNotFoundException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }

    @ExceptionHandler(BankWithoutMoneyException.class)
    public ResponseEntity<StandardError> moneyNotFound(BankWithoutMoneyException bankWithoutMoney, HttpServletRequest httpServletRequest){
        String error = "Money Not Found Exception";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, bankWithoutMoney.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }

    @ExceptionHandler(WithoutBalanceException.class)
    public ResponseEntity<StandardError> withouwBalance(WithoutBalanceException withoutBalanceException, HttpServletRequest httpServletRequest){
        String error = "Account without Sufficient Balance for Withdrawal";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, withoutBalanceException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }

    @ExceptionHandler(StandardErrorWithdrawException.class)
    public ResponseEntity<StandardError> withouwBalance(StandardErrorWithdraw standardErrorWithdraw, HttpServletRequest httpServletRequest){
        String error = "Negative Value Not Supported";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, standardErrorWithdraw.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }

    @ExceptionHandler(InsufficientAmountNotesException.class)
    public ResponseEntity<InsufficientAmountNotes> withouwBalance(InsufficientAmountNotes insufficientAmountNotes, HttpServletRequest httpServletRequest){
        String error = "Negative Value Not Supported";
        HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), error, insufficientAmountNotes.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(insufficientAmountNotes);
    }
}
