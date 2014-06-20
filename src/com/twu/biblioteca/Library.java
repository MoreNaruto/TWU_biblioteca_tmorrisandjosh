package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Library {

    private List<Book> books;
    private PrintStream out;


    public Library(PrintStream out, List<Book> books) {
        this.out = out;
        this.books = books;
    }

    public void checkoutBook(BufferedReader reader) throws IOException {
        String bookTitle = reader.readLine();
        Book book = findBook(bookTitle);

        if (book == null || book.checkout) {
            out.println("That book is not available");
        } else {
            book.checkout = true;
            out.println("Thank you! Enjoy ".concat(bookTitle));
        }

    }

    public void returnBook(BufferedReader reader) throws IOException {
        String bookTitle = reader.readLine();
        Book book = findBook(bookTitle);
        if(book == null || !book.checkout){
            out.println("That is not a valid book to return");
        } else {
            book.checkout = false;
            out.println("Thank you for returning: ".concat(bookTitle));
        }
    }

    private Book findBook(String title) {
        for (Book book: books) {
            if (book.getBook(title) != null) {
                return book;
            }
        }
        return null;
    }

    public void listBooks() {
        for(Book b : books) {
            if(b.checkout == false) {
                b.print(out);
            }
        }
    }

}
