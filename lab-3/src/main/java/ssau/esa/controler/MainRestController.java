package ssau.esa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ssau.esa.model.Citizenship;
import ssau.esa.model.CitizenshipXml;
import ssau.esa.model.Person;
import ssau.esa.model.PersonXml;
import ssau.esa.repo.CitizenshipRepo;
import ssau.esa.repo.PersonRepo;
import java.util.List;

@RestController
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class MainRestController {

    private final PersonRepo personRepo;
    private final CitizenshipRepo citizenshipRepo;

    @Autowired
    public MainRestController(PersonRepo personRepo, CitizenshipRepo citizenshipRepo) {
        this.personRepo = personRepo;
        this.citizenshipRepo = citizenshipRepo;
    }

    @GetMapping(value = "/personsJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> getAllPerson(){
        return this.personRepo.findAll();
    }

    @GetMapping(value = "/personsXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public PersonXml getAllPersonsXml(){
        return new PersonXml((List<Person>) this.personRepo.findAll());
    }

    @PostMapping(value = "/personsAdd")
    public String addPerson(@RequestBody @ModelAttribute("person") Person person){
        personRepo.save(person);
        return "person";
    }

    @GetMapping(value = "/citizenshipsJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Citizenship> getAllCitizenship(){
        return this.citizenshipRepo.findAll();
    }

    @GetMapping(value = "/citizenshipsXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public CitizenshipXml getAllCitizenshipXml(){
        return new CitizenshipXml((List<Citizenship>) this.citizenshipRepo.findAll());
    }

    @PostMapping(value = "/citizenshipsAdd")
    public String addCitizenship(@ModelAttribute("citizenship") Citizenship citizenship){
        citizenshipRepo.save(citizenship);
        return "redirect:/citizenship";
    }
}
