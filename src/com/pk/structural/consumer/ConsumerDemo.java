package com.pk.structural.consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("C1 = "+s);
        Consumer<String> c2 = s -> System.out.println("C2 = "+s);
        Consumer<String> c3 = s -> {
            c1.process(s);
            c2.process(s);
        };

        /**
         * The method will process the consumers in sequence.
         */
        c3.process("Hello Consumer");

        System.out.println("Processing with andThen Method definition.");

        Consumer<String> c4 = c1.andThen(c2);
        c4.process("Hello C4" );
    }
}
