package br.com.everton.repositories;

import br.com.everton.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//interface repositoy permite o acesso ao banco de dados
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> { //JpaRepository prove um CRUD basico
}
