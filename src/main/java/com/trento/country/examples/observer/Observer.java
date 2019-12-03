package com.trento.country.examples.observer;

import java.util.ArrayList;
import java.util.List;

public class Observer implements Observable {
    private String name;
    private String state;
    private static List<Observer> observers = new ArrayList<>();

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        updateAllObservers();
    }

    private void updateAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void update() {
        System.out.println(name + " Edit state: " + state);
    }
}
