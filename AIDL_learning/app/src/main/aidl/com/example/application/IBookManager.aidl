// IBookManager.aidl
package com.example.application;

// Declare any non-default types here with import statements

import com.example.application.Book;

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<Book> getBookList();
    void addBook(in Book book);
}
