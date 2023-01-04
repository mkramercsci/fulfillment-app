package com.fulfillment.fulfillmentmanager.exception;

// throw a basic exception when any class object by id is not found
public class GenericNotFoundException extends RuntimeException{
    public GenericNotFoundException(String message) {
        super(message);
    }
}
