package restful.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restful.dao.Person;
import restful.dao.PersonRepository;
import restful.service.exception.PersonNotFoundException;

@Service
public class PersonCommandService {

    private PersonRepository personRepository;

    @Autowired
    public PersonCommandService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void create(Person person) {
        personRepository.save(person);
    }

    public void update(Person person, Long id) {
        Person dbPerson = personRepository.findOne(id);

        if (dbPerson == null) {
            throw new PersonNotFoundException();
        } else {
            dbPerson.setFirstName(person.getFirstName());
            dbPerson.setLastName(person.getLastName());
            dbPerson.setSex(person.getSex());
            dbPerson.setPhoneNumber(person.getPhoneNumber());
            dbPerson.setEmailAddress(person.getEmailAddress());
            dbPerson.setCity(person.getCity());
            dbPerson.setCountry(person.getCountry());
        }
        personRepository.save(dbPerson);
    }

    public void delete(Long id) {
        Person person = personRepository.findOne(id);

        if (person == null) {
            throw new PersonNotFoundException();
        } else {
            personRepository.delete(person);
        }

    }
}
