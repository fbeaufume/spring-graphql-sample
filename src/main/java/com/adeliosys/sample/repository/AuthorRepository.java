package com.adeliosys.sample.repository;

import com.adeliosys.sample.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT MAX(a.id) FROM Author a")
    int getMaxId();
}
