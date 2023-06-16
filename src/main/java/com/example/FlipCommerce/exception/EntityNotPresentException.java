package com.example.FlipCommerce.exception;

public class EntityNotPresentException extends RuntimeException{
    public EntityNotPresentException(String msg){
        super(msg);
    }
}
