package app.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import app.models.Usuario;

@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	public Usuario findById(Long id);
}
