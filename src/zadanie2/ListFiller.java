package zadanie2;

import java.util.List;

// Класс с утилитным методом для заполнения списка числами от 1 до 100
public final class ListFiller {
    // Приватный конструктор, чтобы нельзя было создавать экземпляры
    private ListFiller() {}

    // Метод заполняет переданный список числами от 1 до 100
    // Используется обобщение ? super Integer, чтобы метод принимал List<Integer> или List<Number>
    public static void fillNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 100; i++) {
            list.add(i); // добавляем числа по порядку
        }
    }
}
