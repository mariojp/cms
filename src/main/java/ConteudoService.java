
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConteudoService {
	

    private List<Conteudo> conteudos = new ArrayList<>();
    private int count = 1 ;

    public void save(Conteudo conteudo) {
    	if(conteudo.getId() == null) {
    		conteudo.setId(count++);
    	}
        conteudos.add(conteudo);
    }

    public void atualizarConteudo(int id, String titulo, String texto) {
        for (Conteudo conteudo : conteudos) {
            if (conteudo.getId() == id) {
                conteudo.setTitulo(titulo);
                conteudo.setTexto(texto);
                break;
            }
        }
    }

    public List<Conteudo> listarConteudos() {
        return Collections.unmodifiableList(conteudos);
    }

    public boolean removerConteudo(int id) {
        return conteudos.removeIf(conteudo -> conteudo.getId() == id);
    }

    public Conteudo buscarPorId(int id) {
        return conteudos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}
