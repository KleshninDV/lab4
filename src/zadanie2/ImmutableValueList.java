package zadanie2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Класс, представляющий неизменяемый список целых чисел
public final class ImmutableValueList {
    // Внутренний массив для хранения значений
    private final int[] values;

    // Конструктор по умолчанию — пустой список
    public ImmutableValueList() {
        values = new int[0];
    }

    // Конструктор с массивом начальных значений
    public ImmutableValueList(int[] initialValues) {
        Objects.requireNonNull(initialValues); // проверка на null
        values = Arrays.copyOf(initialValues, initialValues.length); // копирование массива
    }

    // Конструктор с первым элементом и остатком элементов через varargs
    public ImmutableValueList(int first, int... rest) {
        int[] arr = new int[1 + (rest == null ? 0 : rest.length)];
        arr[0] = first; // первый элемент
        if (rest != null) System.arraycopy(rest, 0, arr, 1, rest.length); // копируем остаток
        values = arr;
    }

    // Конструктор с List<Integer>
    public ImmutableValueList(List<Integer> list) {
        Objects.requireNonNull(list); // проверка на null
        values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) values[i] = list.get(i);
    }

    // Возвращает значение по индексу с проверкой границ
    public int get(int index) {
        rangeCheck(index);
        return values[index];
    }

    // Возвращает новый ImmutableValueList с изменённым элементом по индексу
    public ImmutableValueList set(int index, int newValue) {
        rangeCheck(index); // проверка границ
        int[] copy = Arrays.copyOf(values, values.length); // создаём копию массива
        copy[index] = newValue; // меняем значение
        return new ImmutableValueList(copy); // возвращаем новый объект
    }

    // Проверка, пуст ли список
    public boolean isEmpty() {
        return values.length == 0;
    }

    // Возвращает размер списка
    public int size() {
        return values.length;
    }

    // Возвращает копию внутреннего массива
    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    // Преобразует список в строку вида [элемент1, элемент2, ...]
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Проверяет, что индекс находится в пределах массива
    private void rangeCheck(int idx) {
        if (idx < 0 || idx >= values.length)
            throw new IndexOutOfBoundsException();
    }
}
