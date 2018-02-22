package service.command;

import dao.Person;
import dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.exception.PersonNotFoundException;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
public class PersonCommandService {

    private PersonRepository personRepository;

    @Autowired
    public PersonCommandService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Long create(Person person){
        personRepository.save(person);

        return person.getId();
    }

    public void update(Person person){
        Person dbPerson = personRepository.findOne(person.getId());

        if(dbPerson == null){
            throw new PersonNotFoundException();
        }
        dbPerson.setFirstName(person.getFirstName());
        dbPerson.setLastName(person.getLastName());
        dbPerson.setSex(person.getSex());
        dbPerson.setPhoneNumber(person.getPhoneNumber());
        dbPerson.setEmailAddress(person.getEmailAddress());
        dbPerson.setAddresses(person.getAddresses());
    }

    public void delete(Long id){
        Person person = personRepository.findOne(id);

        if (person == null){
            throw new PersonNotFoundException();
        }
        personRepository.delete(person);
    }
}
