package ru.mail;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class MainModule extends AbstractModule{

    @NotNull
    public  int id;
    @Override
    protected void configure() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Console 2-File 3-Console+File");
        this.id = scanner.nextInt();
        if(id==1){
            bind(CheckLogger.class).to(ConsoleLogger.class);
        }
        if(id==2) {
            bind(CheckLogger.class).to(FileLogger.class);
        }
        if(id==3){
            bind(CheckLogger.class).to(ComposLogger.class);
        }





    }
}
