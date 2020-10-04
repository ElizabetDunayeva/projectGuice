package ru.mail;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleLogger implements CheckLogger {
    @Inject
    private @NotNull Logger logger;

    private List<String> messages = new ArrayList<String>(0);

    @Override
    public void waitFor(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {

                String information = scanner.nextLine();
                messages.add(information);
                logger.info(messages.size()+" "+information);
            }
        } catch (IllegalStateException | NoSuchElementException e) {
        }

    }
}
