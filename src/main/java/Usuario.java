

/**
 * A classe Usuario é responsável por armazenar as informações de login do usuário e validar as credenciais.
 */
public class Usuario {
	
	
	private String username;
	private String password;


    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean validarLogin() {
        return username != null && !username.isEmpty() && username.equals(password);
    }

}