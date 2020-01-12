package _13_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {
        /*Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 1024;
            }
        };*/
        Function<String, Integer> function = s -> {
            return 1024;
        };
        System.out.println(function.apply("chenbin113"));

        /*Predicate<List> predicate = new Predicate<List>() {
            @Override
            public boolean test(List list) {
                return false;
            }
        };*/
        Predicate<List> predicate = list -> {
            return list.isEmpty();
        };
        //是 空 true
        System.out.println(predicate.test(new ArrayList(3)));

        /*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };*/

        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("chenbin113");

        /*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "chenbin113";
            }
        };*/

        Supplier<String> supplier = () -> {
            return "chenbin113";
        };
        System.out.println(supplier.get());
    }
}
