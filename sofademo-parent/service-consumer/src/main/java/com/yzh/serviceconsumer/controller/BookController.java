package com.yzh.serviceconsumer.controller;


import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.yzh.common.Result;
import com.yzh.common.Service.BookService;
import com.yzh.common.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"),uniqueId = "bookService")
    private BookService bookService;

    @GetMapping("/findAll")
    public Result<?> findAllBooks(){
        return Result.success(bookService.findAll());
    }


    @PostMapping("/addBook")
    public Result<?> addBook(@RequestBody Book book){
        try {
            return Result.success(bookService.insertBook(book));
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("-1","插入出现错误");
        }

    }


    @PostMapping("/updateBook")
    public Result<?> updateBook(@RequestBody Book book){
        try {
            return Result.success(bookService.updateBook(book));
        }catch (Exception e){
            return Result.error("-1","更新出现错误");
        }
    }


    @GetMapping("/deleteBookById")
    public Result<?> deleteBookById(@RequestParam("id") int id){
        try {
            return Result.success(bookService.deleteBook(id));
        }catch (Exception e){
            return Result.error("-1","删除出现错误");
        }

    }


}
