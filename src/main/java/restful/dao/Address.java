package restful.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable{

    private static final long serialVersionUID = 1281431330203638300L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String street;
    private String buildingNumber;
    private String flatNumber;

    @OneToOne(mappedBy = "addresses")
    private Person person;

    public Address() {
    }

    public Address(String city, String street, String buildingNumber, String flatNumber, Person person) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", person=" + person +
                '}';
    }
}
