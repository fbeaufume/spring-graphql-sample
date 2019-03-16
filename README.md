# Spring GraphQL Sample

This is a sample GraphQL backend based on Spring Boot, GraphQL Java (the core GraphQL library
in Java) and GraphQL Java Kickstart (provides Spring Boot integration of GraphQL Java).

For GraphQL see https://graphql.org/.

For GraphQL Java see https://www.graphql-java.com/ and https://github.com/graphql-java/graphql-java.

For GraphQL Java Kickstart see https://www.graphql-java-kickstart.com/ and
https://github.com/graphql-java-kickstart/graphql-spring-boot.

## Features

Uses a simple library oriented domain model:

![Application domain model](doc/domain-model.png)

GraphQL features:
- A single GraphQL schema in `src/main/resources/library.graphqls`
- Several basic queries on books, authors and editors
- A couple parameterized query on books, including pagination
- Dates support
- The application embeds GraphiQL, a GraphQL client UI, for easy querying

No external database is requires as the application uses an embedded in-memory H2 database.

The business data are in `src/main/resources/data.sql`.

## Usage

As usual run with `mvn spring-boot:run` (or `mvn package` then
`java -jar target/spring-graphql-sample.jar`).

Useful URL:
- http://localhost:8080/ homepage of the application, contains the next links
- http://localhost:8080/graphql/schema.json the GraphQL schema of the application
- http://localhost:8080/graphql?query=%7Bbooks%7Bid%20title%7D%7D a sample GraphQL query
- http://localhost:8080/graphiql the GraphiQL client UI
- http://localhost:8080/h2-console/ the H2 web console

Sample GraphQL queries:
```
{
  authors {
    id
    firstName
    lastName
  }
}
```

```
{
  booksByPage(page:0, size:3) {
    id
    title
    isbn
  }
}
```

```
{
  booksByLanguage(language:"FR") {
    id
    title
    isbn
  }
}
```

## Issues

Summary of issues met during development:
- Dates are not directly supported by GraphQL, some coding or third party lib is required
- LazyInitializationException when loading a lazy JPA relations, even when in session-per-request
- Upgrading from GraphQL Java Kickstart 5.0.2 to 5.7.0 was more complex than expected
  (different groupId, errors at application startup, GraphQL Java Tools not explicitly needed anymore)

## Next steps

Not yet implemented:
- Support lazy relations
- Support enumeration
- Add mutations
- Add unit tests
