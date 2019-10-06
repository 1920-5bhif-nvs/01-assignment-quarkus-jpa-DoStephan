package at.htl.firstproject.business;

import at.htl.firstproject.model.Person;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {
    @Inject
    EntityManager em;

    @Transactional
    public void init(@Observes StartupEvent ev){
        initPerson();
    }
    @Transactional
    private void initPerson() {
        Person[] people = {
                new Person("Gustav"),
                new Person("Richard"),
                new Person("Ida"),
        };

        for (Person person : people) {
            em.persist(person);
        }
    }
}
