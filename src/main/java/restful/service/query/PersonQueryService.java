package restful.service.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restful.dao.Person;
import restful.dao.PersonRepository;
import restful.service.exception.PersonNotFoundException;

@Service
public class PersonQueryService {

    private PersonRepository personRepository;

    @Autowired
    public PersonQueryService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> findAll(){
        return personRepository.findAllWithAddresses();
    }

    public Person findById(Long id){
        Person person = personRepository.findOneWithAddresses(id);

        if(person == null){
            throw new PersonNotFoundException();
        }
        return person;
    }
}
