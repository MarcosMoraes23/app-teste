package app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import app.models.Cliente;

@Transactional
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
		public Cliente findById(Long id);
		public Cliente findByCpfCnpj(String cpfCnpj);
}
