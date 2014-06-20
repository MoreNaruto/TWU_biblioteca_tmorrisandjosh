package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Hashtable;

/**
 * Created by thomasmorris on 6/18/14.
 */
public class Menu {

    private boolean shouldQuit = false;
    private Hashtable<String, Command> methodMap;// = new Hashtable<String, Command>();
    private PrintStream out;
    private Library library;
    private BufferedReader reader;

    public Menu(Hashtable<String, Command> menuMap, PrintStream out, BufferedReader r){

        this.out = out;

        library = new Library(this.out);
        reader = r;
        this.methodMap = menuMap;
        methodMap.put("List Books", new ListBooksCommand(library, this.out));
        methodMap.put("Checkout Book", new CheckOutCommand(reader,library, this.out));
        methodMap.put("Return Book", new ReturnBookCommand(reader, library, this.out));


    }

    public void displayMenu() {
        for (String option : methodMap.keySet()) {
            out.println(option);
        }
    }

    public void startTakingCommands() throws IOException {
        String input;


        while (!shouldQuit()) {
            input = reader.readLine();
            if (input.equals("Quit")){
                shouldQuit = true;

            } else if (methodMap.containsKey(input)) {
                methodMap.get(input).execute();
            }
            else {
                out.println("Select a valid option!");
            }
        }
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to Biblioteca!");
    }

    public boolean shouldQuit(){
        return shouldQuit;
    }
}
