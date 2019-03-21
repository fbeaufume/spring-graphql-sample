package com.adeliosys.sample;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * GraphQL Java supports unit tests, see
 * <a href="https://github.com/merapar/graphql-spring-boot-starter/blob/master/graphql-core/src/test/java/com/merapar/graphql/controller/GraphQlControllerTest.java">
 * https://github.com/merapar/graphql-spring-boot-starter/blob/master/graphql-core/src/test/java/com/merapar/graphql/controller/GraphQlControllerTest.java</a>
 * for example, but does not support server-side integration tests, e.g. based on MockMvc.
 * <p>
 * Instead client-side integration tests can be used, for example using TestRestTemplate or RestAssured.
 * <p>
 * If TestRestTemplate is preferred, know that a higher level abstraction is provided by GraphQL Java Kickstart,
 * see <a href="https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/46">
 * https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/46</a> and
 * <a href="https://github.com/graphql-java-kickstart/graphql-spring-boot/tree/master/example-graphql-tools">
 * https://github.com/graphql-java-kickstart/graphql-spring-boot/tree/master/example-graphql-tools</a>.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphQLApplicationTest {

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        RestAssured.port = port;
    }

    /**
     * Load the application schema generated by the GraphQL engine.
     */
    @Test
    public void getSchema() {
        given()//.log().all()
                .get("/graphql/schema.json")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.__schema.queryType.name", equalTo("Query"));
    }

    /**
     * Load the books using a GET request.
     */
    @Test
    public void getBooksByGet() {
        given()//.log().all()
                .queryParam("query", "{ books { id title } }")
                .get("/graphql")
                .then()
                .assertThat()
                .body("data.books.size()", equalTo(3))
                .body("data.books[0].title", equalTo("Carrie"));
    }

    /**
     * Load the books using a POST request and no explicit content-type (same as using text/plain or application/json).
     * It is also possible to send the "{ books { id title } }" body using the application/graphql content-type.
     */
    @Test
    public void getBooksByPost() {
        given()//.log().all()
                .body("{ \"query\": \"{ books { id title } }\" }")
                .post("/graphql")
                .then()
                .assertThat()
                .body("data.books.size()", equalTo(3))
                .body("data.books[0].title", equalTo("Carrie"));
    }

    /**
     * Create an author using a POST request and no explicit content-type.
     */
    @Test
    public void createAuthor() {
        given()//.log().all()
                .body("{ \"query\": \"mutation { createAuthor(firstName: \\\"John\\\", lastName: \\\"Doe\\\") { id } }\" }")
                .post("/graphql")
                .then()
                .assertThat()
                .body("data.createAuthor.id", equalTo("2003"));
    }
}
