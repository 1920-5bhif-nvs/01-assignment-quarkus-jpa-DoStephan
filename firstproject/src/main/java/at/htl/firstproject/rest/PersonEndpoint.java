package at.htl.firstproject.rest;

import at.htl.firstproject.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("person")
public class PersonEndpoint {

    @Inject
    EntityManager em;

//curl -X GET http://localhost:8080/api/person
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        TypedQuery<Person> query = em.createNamedQuery("Person.getAll", Person.class);
        List<Person> people = query.getResultList();
        return Response.ok().entity(people).build();
    }

//curl -X GET http://localhost:8080/api/person/3
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long id){
        Person person = em.find(Person.class, id);
        return  Response.ok().entity(person).build();
    }

//curl -X POST http://localhost:8080/api/person?name=Nordpol
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response post(@QueryParam("name") String name){
        Person person = new Person(name);
        em.persist(person);
        return Response.ok().entity(person).build();
    }

//url -X DELETE http://localhost:8080/api/person/1
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        Person person = em.find(Person.class, id);
        em.remove(person);
        return Response.ok().entity(person).build();
    }
}