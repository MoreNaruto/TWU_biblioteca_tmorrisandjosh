package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Book {
    String author;
    String year;
    String title;
    boolean checkout;

    public Book(String t, String a, String y, boolean checkout) {
        author = a;
        year = y;
        title = t;
        this.checkout = checkout;
    }

    public String toString() {
        return (title + "\t" + author + "\t" + year);
    }

    public void print(PrintStream out) {
        out.printf("%-20s %-20s %-20s\n", title, author, year);
    }

    @Override
    public boolean equals(Object _book) {
        Book book = (Book) _book;

        return author.equals(book.getAuthor()) && title.equals(book.getTitle()) && year.equals(book.getYear());


    }

    public Book getBook(String title){
        if (this.title.equals(title)){
            return this;
        }
        return null;
    }

    public String getTitle(){
        return title;
    }

    public String getYear(){
        return year;
    }

    public String getAuthor() {
        return author;
    }
}

