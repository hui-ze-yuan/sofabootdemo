//package com.yzh.common;
//
//
//import com.yzh.common.entity.Book;
//import com.yzh.common.mapper.BookMapper;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@RestController
//public class TestController {
//
//
//    @Resource
//    BookMapper bookMapper;
//
//    @PostMapping("/addBook")
//    public Result<?> addBook(){
//        try {
//            Book book = new Book();
//            book.setName("hhh");
//            book.setPrice(20);
//            return Result.success(bookMapper.insert(book));
//        }catch (Exception e){
//            return Result.error("-1","插入出现错误");
//        }
//
//    }
//
//
//}
