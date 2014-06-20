package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by michaelhassin on 6/18/14.
 */
public class ListBooksCommand implements  Command{

    private Library library;

    public ListBooksCommand(Library library){
        this.library = library;

    }

    @Override
    public void execute() {
        library.listBooks();
    }
}
