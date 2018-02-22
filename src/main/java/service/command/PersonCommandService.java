package service.command;

import dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonCommandService {

//    create,read,update,delete
    private PersonRepository personRepository;

    @Autowired
    public PersonCommandService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


}
