package com.example.lms_project.www.exception;

public class ServerBadRequestException extends RuntimeException{
    public ServerBadRequestException(String message){
        super(message);
    }
}
