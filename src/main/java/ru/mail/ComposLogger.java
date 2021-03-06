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

public class ComposLogger implements CheckLogger {
    @Inject
    private @NotNull
    Logger logger;
    @Inject
    private @NotNull
    Logger logger2;
    private List<String> messages = new ArrayList<String>(0);


    @Override
    public void waitFor(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {

                String information = scanner.nextLine();
                messages.add(information);
                this.logger2.info(messages.size()+" "+information);
                FileHandler fh = new FileHandler("new_log.txt");
                SimpleFormatter sf = new SimpleFormatter();
                fh.setFormatter(sf);
                this.logger.addHandler(fh);
                logger.setUseParentHandlers(false);
                this.logger.log(Level.INFO,(messages.size()+1)+" "+information);


            }
        } catch (IllegalStateException | NoSuchElementException | IOException e) {
        }

    }
}

