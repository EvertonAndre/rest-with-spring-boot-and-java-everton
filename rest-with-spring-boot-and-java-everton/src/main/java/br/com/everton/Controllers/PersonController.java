package br.com.everton.Controllers;

import br.com.everton.model.Person;
import br.com.everton.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;
    private final AtomicLong counter = new AtomicLong(); // VAI GERAR UM ID.


    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
        public Person findById(@PathVariable(value = "id") Long id) { //PathVariable passa o valor diretamente na URL
         return service.findById(id);
     }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findById() { //PathVariable passa o valor diretamente na URL
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody  Person person) { //RequestBody passa o valor diretamente no corpo da aplicacao
        return service.create(person);

    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody  Person person) { //RequestBody passa o valor diretamente no corpo da aplicacao
        return service.update(person);

    }

    @DeleteMapping(value= "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) { //RequestBody passa o valor diretamente no corpo da aplicacao
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
