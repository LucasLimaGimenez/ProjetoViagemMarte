package br.com.fiap.gs1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.gs1.models.Viagem;

@Repository
@Transactional
public interface ViagemRepository extends CrudRepository<Viagem, Long> {

}
