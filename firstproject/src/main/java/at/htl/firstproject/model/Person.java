package at.htl.firstproject.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Person.getAll", query = "select p from Person p")
})
@Table(name = "Person")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;

    public Person() {
    }

    public Person(String name) {
        Name = name;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
