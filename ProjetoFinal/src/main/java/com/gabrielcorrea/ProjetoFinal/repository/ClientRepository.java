package com.gabrielcorrea.ProjetoFinal.repository;

import com.gabrielcorrea.ProjetoFinal.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

}
