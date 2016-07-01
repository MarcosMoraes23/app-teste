package app.repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import app.models.Modelo;

@Transactional
public interface ModeloRepository extends CrudRepository<Modelo, Long> {

	  public Modelo findByDescricao(String descricao);
	  public Modelo findById(Long id);

}
