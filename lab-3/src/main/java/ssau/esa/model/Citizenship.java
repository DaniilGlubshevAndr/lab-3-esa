package ssau.esa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement(name = "citizenship")
@Table(name = "CITIZENSHIP")
public class Citizenship {
    private long id;
    private String name;

    public Citizenship() { }

    @Id
    @Column(name = "id", nullable = false)
    @XmlElement
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 100)
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
