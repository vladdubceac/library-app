package com.vladdubceac.spring_boot_library.controller;

import com.vladdubceac.spring_boot_library.entity.Book;
import com.vladdubceac.spring_boot_library.service.BookService;
import com.vladdubceac.spring_boot_library.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount(@RequestHeader(value="Authorization") String token){
        String userEmail = ExtractJWT.payloadJWTExtraction(token, ExtractJWT.EMAIL_EXTRACTION_KEY);
        return bookService.currentLoansCount(userEmail);
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(@RequestHeader(value="Authorization") String token, @RequestParam Long bookId){
        String userEmail = ExtractJWT.payloadJWTExtraction(token, ExtractJWT.EMAIL_EXTRACTION_KEY);
        return bookService.checkoutBookByUser(userEmail,bookId);
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestHeader(value="Authorization") String token, @RequestParam Long bookId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, ExtractJWT.EMAIL_EXTRACTION_KEY);
        return bookService.checkoutBook(userEmail,bookId);
    }
}
