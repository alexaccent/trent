package com.trento.country.examples.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamsExample {
    public static void main(String[] args) {

        // Old
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        // short
        for (String string : list) {
            System.out.println(string);
        }
        // full
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // New
        // collection method example
        Set<String> test = list.stream()
               .filter(x -> {
                   return x.equals("two");
               }).collect(Collectors.toSet());

        // Map method example
        Stream testMap = list.stream().map(x -> Integer.parseInt(x));

        // flatMap method example
        Stream.of(asList("one", "two"), asList("one1", "two2") ).flatMap(x -> x.stream());

        // min() and max()
        int value1 = Stream.of(1, 2).max(Comparator.comparing(x -> x)).get();
        int value2 = Stream.of(1, 2).min(Comparator.comparing(x -> x)).get();

        // reduce()
        Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);

        // findAny
        Optional<Integer> test3 = Stream.of(1, 2, 3).filter(x -> x > 1).findAny();

    }
}
