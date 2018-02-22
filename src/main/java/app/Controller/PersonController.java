package app.Controller;

import dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.command.PersonCommandService;
import service.exception.PersonNotFoundException;
import service.query.PersonQueryService;

import java.util.List;

@RestController
public class PersonController {

    private final PersonCommandService personCommandService;
    private final PersonQueryService personQueryService;

    @Autowired
    public PersonController(PersonCommandService personCommandService, PersonQueryService personQueryService) {
        this.personCommandService = personCommandService;
        this.personQueryService = personQueryService;
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable("id") Long id){

            return personQueryService.findById(id);
    }

    @RequestMapping(path = "/getall", method = RequestMethod.GET)
    public @ResponseBody Iterable<Person> getAll(){

        return personQueryService.findAll();
    }

//    @RequestMapping(path = "/add", method = RequestMethod.POST)
//    public

}
