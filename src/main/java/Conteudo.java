import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A classe Conteudo gerencia a criação, atualização, listagem e exclusão dos conteúdos. 
 * Ela armazena todos os conteúdos em uma lista estática e atribui IDs únicos a cada conteúdo.
 */
public class Conteudo {

    private static List<Conteudo> conteudos = new ArrayList<Conteudo>();



	public static void setConteudos(List<Conteudo> conteudos) {
		Conteudo.conteudos = conteudos;
	}



	private static int count = 1;

    private int id;
    private String titulo;
    private String texto;
    private Usuario autor;
    
    
    
    
    
    public Conteudo(String titulo, String texto, Usuario autor) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
	}

    

    public int getId() {
		return this.id;
	}



	public void save() {
        id = count++;
        conteudos.add(this);
    }
    
	public void atualizar(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}
	
	
    public static List<Conteudo> listarConteudos() {
        return Collections.unmodifiableList(conteudos);
	}


	public static boolean remover(int id) {
		return conteudos.removeIf(conteudo -> conteudo.getId() == id);
	}
    
    
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conteudo [id=").append(id).append(", titulo=").append(titulo).append(", texto=").append(texto)
				.append(", autor=").append(autor.getUsername()).append("]");
		return builder.toString();
	}

    
}
