package com.ikra.service;


import com.ikra.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getTopTenBooksOrderedByRaitingCount();
}
