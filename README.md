# Spring GraphQL Sample

This is a sample GraphQL backend based on Spring Boot.

## Features

Uses a simple library oriented domain model:

![Application domain model](doc/domain-model.png)

GraphQL features:
- A single GraphQL schema in `src/main/resources/library.graphqls`
- Several basic queries on books, authors and editors
- A couple parameterized query on books, including pagination
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
  books(page:0, size:3) {
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

## Next steps

Not yet implemented:
- Support lazy relations
- Support enumeration
- Support date
- Add mutations
- Add unit tests
