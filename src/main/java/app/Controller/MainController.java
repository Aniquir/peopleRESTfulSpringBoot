package app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.command.PersonCommandService;
import service.query.PersonQueryService;

@Controller
@RequestMapping(path = "people")
public class MainController {

    private final PersonCommandService peopleCommandService;
    private final PersonQueryService personQueryService;

    @Autowired
    public MainController(PersonCommandService personCommandService, PersonQueryService personQueryService) {
        this.peopleCommandService = personCommandService;
        this.personQueryService = personQueryService;
    }



}
