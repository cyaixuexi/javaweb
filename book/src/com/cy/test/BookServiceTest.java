package com.cy.test;

import com.cy.pojo.Book;
import com.cy.pojo.Page;
import com.cy.service.BookService;
import com.cy.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
   private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"有你在手，天下我有","520",new BigDecimal(200),100000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(42);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(42,"社会你哥，人狠话不多","520",new BigDecimal(200),100000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(42));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}