# Quarkus - JPA

Ein einfaches Quarkus-JPA-Projekt, welches die Entität **Person** beinhaltet.

### Quarkus

```
./mvnw compile quarkus:dev:
./mvnw quarkus:add-extension -Dextensions="resteasy-jsonb"
```
https://quarkus.io/guides/hibernate-orm-guide

### Datenbank

Postgres (in Docker)

```
docker pull postgres
docker run -e POSTGRES_PASSWORD=passme -e POSTGRES_USER=user -e POSTGRES_DB=mydatabase -d -p 5432:5432 postgres
```

https://hackernoon.com/dont-install-postgres-docker-pull-postgres-bee20e200198
https://blog.codecentric.de/2019/06/restful-webservices-mit-quarkus/

## Bemerkung

**docker IP** statt **localhost** auf Windows
```
quarkus.datasource.url = jdbc:postgresql://192.168.99.100:5432/mydatabase
```

### REST
##### GET
curl -X GET http://localhost:8080/api/person
##### GET (id)
curl -X GET http://localhost:8080/api/person/2
##### POST
curl -X POST http://localhost:8080/api/person?name=Gustav
##### DELETE
curl -X DELETE  http://localhost:8080/api/person/2