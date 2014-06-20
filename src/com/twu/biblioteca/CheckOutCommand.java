package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/20/14.
 */
public class CheckOutCommand implements Command {

    private Library library;
    private BufferedReader reader;

    public CheckOutCommand(BufferedReader reader
            , Library library){
        this.library = library;
        this.reader = reader;
;    }

    @Override
    public void execute() {

        try {
            library.checkoutBook(this.reader);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Invalid input");
        }
    }
}
