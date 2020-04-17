package com.ikra.service;

import com.ikra.model.Book;
import com.ikra.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> getTopTenBooksOrderedByRaitingCount() {
        return bookRepository.findTop10ByOrderByRaitingCountDesc();
    }
}
