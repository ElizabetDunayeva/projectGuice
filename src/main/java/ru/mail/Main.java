package ru.mail;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;



public class Main {
    private final @Nullable CheckLogger checklogger;



    @Inject
    public Main(@NotNull CheckLogger checkLogger) {
        this.checklogger = checkLogger;
    }

    public void waitForInput() {

        checklogger.waitFor();

    }
    public static void main(@NotNull String[] args) {

        final Injector injector = Guice.createInjector(new MainModule());
        injector.getInstance(Main.class).waitForInput();
    }

}

