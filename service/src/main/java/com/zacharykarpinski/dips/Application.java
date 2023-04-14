package com.zacharykarpinski.dips;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    
    // Snakeyaml exploit will call this otherwise unreachable class which writes to console.
    public Application(String message) {
        System.out.println(message);
    }

}
