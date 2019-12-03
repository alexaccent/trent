package com.trento.country.examples.observer;

public class Main {
    public static void main(String[] args) {
        Observer observer = new Observer("one");
        Observer observer2 = new Observer("two");
        observer.setState("new state");
        observer.setState("Hello ren");
    }
}
