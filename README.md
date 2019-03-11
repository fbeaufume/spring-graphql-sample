# Spring GraphQL Sample

This is a sample GraphQL backend based on Spring Boot.

## Features

Uses a simple library oriented domain model:

![Application domain model](doc/domain-model.png)

The application embeds GraphiQL a GraphQL client UI, for easy querying.

No external database is requires as the application uses an embedded in-memory H2 database.

## Usage

As usual run with `mvn spring-boot:run` (or `mvn package` then
`java -jar target/spring-graphql-sample.jar`).

Useful URL:
- http://localhost:8080/h2-console/ the H2 web console
- http://localhost:8080/graphql/schema.json the GraphQL schema of the application
- http://localhost:8080/graphql?query=%7Bbooks%7Bid%20title%7D%7D a sample query
- http://localhost:8080/graphiql the GraphiQL client UI

Sample GraphQL request:
```
{
  books {
    id
    title
  }
}
````

## Next steps

Not yet implemented:
- Support lazy relations
- Support pagination
- Support date (see the Edition entity)
- Add mutations
- Add other queries
- Add unit tests
