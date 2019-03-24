package com.adeliosys.sample.repository;

import com.adeliosys.sample.model.Book;
import com.adeliosys.sample.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByLanguage(Language language);
}
