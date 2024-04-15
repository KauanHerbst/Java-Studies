package br.herbst.project.services.exception;

public class DataBaseException extends RuntimeException{
    public DataBaseException(String message){
        super(message);
    }
}
