package com.alkemy.disneyapi.exception;

public class ParamNotFound extends RuntimeException{

    public ParamNotFound(String error) {
        super(error);
    }
}
