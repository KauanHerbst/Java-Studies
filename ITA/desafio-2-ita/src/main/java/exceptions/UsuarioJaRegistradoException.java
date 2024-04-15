package exceptions;

public class UsuarioJaRegistradoException extends RuntimeException {
    public UsuarioJaRegistradoException(String message){
        super(message);
    }
}
