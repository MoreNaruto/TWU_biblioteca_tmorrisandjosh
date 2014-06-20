package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/20/14.
 */
public class ReturnBookCommand implements Command {

    private Library library;
    private PrintStream out;
    private BufferedReader reader;

    public ReturnBookCommand(BufferedReader reader, Library library, PrintStream out) {

        this.reader = reader;
        this.library = library;
        this.out = out;
    }

    @Override
    public void execute() {

    }
}
