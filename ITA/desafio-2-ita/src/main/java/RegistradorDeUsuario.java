import Entity.Usuario;
import exceptions.UsuarioComNomeVazioException;
import exceptions.UsuarioInexistenteException;
import exceptions.UsuarioJaRegistradoException;

import java.util.ArrayList;
import java.util.List;

public class RegistradorDeUsuario {
    public List<Usuario> _usuarios = new ArrayList<>();
    public void registrarUsuario(String nome)
            throws UsuarioComNomeVazioException, UsuarioInexistenteException, UsuarioJaRegistradoException {
        if(nome == null) throw new UsuarioInexistenteException("---> Não pode registrar usuario inexistente!");
        if(nome.isEmpty())  throw new UsuarioComNomeVazioException("---> Não pode registrar usuario com nome vazio!");
        Usuario usuario = new Usuario(nome);
        if(usuarioContains(usuario))  throw new UsuarioJaRegistradoException("---> Já existe ussuário com o nome \""
                + nome + "\"! Use outro nome!");
        _usuarios.add(usuario);
    }

    public boolean usuarioContains(Usuario usuario){
        for(Usuario user : _usuarios){
            if (user.getNome() == usuario.getNome()){
                return true;
            }
        }
        return false;
    }


    public boolean usuariosIsEmpty(){
        if (_usuarios.isEmpty()){
            return true;
        }
        return false;
    }
}
