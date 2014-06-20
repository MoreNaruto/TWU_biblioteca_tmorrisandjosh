package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Library {

    private ArrayList<Book> books = new ArrayList<Book>();
    private PrintStream out;


    public Library(PrintStream out) {
        this.out = out;
        books.add(new Book("Head First Java", "Bill", "1924", false));
        books.add(new Book("Game of Thrones", "J.R.R. Martin", "1992", false));


    }

    public void checkoutBook(BufferedReader reader) throws IOException {
        String bookTitle = reader.readLine();
        for (Book book: books){
            if(book.getBook(bookTitle) != null){
                if (book.checkout) {
                    out.println("".concat(bookTitle).concat(" is not available"));
                } else {
                    book.checkout = true;
                    out.println("Thank you! Enjoy ".concat(bookTitle));
                }
            }
        }
    }

    public void returnBook(BufferedReader reader) throws IOException {
        String bookTitle = reader.readLine();
        for (Book book: books){
            if(book.getBook(bookTitle) != null){
                book.checkout = false;
                out.println("Thank you for returning: ".concat(bookTitle));
            }
        }
    }
    public void listBooks() {
        for(Book b : books) {
            if(b.checkout == false) {

                b.print(out);
            }
        }
    }

}
