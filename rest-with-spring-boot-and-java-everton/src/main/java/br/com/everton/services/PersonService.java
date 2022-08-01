package br.com.everton.services;

import br.com.everton.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all people");
        List<Person> persons = new ArrayList<>();
        //criando mock
        for(int i=0; i<8; i++){
            Person person =mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){

        logger.info("Finding one person!");
        //Criando um mock para conseguir seguir no projeto enquanto nao temos esses dados
        Person person =new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlandia - MG - Brasil");
        person.setGender("Male");
        return person;

    }
    public Person update(Person person) {
        logger.info("updating one person!");
        return person;

    }

    public void delete(String id) {
        logger.info("deleting one person!");
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return person;

    }

    private Person mockPerson(int i) {
        Person person =new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in BrASIL " + i);
        person.setGender("Male");
        return person;


    }

}
