package app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import app.models.OrdemServico;

@Transactional
public interface OrdemServicoRepository extends CrudRepository<OrdemServico, Long> {
		public OrdemServico findById(Long id);
}
