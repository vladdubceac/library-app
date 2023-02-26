package com.vladdubceac.springbootlibrary.dao;

import com.vladdubceac.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
