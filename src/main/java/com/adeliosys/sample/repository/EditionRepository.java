package com.adeliosys.sample.repository;

import com.adeliosys.sample.model.Edition;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionRepository extends PagingAndSortingRepository<Edition, Long> {
}
