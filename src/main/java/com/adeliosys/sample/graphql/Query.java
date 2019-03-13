package com.adeliosys.sample.graphql;

import com.adeliosys.sample.model.Author;
import com.adeliosys.sample.model.Book;
import com.adeliosys.sample.model.Editor;
import com.adeliosys.sample.repository.AuthorRepository;
import com.adeliosys.sample.repository.BookRepository;
import com.adeliosys.sample.repository.EditorRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private EditorRepository editorRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    // TODO FBE support pagination
    /*public List<Book> getBooks(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size)).get().collect(Collectors.toList());
    }//*/

    public List<Editor> getEditors() {
        return editorRepository.findAll();
    }
}
