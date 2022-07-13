package com.yzh.serviceprovider.service.Impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzh.common.Service.BookService;
import com.yzh.common.Service.UserService;
import com.yzh.common.entity.Book;
import com.yzh.serviceprovider.mapper.BookMapper;
import com.yzh.serviceprovider.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hui
 */

@Component
@SofaService(interfaceType = BookService.class, uniqueId = "bookService",
        bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Resource
    private BookMapper bookMapper;

    @DS("slave_1")
    @Override
    public List<Book> findAll() {
        return bookMapper.selectList(null);
    }

    @DS("master")
    @Override
    public int insertBook(Book book) {
        System.out.println(book);
        return bookMapper.insert(book);
    }

    @DS("master")
    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteById(id);
    }

    @DS("master")
    @Override
    public int updateBook(Book book) {
        UpdateWrapper<Book> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", book.getId());
        return bookMapper.update(book, updateWrapper);
    }


}
