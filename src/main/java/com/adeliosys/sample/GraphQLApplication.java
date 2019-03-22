package com.adeliosys.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.servlet.Filter;

@SpringBootApplication
public class GraphQLApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLApplication.class, args);
    }

    /**
     * Wrap the HTTP request with a single entity manager (i.e. the session-per-request pattern)
     * to support lazy loading of JPA relations.
     * <p>
     * Note that an explicit filter is used instead of spring.jpa.open-in-view=true because that
     * parameter only works when the DispatcherServlet is involved and that's not the case with GraphQL Java.
     */
    @Bean
    public Filter OpenFilter() {
        return new OpenEntityManagerInViewFilter();
    }
}
