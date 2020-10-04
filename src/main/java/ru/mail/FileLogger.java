package ru.mail;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger implements CheckLogger {
    @Inject
    private @NotNull
    Logger logger;

    private List<String> messages = new ArrayList<String>(0);

    @Override
    public void waitFor(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Your teg:");
            String teg = scanner.nextLine();
            String tegcomb = "<"+teg+">";
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {

                String information = scanner.nextLine();
                messages.add(information);
                FileHandler fh = new FileHandler("new_log.txt");
                SimpleFormatter sf = new SimpleFormatter();
                fh.setFormatter(sf);
                this.logger.addHandler(fh);
                logger.setUseParentHandlers(false);
                this.logger.log(Level.INFO,messages.size()+" "+tegcomb+information+tegcomb);

            }
        } catch (IllegalStateException | NoSuchElementException| IOException e) {
        }

    }
}
