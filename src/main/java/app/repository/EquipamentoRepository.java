package app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import app.models.Equipamento;

@Transactional
public interface EquipamentoRepository extends CrudRepository<Equipamento, Long>{
		public Equipamento findById(Long id);
}
