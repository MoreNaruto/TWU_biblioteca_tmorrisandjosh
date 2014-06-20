package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/20/14.
 */
public class ReturnBookCommand implements Command {

    private Library library;
    private BufferedReader reader;

    public ReturnBookCommand(BufferedReader reader, Library library) {

        this.reader = reader;
        this.library = library;
    }

    @Override
    public void execute() {
        try {
            library.returnBook(this.reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
