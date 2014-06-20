package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException {
        Map<String, Command> commands = new HashMap<String, Command>();
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Bill", "1924", false));
        books.add(new Book("Game of Thrones", "J.R.R. Martin", "1992", false));

        Menu menu = new Menu(commands, System.out, new BufferedReader(new InputStreamReader(System.in)), books);

        menu.displayMenu();
        menu.startTakingCommands();

    }
}
