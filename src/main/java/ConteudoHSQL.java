import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConteudoHSQL implements Persistencia<Conteudo> {

	//memoria
    private static final String DB_URL = "jdbc:hsqldb:mem:conteudoDB";
    //arquivo
    //private static final String DB_URL = "jdbc:hsqldb:file:database/conteudoDB";
    //servidor
    //private static final String DB_URL = "jdbc:hsqldb:hsql://localhost/conteudoDB";
    //http server
    //private static final String DB_URL = "jdbc:hsqldb:http://localhost/conteudoDB";

    

    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private Connection connection = null;
    
    public ConteudoHSQL() {
    	criarTabela();
	}
    
    
    public Connection getConnection() throws SQLException {
    	if(connection==null) {
    		connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
    	}
    	return connection; 
    }
    
    
    

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS Conteudo (" +
                "id INTEGER IDENTITY PRIMARY KEY, " +
                "titulo VARCHAR(255), " +
                "texto VARCHAR(10000), " +
                "autor VARCHAR(255))";

        try {
        	Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Conteudo conteudo) {
        String sql = "INSERT INTO Conteudo (titulo, texto, autor) VALUES (?, ?, ?)";

        try {
        	Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, conteudo.getTitulo());
            stmt.setString(2, conteudo.getTexto());
            stmt.setString(3, conteudo.getAutor().getUsername()); 
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Conteudo> listar() {
        List<Conteudo> conteudos = new ArrayList<>();
        String sql = "SELECT * FROM Conteudo";

        try {
        	Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Conteudo conteudo = new Conteudo();
                conteudo.setId(rs.getInt("id"));
                conteudo.setTitulo(rs.getString("titulo"));
                conteudo.setTexto(rs.getString("texto"));
                Usuario autor = new Usuario();
                autor.setUsername(rs.getString("autor"));
                conteudo.setAutor(autor);
                conteudos.add(conteudo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conteudos;
    }

    public void atualizar(Conteudo conteudo) {
        String sql = "UPDATE Conteudo SET titulo = ?, texto = ?, autor = ? WHERE id = ?";

        try {
        	Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, conteudo.getTitulo());
            stmt.setString(2, conteudo.getTexto());
            stmt.setString(3, conteudo.getAutor().getUsername());
            stmt.setInt(4, conteudo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM Conteudo WHERE id = ?";
        boolean delete = false;
        try {
        	Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            delete = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }






	
}
