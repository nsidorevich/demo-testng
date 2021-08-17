package com.zebrunner;

public class Hooks {

    public static void waitForCompletion() {
        try {
            Thread.sleep(1000); // workaround for shutdown hooks issue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
