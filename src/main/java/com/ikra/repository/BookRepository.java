package com.ikra.repository;


import com.ikra.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository   extends PagingAndSortingRepository<Book, Long> {
    List<Book> findTop10ByOrderByRaitingCountDesc();
}
