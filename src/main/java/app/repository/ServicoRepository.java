package app.repository;

import javax.transaction.Transactional;

import app.models.Servico;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ServicoRepository extends CrudRepository<Servico, Long> {

  public Servico findByDescricao(String descricao);
  public Servico findById(Long id);

} // class UserDao
