package com.adeliosys.sample.graphql;

import com.adeliosys.sample.model.Author;
import com.adeliosys.sample.model.Book;
import com.adeliosys.sample.model.Editor;
import com.adeliosys.sample.repository.AuthorRepository;
import com.adeliosys.sample.repository.BookRepository;
import com.adeliosys.sample.repository.EditorRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<Book> getBooks(int page, int size) {
        // Returning a Page instead of a List is supported
        return bookRepository.findAll(PageRequest.of(page, size));
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Editor> getEditors() {
        return editorRepository.findAll();
    }
}
