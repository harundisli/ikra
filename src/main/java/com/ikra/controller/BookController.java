package com.ikra.controller;
import com.ikra.model.Book;
import com.ikra.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping(path = "/api/top-books")
    ResponseEntity<List<Book>> getTopBooks()
    {
        return ResponseEntity.ok(bookService.getTopTenBooksOrderedByRaitingCount());
    }

}
