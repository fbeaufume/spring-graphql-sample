# Spring GraphQL Sample

This is a sample GraphQL backend based on Spring Boot.

Uses a simple library oriented domain model:

![Application domain model](doc/domain-model.png)

Uses an embedded in-memory H2 database.

Run with `mvn spring-boot:run`.

Useful URL:
- http://localhost:8080/h2-console/ the H2 web console
- http://localhost:8080/graphql/schema.json the GraphQL schema of the application
- http://localhost:8080/graphql?query=%7Bbooks%7Bid%20title%7D%7D a sample query
- http://localhost:8080/graphiql the GraphiQL client UI

Sample GraphiQL request:
```
{
  books {
    id
    title
  }
}
````


Not yet implemented:
- Add pagination support
- Add date support (see the Edition entity)
- Add mutations
- Add other queries
- Add unit tests
