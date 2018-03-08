package app.Controller;

import dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.command.PersonCommandService;
import service.query.PersonQueryService;

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


}
