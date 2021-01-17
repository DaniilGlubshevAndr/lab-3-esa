package ssau.esa.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "students")
public class PersonXml {

    @XmlElement
    List<Person> persons = new ArrayList<>();

    public PersonXml(){
    }

    public PersonXml(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

}
