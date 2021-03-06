package restful.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restful.dao.Person;
import restful.service.command.PersonCommandService;
import restful.service.exception.PersonNotFoundException;
import restful.service.query.PersonQueryService;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    private final PersonCommandService personCommandService;
    private final PersonQueryService personQueryService;

    @Autowired
    public PersonController(PersonCommandService personCommandService, PersonQueryService personQueryService) {
        this.personCommandService = personCommandService;
        this.personQueryService = personQueryService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable("id") Long id) {

        return personQueryService.findById(id);
    }

    @RequestMapping(path = "/getall", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Person> getAll() {

        return personQueryService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {

        personCommandService.create(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {

        try {
            personCommandService.update(person, id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (PersonNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {

        try {
            personCommandService.delete(id);
            return new ResponseEntity<>(HttpStatus.GONE);
        } catch (PersonNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
