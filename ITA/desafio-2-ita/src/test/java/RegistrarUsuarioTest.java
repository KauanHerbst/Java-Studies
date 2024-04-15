import exceptions.UsuarioComNomeVazioException;
import exceptions.UsuarioInexistenteException;
import exceptions.UsuarioJaRegistradoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrarUsuarioTest {

    RegistradorDeUsuario registradorDeUsuario;

    @BeforeEach
    public void before(){
        registradorDeUsuario = new RegistradorDeUsuario();
    }

    @Test
    public void registrarUsuarioComSucesso(){
        registradorDeUsuario.registrarUsuario("Kauan");
        Assertions.assertFalse(registradorDeUsuario.usuariosIsEmpty());
    }

    @Test
    public void registrarUsuarioExistente(){
        Assertions.assertThrows(UsuarioJaRegistradoException.class, () -> {
            registradorDeUsuario.registrarUsuario("Kauan");
            registradorDeUsuario.registrarUsuario("Kauan");
        });
    }

    @Test
    public void registarUsuarioComNomeVazio(){
        Assertions.assertThrows(UsuarioComNomeVazioException.class, () -> {
            registradorDeUsuario.registrarUsuario("");
        });
    }

    @Test
    public void registarUsuarioInexistente(){
        Assertions.assertThrows(UsuarioInexistenteException.class, () -> {
            registradorDeUsuario.registrarUsuario(null);
        });
    }
}
