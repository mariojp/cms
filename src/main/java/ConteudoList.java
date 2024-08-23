import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConteudoList implements Persistencia<Conteudo> {

    private List<Conteudo> conteudos = new ArrayList<>();
    private int count = 1 ;
    
	@Override
	public void save(Conteudo conteudo) {
    	if(conteudo.getId() == null) {
    		conteudo.setId(count++);
    	}
        conteudos.add(conteudo);		
	}

	@Override
	public void atualizar(Conteudo entidade) {
        for (Conteudo conteudo : conteudos) {
            if (conteudo.getId() == entidade.getId()) {
                conteudo.setTitulo(entidade.getTitulo());
                conteudo.setTexto(entidade.getTexto());
                break;
            }
        }		
	}

	@Override
	public List<Conteudo> listar() {
        return Collections.unmodifiableList(conteudos);
	}

	@Override
	public boolean remover(int id) {
        return conteudos.removeIf(conteudo -> conteudo.getId() == id);
	}

}
