package ssau.esa.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "citizenships")
public class CitizenshipXml {

    @XmlElement
    List<Citizenship> citizenships = new ArrayList<>();

    public CitizenshipXml(){
    }

    public CitizenshipXml(List<Citizenship> citizenships) {
        this.citizenships = citizenships;
    }

    public void setCitizenships(List<Citizenship> citizenships) {
        this.citizenships = citizenships;
    }

}
