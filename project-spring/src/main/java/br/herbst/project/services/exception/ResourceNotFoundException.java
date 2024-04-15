package br.herbst.project.services.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id) {
        super("Resource not Found id: " + id);
    }
}
