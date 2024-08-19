
public class UsuarioService {

	
    public boolean validarLogin(Usuario usuario) {
        return usuario.getUsername() != null && !usuario.getUsername().isEmpty()
               && usuario.getUsername().equals(usuario.getPassword());
    }

}
