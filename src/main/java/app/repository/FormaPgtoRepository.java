package app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import app.models.FormaPgto;

@Transactional
public interface FormaPgtoRepository extends CrudRepository<FormaPgto, Long>{
		public FormaPgto findById(Long id);
}
