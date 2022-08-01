package br.com.everton.Controllers;

import br.com.everton.model.Person;
import br.com.everton.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;
    private final AtomicLong counter = new AtomicLong(); // VAI GERAR UM ID.


    //Recupera dados da URL
    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) { //PathVariable passa o valor diretamente na URL
         return service.findById(id);

     }

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findById() { //PathVariable passa o valor diretamente na URL
        return service.findAll();

    }

    @RequestMapping(method= RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody  Person person) { //RequestBody passa o valor diretamente no corpo da aplicacao
        return service.create(person);

    }

    @RequestMapping(method= RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody  Person person) { //RequestBody passa o valor diretamente no corpo da aplicacao
        return service.update(person);

    }

    @RequestMapping(value= "/{id}",
           method = RequestMethod.DELETE)
    public void delete(@RequestBody  String id) { //RequestBody passa o valor diretamente no corpo da aplicacao
        service.delete(id);
    }
}
