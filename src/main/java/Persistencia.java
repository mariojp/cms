import java.util.List;

public interface Persistencia<T> {

	void save(T entidade);

	void atualizar(T entidade);

	List<T> listar();

	boolean remover(int id);


}