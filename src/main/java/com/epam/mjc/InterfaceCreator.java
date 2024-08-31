package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return stringList -> {
            for (String string : stringList) {
                char c = string.charAt(0);
                if (!Character.isUpperCase(c)) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integerList -> {

            List<Integer> integerList2 = new ArrayList<>();

            integerList.forEach(x -> {
                if (x % 2 == 0) {
                    integerList2.add(x);
                }
            });

            integerList.addAll(integerList2);

        };
    }

    public Supplier<List<String>> filterCollection(List<String> values)
    {

       return () -> {
           List<String> filteredValues = new ArrayList<>();
           values.forEach(x -> {

               char c = x.charAt(0);
               String[] split = x.split(" ");
               if (split.length > 3 && Character.isUpperCase(c) && x.endsWith(".")) {
                   filteredValues.add(x);
               }
           });

           return filteredValues;
       };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {

        return stringList -> {
            Map<String, Integer> map = new HashMap<>();
            stringList.forEach(x -> map.put(x, x.length()));
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>(list1);
            list.addAll(list2);
            return list;
        };
    }
}
