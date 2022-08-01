package br.com.everton.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity //Diz para o hibernate que essa classe representa uma tabela do banco
@Table(name = "person") //Diz para o banco qual é o nome da tabela no banco
public class Person implements Serializable {

    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
                                    // nullable = false significa que o nome nao pode ser nulo
    @Column(name = "first_name", nullable = false , length = 80) // indica o nome da tabela no banco
    private String firstName;

    @Column(name = "last_name", nullable = false , length = 80)
    private String lastName;

    @Column(nullable = false , length = 100) // o nome da coluna no banco vai ser igual ao do objeto java (address), logo nao preciso especificar
    private String address;

    @Column(nullable = false , length = 6)
    private String gender;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                address.equals(person.address) &&
                gender.equals(person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
