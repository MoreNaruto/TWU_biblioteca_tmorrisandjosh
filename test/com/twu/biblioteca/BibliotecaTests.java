package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class BibliotecaTests {
    private Library library;
    private Menu menu;
    private PrintStream mockStream;
    private BufferedReader reader;
    private List<Book> books;

    @Before
    public void setUp() {
        Map<String, Command> decoyMap = new HashMap<String, Command>();
        books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Bill", "1924", false));
        books.add(new Book("Game of Thrones", "J.R.R. Martin", "1992", false));
        mockStream = mock(PrintStream.class);
        library = new Library(mockStream, books);
        reader = mock(BufferedReader.class);
        menu = new Menu(decoyMap, mockStream, reader, books);

    }

    @Test
    public void testWelcomeMessage() {
        menu.displayWelcomeMessage();
        verify(mockStream).println("Welcome to Biblioteca!");
    }


    @Test
    public void testQuit() throws Exception {
        when(reader.readLine()).thenReturn("Quit");
        menu.startTakingCommands();

    }

    @Test
    public void testListBooks() throws IOException {
        library.listBooks();
        verify(mockStream).printf("%-20s %-20s %-20s\n", "Head First Java", "Bill", "1924");
    }

    @Test
    public void testMenuListBooks() throws IOException {
        when(reader.readLine()).thenReturn("List Books").thenReturn("Quit");

    }
    @Test
    public void testDisplayMenu(){
        menu.displayMenu();
        verify(mockStream).println("List Books");
    }

    @Test
    public void checkInvalidInput() throws IOException {
        when(reader.readLine()).thenReturn("Zoerir").thenReturn("Quit");
        menu.startTakingCommands();
        verify(mockStream).println("Select a valid option!");

    }

    @Test
    public void checkOutBook() throws IOException {
        String book = "Head First Java";
        library.checkoutBook(reader);
        when(reader.readLine()).thenReturn(book);
        library.listBooks();
        verify(mockStream).printf("%-20s %-20s %-20s\n", "Game of Thrones", "J.R.R. Martin", "1992");

    }

    @Test
    public void unsuccessfulCheckOutBook() throws IOException {
        String book = "Head First Java";
        when(reader.readLine()).thenReturn(book);
        library.checkoutBook(reader);
        verify(mockStream).println("Thank you! Enjoy ".concat(book));
        library.checkoutBook(reader);
        verify(mockStream).println("".concat(book).concat(" is not available"));

    }

    @Test
    public void returnBook() throws IOException {
        String book = "Game of Thrones";
        library.checkoutBook(reader);
        when(reader.readLine()).thenReturn(book);
        library.returnBook(reader);
        when(reader.readLine()).thenReturn(book);
        verify(mockStream).println("Thank you for returning: ".concat(book));

    }

}
