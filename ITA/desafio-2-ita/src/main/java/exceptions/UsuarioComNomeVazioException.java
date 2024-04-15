package exceptions;

public class UsuarioComNomeVazioException extends RuntimeException {
    public UsuarioComNomeVazioException(String message){
        super(message);
    }
}
