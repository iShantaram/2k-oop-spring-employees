package com.agapov.experiments;

import java.util.*;

public class Setandmaptasks {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        //List<Integer> nums = new ArrayList<>(List.of(6, 6, 12, 7, 11, 8, 2, 3, 4, 4, 5, 5, 0, 6, 7));

        task1(nums);
        task2(nums);

        String text = "Напишите код, который !выводит в консоль все уникальные слова из списка слов, в котором могут встречаться дубли. " +
                "Код должен работать с любой последовательностью и объемом списка слов.";
        List<String> words = new ArrayList<>(List.of(text.split("[\\p{Punct}\\s]")));
        task3(words);

        List<String> strings = new ArrayList<>(List.of("один", "два","два", "три", "три", "три"));
        task4(strings);

        //task4(words);
    }

    //    Напишите код, с помощью которого можно напечатать только нечетные числа в консоль.
    //    Код должен работать с любой последовательностью и объемом списка чисел.
    public static void task1(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 != 0) result.add(num);
        }
        System.out.println(result);
    }

    //    Напишите код, с помощью которого можно напечатать только четные числа без повторений в порядке возрастания.
    //    Код должен работать с любой последовательностью и объемом списка чисел.
    public static void task2(List<Integer> nums) {
        Set<Integer> result = new TreeSet<>();
        for (Integer num : nums) {
            if (num % 2 == 0) result.add(num);
        }
        System.out.println(result);
    }

    /*  Напишите код, который выводит в консоль все уникальные слова из списка слов, в котором могут встречаться дубли.
    Код должен работать с любой последовательностью и объемом списка слов.
    В качестве отладочной информации возьмите произвольный набор слов или текст, в котором встречаются повторения.*/
    public static void task3(List<String> words) {
        Set<String> result = new TreeSet<>(words);
        System.out.println(result);
    }

    /*   Напишите код, который выводит в консоль количество дублей для каждого уникального слова.
    Код должен работать с любой последовательностью и объемом списка слов.*/
    public static void task4(List<String> strings) {
        Map<String, Integer> result = new HashMap<>();
        for (String str:strings) {
            if (result.containsKey(str)) {
                result.put(str, result.get(str)+1);
            } else {
                result.put(str, 1);
            }
        }
        System.out.println(result.values());
    }
}
