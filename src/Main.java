import zadanie1.*;
import zadanie2.*;
import zadanie3.*;

import java.util.*;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Лабораторная №4 \n");

        // ЗАДАНИЕ 1
        System.out.println(" ЗАДАНИЕ 1: ОБОБЩЕННЫЕ ТИПЫ ");

        System.out.println("-- ComparableCustom --");
        Person p1 = new Person("Иван", 20);
        Person p2 = new Person("Пётр", 25);
        System.out.println(p1 + " сравнивается с " + p2 + ": " + p1.сравнить(p2));
        System.out.println();

        System.out.println("-- MutableArray --");
        MutableArray<String> mArr = new MutableArray<>(3);
        mArr.add("a"); mArr.add("b"); mArr.add("c");
        System.out.println("MutableArray: " + mArr);
        System.out.println();

        // ЗАДАНИЕ 2
        System.out.println(" ЗАДАНИЕ 2: ПАРАМЕТРИЗАЦИИ ");

        System.out.println("-- ImmutableValueList --");
        ImmutableValueList imm = new ImmutableValueList(1, 2, 3);
        System.out.println("ImmutableList: " + imm);
        System.out.println();

        System.out.println("-- ListFiller --");
        List<Integer> numbers = new ArrayList<>();
        ListFiller.fillNumbers(numbers);
        System.out.println("Filled numbers (первые 5 элементов): " + numbers.subList(0, 5) + " ...");
        System.out.println();

        // ЗАДАНИЕ 3
        System.out.println(" ЗАДАНИЕ 3: ОБОБЩЕННЫЕ МЕТОДЫ ");

        List<String> strList = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = Utils.map(strList, String::length);
        System.out.println("-- Функция map (длина строк) --");
        System.out.println("Strings: " + strList);
        System.out.println("Lengths: " + lengths);
        System.out.println();

        List<Integer> nums = Arrays.asList(1, -3, 7);
        List<Integer> absList = Utils.map(nums, x -> x < 0 ? -x : x);
        System.out.println("-- Функция map (модуль чисел) --");
        System.out.println("Numbers: " + nums);
        System.out.println("Absolute values: " + absList);
        System.out.println();

        List<String> filtered = Utils.filter(strList, s -> s.length() >= 3);
        System.out.println("-- Функция filter (строки длиной >=3) --");
        System.out.println("Filtered strings: " + filtered);
        System.out.println();

        int sum = Utils.reduce(nums, 0, Integer::sum);
        System.out.println("-- Функция reduce (сумма чисел) --");
        System.out.println("Sum: " + sum);
        System.out.println();

        Set<String> set = Utils.toSet(Arrays.asList("qwerty", "asdfg", "qwerty"));
        System.out.println("-- Функция collect (уникальные элементы в Set) --");
        System.out.println("Unique set: " + set);

        scanner.close();
        System.out.println("\n Конец лабораторной работы ");
    }
}
