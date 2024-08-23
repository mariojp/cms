
public class UsuarioService {

	
    public Usuario validarLogin(String username, String password) {
        Usuario usuario = null;
        if(username != null && !username.isEmpty()
               && username.equals(password)){
            usuario =  new Usuario(username,password);
        }
        return usuario;
    }

}
