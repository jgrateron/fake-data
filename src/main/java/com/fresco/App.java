package com.fresco;

import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import net.datafaker.Faker;


public class App {

    public static void main(String[] args) {
        var f = new Faker(new Locale("ES"));

        Stream.iterate(1, n -> n <= 10, n -> n + 1)
                .map(i -> String.format("%02d %30s %20s %15s %25s %15s ", i, f.name().fullName(), f.name().firstName(),
                        f.name().lastName(), f.address().country(), f.phoneNumber().cellPhone()))
                .forEach(System.out::println);
        System.out.println("-".repeat(120));
        IntStream.range(1, 10)
                .mapToObj(i -> "%02d %30s %20s %15s %25s %15s".formatted(i, f.name().fullName(), f.name().firstName(),
                        f.name().lastName(), f.address().country(), f.phoneNumber().cellPhone()))
                .forEach(System.out::println);
    }
}
