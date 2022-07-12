package com.yzh.common.Service;

import com.yzh.common.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    int insertBook(Book book);

    int deleteBook(int id);


    int updateBook(Book book);

}
