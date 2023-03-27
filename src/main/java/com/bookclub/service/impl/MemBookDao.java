package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {
        this.books = new ArrayList<Book>();
        Book bookOne = new Book("9780134685991", "Effective Java", "Java book", 340, Arrays.asList("Joshua Bloch"));
        Book bookTwo = new Book("1943872872", "Murach's Java Programming", "Java Training", 400,
                Arrays.asList("Joel Murach"));
        ;
        Book bookThree = new Book("1493222953", "The Comprehensive Guide to Java Programming ", "Java Practise", 200,
                Arrays.asList("Christian Ullenboom"));
        ;
        Book bookFour = new Book("8377148494", "Java From Zero Professional Book", "Java From Zero", 240,
                Arrays.asList("Scott Brandt"));
        ;
        Book bookFive = new Book("8821535474", "Learn Java", "Java in one day", 150, Arrays.asList("Jamie Chan"));
        ;
        this.books.add(bookOne);
        this.books.add(bookTwo);
        this.books.add(bookThree);
        this.books.add(bookFour);
        this.books.add(bookFive);

    }

    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }

}
