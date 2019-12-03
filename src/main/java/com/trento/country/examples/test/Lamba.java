package com.trento.country.examples.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lamba {
    public static void main(String[] args) {

        // Old
        Runnable runnableOld = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnableOld");
            }
        };

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("actionListenerOld");
            }
        };

        // New
        Runnable runnable = () -> {
            System.out.println("runnable");
        };
        Runnable runnable1 = () -> {
            System.out.println("runnable1");
        };
        Runnable runnable2 = () -> {
            System.out.println("runnable2");
        };
        final String tile = "tile";
        ActionListener actionListenerNew = (ActionEvent event) -> {
            System.out.println("Event" + tile);
        };
    }
}
