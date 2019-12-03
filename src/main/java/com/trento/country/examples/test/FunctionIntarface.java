package com.trento.country.examples.test;

import java.util.function.Predicate;

public class FunctionIntarface {
    public static void main(String[] args) {
        Predicate<String> predicate = x -> x == "hello";
        System.out.println(predicate.test("hello"));
    }
}
