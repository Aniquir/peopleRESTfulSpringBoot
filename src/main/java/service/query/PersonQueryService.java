package service.query;

import dao.Person;
import dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.exception.PersonNotFoundException;

import javax.transaction.Transactional;

@Service
public class PersonQueryService {

    private PersonRepository personRepository;

    @Autowired
    public PersonQueryService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        Person person = personRepository.findOne(id);

        if(person == null){
            throw new PersonNotFoundException();
        }
        return person;
    }
}
