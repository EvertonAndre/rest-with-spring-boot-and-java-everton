package br.com.everton.services;

import br.com.everton.data.vo.v1.PersonVO;
import br.com.everton.exceptions.ResourceNotFoundException;
import br.com.everton.mapper.DozerMapper;
import br.com.everton.model.Person;
import br.com.everton.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {


    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll(){
        logger.info("Finding all people");

        return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){

        logger.info("Finding one person!");

        var entity =repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        logger.info("updating one person!");

      var entity = repository.findById(person.getId())
              .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo= DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;

    }

    public void delete(Long id) {
        logger.info("deleting one person!");

//antes de deletar preciso recupera a entidade a ser deletada
        var entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo= DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }



}
