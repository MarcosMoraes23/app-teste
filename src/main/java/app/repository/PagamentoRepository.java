package app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import app.models.Pagamento;

@Transactional
public interface PagamentoRepository extends CrudRepository<Pagamento, Long>{
	
	public Pagamento findById(Long id);

}
