package com.adeliosys.sample.graphql;

import com.adeliosys.sample.model.Author;
import com.adeliosys.sample.model.Book;
import com.adeliosys.sample.model.Editor;
import com.adeliosys.sample.model.Language;
import com.adeliosys.sample.repository.AuthorRepository;
import com.adeliosys.sample.repository.BookRepository;
import com.adeliosys.sample.repository.EditorRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unused")
@Component
public class Query implements GraphQLQueryResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Query.class);

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EditorRepository editorRepository;

    public List<Author> getAuthors() {
        LOGGER.info("Executing 'getAuthors'");
        return authorRepository.findAll();
    }

    public Page<Book> getBooks(int page, int size) {
        LOGGER.info("Executing 'getBooks'");
        // Returning a Page instead of a List is supported
        return bookRepository.findAll(PageRequest.of(page, size));
    }

    public List<Book> getBooksByLanguage(Language language) {
        LOGGER.info("Executing 'getBooksByLanguage'");
        return bookRepository.findByLanguage(language);
    }

    public List<Editor> getEditors() {
        LOGGER.info("Executing 'getEditors'");
        return editorRepository.findAll();
    }
}
