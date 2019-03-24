package com.adeliosys.sample.graphql;

import com.adeliosys.sample.model.Author;
import com.adeliosys.sample.model.Language;
import com.adeliosys.sample.repository.AuthorRepository;
import com.adeliosys.sample.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class Mutation implements GraphQLMutationResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Mutation.class);

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Author createAuthor(String firstName, String lastName) {
        LOGGER.info("Executing 'createAuthor'");
        long id = authorRepository.getMaxId() + 1;
        return authorRepository.save(new Author(id, firstName, lastName));
    }

    public boolean updateBook(Long id, String title, Language language) {
        LOGGER.info("Executing 'updateBook'");
        return bookRepository.findById(id)
                .map(b -> {
                    b.setTitle(title);
                    b.setLanguage(language);
                    bookRepository.save(b);
                    return b;
                })
                .isPresent();
    }
}
