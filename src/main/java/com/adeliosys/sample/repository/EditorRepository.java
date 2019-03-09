package com.adeliosys.sample.repository;

import com.adeliosys.sample.model.Editor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends PagingAndSortingRepository<Editor, Long> {
}
