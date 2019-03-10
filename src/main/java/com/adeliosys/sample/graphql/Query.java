package com.adeliosys.sample.graphql;

import com.adeliosys.sample.model.Book;
import com.adeliosys.sample.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // TOD FBE add pagination support
    /*public List<Book> getBooks(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size)).get().collect(Collectors.toList());
    }//*/
}
