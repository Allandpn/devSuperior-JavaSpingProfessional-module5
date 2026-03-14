package com.devsuperior.dscommerce.servicies.exceptions;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String msg){
        super(msg);
    }
}
